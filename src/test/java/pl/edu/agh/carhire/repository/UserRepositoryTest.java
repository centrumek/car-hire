package pl.edu.agh.carhire.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;
import pl.edu.agh.carhire.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test(expected = DataIntegrityViolationException.class)
    public void addEmptyUserTest(){
        User emptyUser=new User();
        entityManager.persist(emptyUser);
        userRepository.flush();
    }

    @Test
    public void addProperUserTest(){
        User properUser=new User();

        properUser.setId(1L);
        properUser.setUsername("Test");
        properUser.setPassword("pass1234");
        properUser.setFirstName("Test");
        properUser.setLastName("User");
        properUser.setEnabled(true);

        entityManager.merge(properUser);
        Assert.assertEquals(userRepository.findByUsername("Test"),properUser);
    }
}