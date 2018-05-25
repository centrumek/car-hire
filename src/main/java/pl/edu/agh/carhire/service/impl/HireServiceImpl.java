package pl.edu.agh.carhire.service.impl;

import pl.edu.agh.carhire.model.Rental;
import pl.edu.agh.carhire.repository.RentalRepository;
import pl.edu.agh.carhire.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RentalServiceImpl implements RentalService {

	@Autowired
	private RentalRepository rentalRepository;

	@Override
	public Rental findOne(Long id) {
		return rentalRepository.findById(id).get();
	}

	@Override
	public List<Rental> findAll() {
		return rentalRepository.findAll();
	}

	@Override
	public List<Rental> findByRentalDate(Date rentalDate) {
		return rentalRepository.findByRentalDate(rentalDate);
	}

	@Override
	public List<Rental> findByRentalDateGreaterThanEqualAndReturnDateLessThanEqual(Date rentalDate, Date returnDate) {
		return rentalRepository.findByRentalDateGreaterThanEqualAndReturnDateLessThanEqual(rentalDate,returnDate);
	}

	@Override
	public Rental save(Rental rental) {
		return rentalRepository.saveAndFlush(rental);
	}

	@Override
	public void remove(Long id) throws IllegalArgumentException {
		rentalRepository.deleteById(id);
	}
}
