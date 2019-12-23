package train.dp;

import org.springframework.data.repository.CrudRepository;
import train.models.Station;

public interface StationRepo extends CrudRepository<Station, String> {

}
