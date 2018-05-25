package pl.edu.agh.carhire.service;

import pl.edu.agh.carhire.model.Customer;

import java.util.Collection;
import java.util.List;


public interface CustomerService {

	Customer findOne(Long id);
	List<Customer> findAll();
	Collection<Customer> findByLastName(String lastName);
	Collection<Customer> findByLastNameAndFirstName(String lastName, String firstName);
	Customer save(Customer customer);
	void remove(Long id) throws IllegalArgumentException;
	Customer findOneWithHires(Long id);
	Collection<Customer> findByLastNameWithRentals(String lastName);
}
