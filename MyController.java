package train;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import train.da.TrainDAO;
import train.dp.StationRepo;
import train.dp.TrainRepo;

@RestController
public class MyController {

    @Autowired
    public TrainRepo trainRepo;
    @Autowired
    public StationRepo stationRepo;
    @GetMapping("/train")
    public String getTrain(){

        TrainDAO trainManager = new TrainDAO(trainRepo, stationRepo);
        Train train = trainManager.getTrain("1");
        TicketAllocationService ticket = new TicketAllocationService(trainRepo);
        int seatId = ticket.getSeatNumber("1", "20-12-19");
        System.out.println(seatId);
        boolean result = false;
        if(seatId>0) {
            result = true;
            train.getBookings().add(new TrainBooking(Integer.toString(seatId), "abhishek", "22", "Male", "pune", "mumbai", "20-12-19"));
            trainRepo.save(train);
        }
        System.out.println(result);
        return Integer.toString(new TicketAllocationService(trainRepo).getSeatNumber("1","20-12-19"));
    }
}
