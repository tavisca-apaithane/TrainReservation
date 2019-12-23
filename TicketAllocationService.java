package train;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import train.dp.TrainRepo;


import java.util.Optional;
@Service
public class TicketAllocationService {
    @Autowired
    private TrainRepo trainRepo;

    public SeatAvailabilityCalculator calculator;

    private Train train;
    public TicketAllocationService(){}
   public TicketAllocationService(TrainRepo trainRepo, String trainId ){
       this.trainRepo = trainRepo;
       this.train = trainRepo.findById(trainId).get();
       this.calculator = new SeatAvailabilityCalculator(train.getTrainRoute(), train.getTrainCapacity());
   }

    public Integer getSeatNumber(String date){

        Optional<Train> optional = trainRepo.findById(this.train.getTrainId());

       if(optional.isPresent()) {
           Train train = optional.get();
           for(TrainBooking booking: train.getBookings()){
               if(booking.getDate().equals(date)) {
                   calculator.numberOfSeatsArrayModify(booking.getStartStation(), booking.getEndStation());
               }
               }

           printData(calculator.numberOfSeatsPerRoute);

           if(calculator.arrayMin<=0)
               return -1;
           else return calculator.arrayMin;
       }
        else {
           return -2;
       }

    }

    public void loadSeatAvailabilityArray(String date) {
        Optional<Train> optional = trainRepo.findById(this.train.getTrainId());

        if (optional.isPresent()) {
            Train train = optional.get();
            for (TrainBooking booking : train.getBookings()) {
                if (booking.getDate().equals(date)) {
                    calculator.numberOfSeatsArrayModify(booking.getStartStation(), booking.getEndStation());
                }
            }
            printData(calculator.numberOfSeatsPerRoute);
            System.out.println("-----------------");
        }
    }
        private void printData(Integer[] arr){
            for(int i=0;i<arr.length;i++)
                System.out.print(arr[i]+ " ");
        }
    public int getSourceToDestinationCapacity(String source, String destination){
       int index = 0;
       int min = 9999;
       int flag=0;
       int startInd=0;
       for(int i=0;i<calculator.trainRoute.length;i++)
       {
           if(calculator.trainRoute[i].equals(source))
           {
               startInd= i;
               break;
           }
       }
        for(int i=(startInd+1);i< calculator.trainRoute.length; i++){

                System.out.println(calculator.numberOfSeatsPerRoute[i]);
                if(min>calculator.numberOfSeatsPerRoute[i])
                    min = calculator.numberOfSeatsPerRoute[i];

            if(calculator.trainRoute[i].equals(destination))
                break;
        }
        return min;

    }


}
