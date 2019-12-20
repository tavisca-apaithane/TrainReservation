package train;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;
@Service
public class TicketAllocationService {
    private SeatAvailabilityCalculator seatAvailabilityCalculator;
    @Autowired
    private TrainRepo trainRepo;

   public TicketAllocationService(TrainRepo trainRepo){
       this.trainRepo = trainRepo;
   }

    public Integer getSeatNumber(String trainId){

        Optional<Train> optional = trainRepo.findById(trainId);

       if(optional.isPresent()) {
           Train train = optional.get();
           SeatAvailabilityCalculator calculator = new SeatAvailabilityCalculator(train.getTrainRoute(), train.getTrainCapacity());
           for(TrainBooking booking: train.getBookings()){
               calculator.numberOfSeatsArrayModify(booking.getStartStation(), booking.getEndStation());
           }
           if(calculator.arrayMin==0)
               return -1;
           else return calculator.arrayMin;
       }
        else {
           return -2;
       }

    }
}