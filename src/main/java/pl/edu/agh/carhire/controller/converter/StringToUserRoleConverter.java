package pl.edu.agh.carhire.controller.converter;

import pl.edu.agh.carhire.model.Role;
import pl.edu.agh.carhire.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


/**
 * A converter class used in views to map id's to actual Role objects.
 * 
 */
@Component
public class StringToUserRoleConverter implements Converter<String, Role> {

	@Autowired
	private RoleService roleService;

	@Override
	public Role convert(String element) {
		Long id = Long.parseLong((String)element);
		Role role = roleService.findOne(id);
		System.out.println("\n\n\nRole : " + role);
		return role;
	}
}
