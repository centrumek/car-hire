package pl.edu.agh.carhire.service.impl;

import pl.edu.agh.carhire.model.Hire;
import pl.edu.agh.carhire.repository.HireRepository;
import pl.edu.agh.carhire.service.HireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
class HireServiceImpl implements HireService {

	@Autowired
	private HireRepository hireRepository;

	@Override
	public Hire findOne(Long id) {
		return hireRepository.findById(id).get();
	}

	@Override
	public List<Hire> findAll() {
		return hireRepository.findAll();
	}

	@Override
	public List<Hire> findByHireDate(Date hireDate) {
		return hireRepository.findByHireDate(hireDate);
	}

	@Override
	public Hire save(Hire hire) {
		return hireRepository.save(hire);
	}

	@Override
	public void remove(Long id) throws IllegalArgumentException {
		Hire hire = hireRepository.getOne(id);
		System.out.println(hire);
		hireRepository.delete(hire);
		hireRepository.flush();
	}
}
