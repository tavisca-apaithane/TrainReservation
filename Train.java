package train;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Train {
    @Id
    private String trainId;
    private String trainName;
    private String trainRoute;
    @ElementCollection
    private List<TrainBooking> bookings;

    public Train(){}
    public Train(String trainId, String trainName, String trainRoute, List<TrainBooking> bookings) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.trainRoute = trainRoute;
        this.bookings = bookings;
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

    public void setBookings(List<TrainBooking> bookings) {
        this.bookings = bookings;
    }
}
