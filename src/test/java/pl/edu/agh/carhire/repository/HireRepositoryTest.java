package pl.edu.agh.carhire.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.edu.agh.carhire.model.Hire;
import javax.validation.ConstraintViolationException;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DataJpaTest
public class HireRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private HireRepository hireRepository;

    @Test(expected = ConstraintViolationException.class)
    public void addEmptyHireTest(){
        Hire emptyHire = new Hire();
        entityManager.persist(emptyHire);
        hireRepository.flush();
    }

    @Test
    public void addProperHireTest(){
        Hire properHire=new Hire();

        properHire.setId(1L);
        properHire.setHireDate(new Date(1990,1,2));
        properHire.setReturnDate(new Date(2990,1,2));
        properHire.setNote("test");


        entityManager.merge(properHire);
        Assert.assertEquals(hireRepository.findByHireDate(new Date(1990,1,2)).size(),1);
    }
}