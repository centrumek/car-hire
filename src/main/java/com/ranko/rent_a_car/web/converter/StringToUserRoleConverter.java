package com.ranko.rent_a_car.web.converter;

import com.ranko.rent_a_car.model.Role;
import com.ranko.rent_a_car.service.RoleService;
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
