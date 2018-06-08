package pl.edu.agh.carhire.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.edu.agh.carhire.model.Customer;
import javax.validation.ConstraintViolationException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;

    @Test(expected = ConstraintViolationException.class)
    public void addEmptyCustomer(){
        Customer emptyCustomer = new Customer();
        entityManager.persist(emptyCustomer);
        customerRepository.flush();
    }

    @Test
    public void addProperCustomer(){
        Customer properCustomer=new Customer();

        properCustomer.setId(1L);
        properCustomer.setFirstName("Test");
        properCustomer.setLastName("Customer");
        properCustomer.setPhone("123456789");
        properCustomer.setEmail("test@customer.com");

        entityManager.merge(properCustomer);
        Assert.assertEquals(customerRepository.findByLastName("Customer").size(),1);
    }
}