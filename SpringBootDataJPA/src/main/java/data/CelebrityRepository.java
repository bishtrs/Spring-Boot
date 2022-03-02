package data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CelebrityRepository extends CrudRepository<Celebrity, Long> {

	List<Celebrity> findByName(String name);

	Celebrity findById(long id);
}