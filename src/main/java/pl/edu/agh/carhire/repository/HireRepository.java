package pl.edu.agh.carhire.repository;

import pl.edu.agh.carhire.model.Hire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface HireRepository extends JpaRepository<Hire, Long> {
	List<Hire> findByHireDate(Date hireDate);
}
