package train.dp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import train.models.Train;

@Repository
public interface TrainRepo extends CrudRepository<Train, String> {
//    public String findById(String id);

}
