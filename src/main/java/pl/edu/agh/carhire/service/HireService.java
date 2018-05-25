package pl.edu.agh.carhire.service;

import pl.edu.agh.carhire.model.Hire;

import java.util.Date;
import java.util.List;


public interface HireService {

	Hire findOne(Long id);
	List<Hire> findAll();
	List<Hire> findByHireDate(Date hireDate);
	List<Hire> findByHireDateGreaterThanEqualAndReturnDateLessThanEqual(Date hireDate, Date returnDate);
	Hire save(Hire hire);
	void remove(Long id) throws IllegalArgumentException;
}
