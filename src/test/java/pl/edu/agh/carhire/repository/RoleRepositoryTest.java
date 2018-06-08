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
import pl.edu.agh.carhire.model.Role;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DataJpaTest
public class RoleRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RoleRepository roleRepository;

    @Test(expected = DataIntegrityViolationException.class)
    public void addEmptyRoleTest(){
        Role emptyRole=new Role();
        entityManager.persist(emptyRole);
        roleRepository.flush();
    }

    @Test
    public void addProperRoleTest(){
        Role properRole=new Role();

        properRole.setId(1L);
        properRole.setName("Test");
        entityManager.merge(properRole);
        Assert.assertEquals(roleRepository.findByName("Test"),properRole);
    }
}