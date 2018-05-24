package com.ranko.rent_a_car.web;

import com.ranko.rent_a_car.model.Role;
import com.ranko.rent_a_car.model.User;
import com.ranko.rent_a_car.service.RoleService;
import com.ranko.rent_a_car.service.UserService;
import com.ranko.rent_a_car.validator.UserValidator;
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
	 * This method will provide Role list to views
	 */
	@ModelAttribute("roles")
	public List<Role> initializeProfiles() {
		return roleService.findAll();
	}

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

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newUser(Model model) {
		model.addAttribute("user", new User());
		return "addEditUser";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editUser(@PathVariable Long id, Model model) {
		User user = userService.findOne(id);

		/* if we want to have FetchType.LAZY(which is default for @OneToMany and @ManyToMany) for 'roles' collection
		in User entity, we will get this exception: org.hibernate.LazyInitializationException:
		failed to lazily initialize a collection of role: com.ranko.rent_a_car.model.User.roles, could not initialize proxy - no Session
		To avoid that, one way is to initialize collection while still have session (before going to view)
		*/
		user.getRoles().size();  // initializing collection

		model.addAttribute("user", user);
		return "addEditUser";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String saveUser(User user, BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		userValidator.validate(user, result);

		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return "addEditUser";
		}

		/*
         * Preferred way to achieve uniqueness of field [username] should be implementing custom @Unique annotation
         * and applying it on field [username] of Model class [User].
         *
         * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
         * framework as well while still using internationalized messages.
         *
         */
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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String viewUser(@PathVariable("id") Long id, Model model, Authentication authentication) {

		logger.debug("showUser() id: {}", id);

		User user = new User((User) authentication.getPrincipal());
//		User user = userService.findOneWithRoles(id);
		if (user == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "user not found");
		}

		model.addAttribute("user", user);

		return "showUser";

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String removeUser(@PathVariable Long id, final RedirectAttributes redirectAttributes) {
		logger.debug("delete user: {}", id);

		userService.remove(id);

		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "User is deleted!");

		return "redirect:/users";
	}

}
