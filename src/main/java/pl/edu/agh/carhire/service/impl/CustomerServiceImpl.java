package pl.edu.agh.carhire.service.impl;

import pl.edu.agh.carhire.model.Customer;
import pl.edu.agh.carhire.repository.CustomerRepository;
import pl.edu.agh.carhire.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;

@Service
class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer findOne(Long id) {
		return customerRepository.findById(id).get();
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Collection<Customer> findByLastNameAndFirstName(String lastName, String firstName) {
		return customerRepository.findByLastNameAndFirstNameOrderByLastNameAscAllIgnoreCase(lastName, firstName);
	}

	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void remove(Long id) throws IllegalArgumentException {
		Customer customer = customerRepository.findById(id).get();
		if (customer == null) {
			throw new IllegalArgumentException(String.format(
					"Customer with id=%d does not exist.", id));
		}
		customerRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Customer findOneWithHires(Long id) {
		return customerRepository.findByIdWithHires(id);
	}

}
