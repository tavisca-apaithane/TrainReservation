package train.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Train {
    @Id
    private String trainId;
    private String trainName;
    private String trainRoute;
    private String trainCapacity;
    @ElementCollection
    private List<TrainBooking> bookings;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Station> stations;
    private String trainArrivalAtStartStation;
    private String trainDepartureFromStartStation;

    public Train(){}
    public Train(String trainId, String trainName, String trainRoute, String trainCapacity,
                 String trainArrivalAtStartStation, String trainDepartureFromStartStation,
                 List<TrainBooking> bookings, List<Station> stations) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.trainRoute = trainRoute;
        this.trainCapacity = trainCapacity;
        this.trainArrivalAtStartStation = trainArrivalAtStartStation;
        this.trainDepartureFromStartStation = trainDepartureFromStartStation;
        this.bookings = bookings;
        this.stations = stations;
    }


    public String getTrainArrivalAtStartStation() {
        return trainArrivalAtStartStation;
    }

    public void setTrainArrivalAtStartStation(String trainArrivalAtStartStation) {
        this.trainArrivalAtStartStation = trainArrivalAtStartStation;
    }

    public String getTrainDepartureFromStartStation() {
        return trainDepartureFromStartStation;
    }

    public void setTrainDepartureFromStartStation(String trainDepartureFromStartStation) {
        this.trainDepartureFromStartStation = trainDepartureFromStartStation;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }


    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainRoute() {
        return trainRoute;
    }

    public void setTrainRoute(String trainRoute) {
        this.trainRoute = trainRoute;
    }

    public List<TrainBooking> getBookings() {
        return bookings;
    }

    public String getTrainCapacity() {
        return trainCapacity;
    }

    public void setTrainCapacity(String trainCapacity) {
        this.trainCapacity = trainCapacity;
    }

    public void setBookings(List<TrainBooking> bookings) {
        this.bookings = bookings;
    }
}
