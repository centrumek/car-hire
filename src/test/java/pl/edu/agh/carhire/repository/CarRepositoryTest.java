package pl.edu.agh.carhire.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.edu.agh.carhire.model.Car;
import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository carRepository;


    @Test(expected = ConstraintViolationException.class)
    public void addEmptyCarTest(){
        Car emptyCar = new Car();
        entityManager.persist(emptyCar);
        carRepository.flush();
    }

    @Test
    public void addProperCarTest(){
        Car properCar=new Car();

        properCar.setId(1L);
        properCar.setCarBrand("Mercedes");
        properCar.setCarModel("K540");
        properCar.setNumberOfSeats(5);
        properCar.setColor("black");
        properCar.setNote("tmp");
        properCar.setPricePerDay(BigDecimal.ONE);

        entityManager.merge(properCar);
        Assert.assertEquals(carRepository.findByCarModel("K540").size(),1);
    }

}