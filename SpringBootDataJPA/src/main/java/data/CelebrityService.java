package data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CelebrityService {

	@Autowired
	private CelebrityRepository customerRepository;

	public void save(Celebrity customer) {
		customerRepository.save(customer);
	}

	public Celebrity findById(long id) {
		return customerRepository.findById(id);
	}

	public List<Celebrity> findAll() {
		return (List<Celebrity>) customerRepository.findAll();
	}

	List<Celebrity> findByName(String name) {
		return (List<Celebrity>) customerRepository.findByName(name);
	}

}
