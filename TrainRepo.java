package train;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepo extends CrudRepository<Train, String> {
//    public String findById(String id);

}
