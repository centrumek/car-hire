package pl.edu.agh.carhire.controller.converter;

import pl.edu.agh.carhire.model.Role;
import pl.edu.agh.carhire.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Klasa odpowiadajaca za konwertowanie id roli z typu String do Long.
 */
@Component
public class StringToUserRoleConverter implements Converter<String, Role> {

	@Autowired
	private RoleService roleService;

	@Override
	public Role convert(String element) {
		Long id = Long.parseLong((String)element);
		Role role = roleService.findOne(id);
		return role;
	}
}
