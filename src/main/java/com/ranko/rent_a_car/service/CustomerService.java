package com.ranko.rent_a_car.service;

import com.ranko.rent_a_car.model.Customer;

import java.util.Collection;
import java.util.List;


public interface CustomerService {

	Customer findOne(Long id);
	List<Customer> findAll();
	Collection<Customer> findByLastName(String lastName);
	Collection<Customer> findByLastNameAndFirstName(String lastName, String firstName);
	Customer save(Customer customer);
	void remove(Long id) throws IllegalArgumentException;
	Customer findOneWithRentals(Long id);
	Collection<Customer> findByLastNameWithRentals(String lastName);
}
