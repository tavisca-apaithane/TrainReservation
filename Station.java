package train;

import javax.persistence.*;
import java.util.List;

@Entity
public class Station {
    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    @Id
    private String stationName;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Train> trains;

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