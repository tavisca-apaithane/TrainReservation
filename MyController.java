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
    public int getTrain(){

        TrainDAO trainManager = new TrainDAO(trainRepo, stationRepo);
        Train train = trainManager.getTrain("1");
        TicketAllocationService ticket = new TicketAllocationService(trainRepo, "1");
        ticket.loadSeatAvailabilityArray("23-12-19");
        return ticket.getSourceToDestinationCapacity("pune", "delhi");
//        int seatId = ticket.getSeatNumber( "20-12-19");
//        System.out.println(seatId);
//        boolean result = false;
//        if(seatId>0) {
//            result = true;
//            train.getBookings().add(new TrainBooking(Integer.toString(seatId), "abhishek", "22", "Male", "pune", "mumbai", "20-12-19"));
//            trainRepo.save(train);
//        }
//        System.out.println(result);
//        return Integer.toString(new TicketAllocationService(trainRepo).getSeatNumber("1","20-12-19"));
    }
    @GetMapping("/save")
    public String saveData(){

        TrainDAO trainManager = new TrainDAO(trainRepo, stationRepo);
        trainManager.addNewTrainWithItsStations("1", "sahyadri express", "nashik-pune-mumbai-delhi", "10", "8 pm", "8.05 pm");
        TicketAllocationService ticketAllocationService = new TicketAllocationService(trainRepo, "1");

        ticketAllocationService.getSeatNumber("23-12-19");
        System.out.println("-----------------------");
        trainManager.doBooking("1", "1", "abhishek",
                "22", "male", "nashik", "delhi", "23-12-19");
        ticketAllocationService.getSeatNumber( "23-12-19");
        System.out.println("-----------------------");
        trainManager.doBooking("1", "2", "abhishek",
                "22", "male", "pune", "mumbai", "23-12-19");
        ticketAllocationService.getSeatNumber("23-12-19");
        System.out.println("-----------------------");
        trainManager.doBooking("1", "3", "abhishek",
                "22", "male", "mumbai", "delhi", "23-12-19");
        ticketAllocationService.getSeatNumber( "23-12-19");
        System.out.println("-----------------------");
        trainManager.doBooking("1", "4", "abhishek",
                "22", "male", "nashik", "mumbai", "23-12-19");
        ticketAllocationService.getSeatNumber("23-12-19");
        System.out.println("-----------------------");
        return "success";
    }
}
