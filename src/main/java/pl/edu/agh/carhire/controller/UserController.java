package pl.edu.agh.carhire.controller;

import pl.edu.agh.carhire.model.Role;
import pl.edu.agh.carhire.model.User;
import pl.edu.agh.carhire.service.RoleService;
import pl.edu.agh.carhire.service.UserService;
import pl.edu.agh.carhire.validator.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

/**
 * Klasa kontorlujaca kontekst uzytkownika
 */
@Controller
@Transactional
@RequestMapping("/admin/users")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	MessageSource messageSource;

	/**
	 * Metoda pobierjaaca liste rol do widoku.
	 */
	@ModelAttribute("roles")
	public List<Role> initializeProfiles() {
		return roleService.findAll();
	}

	/**
	 * Metoda restowa typu GET pobierajaca uzytkownikow po nazwie.
	 * @param userName nazwa uzytkownika
	 * @param model obiekt przeplywajacy miedzy frontem, a backendem.
	 * @return users.jsp
	 */
	@RequestMapping(method= RequestMethod.GET)
	public String getUsers(@RequestParam(value="userName", required=false) String userName, Model model) {
		Collection<User> users;
		if ((userName == null || "".equals(userName))) {
			users = userService.findAll();
		} else {
			users = new HashSet<>();
			User user = userService.findByUserName(userName);
			users.add(user);
		}
		model.addAttribute("users", users);

		return "users";
	}

	/**
	 * Metoda restowa typu GET inicjalzijaca nowego uzytkownika
	 * @param model obiekt przeplywajacy miedzy frontem, a backendem.
	 * @return addEditUser.jsp
	 */
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newUser(Model model) {
		model.addAttribute("user", new User());
		return "addEditUser";
	}

	/**
	 * Metoda restowa typu GET edytujaca uzytkownika
	 * @param id uzytkownika
	 * @param model obiekt przeplywajacy miedzy frontem, a backendem.
	 * @return addEditUser.jsp
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editUser(@PathVariable Long id, Model model) {
		User user = userService.findOne(id);

		user.getRoles().size();

		model.addAttribute("user", user);
		return "addEditUser";
	}

	/**
	 * Metoda restowa typu POST zapisujaca uzytkownika do bazy
	 * @param user uzytkownik do zapisu
	 * @param result wynik zwrotu
	 * @param model obiekt przeplywajacy miedzy frontem, a backendem.
	 * @param redirectAttributes atrubyt przekierowania
	 * @return addEditUser.jsp lub przekeirowanie do /admin/users/{userID}
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String saveUser(User user, BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		userValidator.validate(user, result);

		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return "addEditUser";
		}

		if (user.getId() == null && !userService.isUsernameUnique(user.getId(), user.getUsername())){
			FieldError ssoError = new FieldError("user","username", messageSource.getMessage("non.unique.username", new String[]{user.getUsername()}, Locale.getDefault()));
			result.addError(ssoError);
			return "addEditUser";
		}

		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "User saved successfully!");

		userService.save(user);

		return "redirect:/admin/users/" + user.getId();
	}

	/**
	 * Metoda restowa typu GET pobierjaca uzytkownika po ID
	 * @param id uzytkownika
	 * @param model obiekt przeplywajacy miedzy frontem, a backendem.
	 * @param authentication autentykacja
	 * @return showUser.jsp
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String viewUser(@PathVariable("id") Long id, Model model, Authentication authentication) {

		logger.debug("showUser() id: {}", id);

		User user = new User((User) authentication.getPrincipal());
		if (user == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "user not found");
		}

		model.addAttribute("user", user);

		return "showUser";

	}

	/**
	 * Metoda restowa typu GET usuwajaca uzytownika po iD
	 * @param id uzytkownika
	 * @param redirectAttributes atrubyt przekierowania
	 * @return przekierowanie do /users
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String removeUser(@PathVariable Long id, final RedirectAttributes redirectAttributes) {
		logger.debug("delete user: {}", id);

		userService.remove(id);

		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "User is deleted!");

		return "redirect:/users";
	}

}
