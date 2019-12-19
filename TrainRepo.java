package train;

import org.springframework.data.repository.CrudRepository;

public interface TrainRepo extends CrudRepository<Train, String> {
//    public String findById(String id);
}
