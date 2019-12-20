package train;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Station {
    @Id
    private String stationName;
    @ElementCollection
    List<Train> trains;

    public Station(){}
    public Station(String stationName, List<Train> trains ){
        this.stationName = stationName;
        this.trains = trains;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public List<Train> getTrain() {
        return trains;
    }

    public void setTrain(List<Train> trains) {
        this.trains = trains;
    }


}
