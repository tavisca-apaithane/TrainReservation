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
        System.out.println(trainManager.addNewTrainWithItsStations("1", "maharaja express",
                "nashik-delhi", "10", "8.30 pm",
                "8.35 pm"));
        trainManager.doBooking("1", "1", "abhishek", "22", "male",
                "nashik", "mumbai", "21-12-19");


        Train train = (Train) trainRepo.findById("1").get();
        System.out.println("here");
        return train.getBookings().get(0).getPassengerName();
    }
}
