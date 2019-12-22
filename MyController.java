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

        return Integer.toString(new TicketAllocationService(trainRepo).getSeatNumber("1","22-12-19"));
    }
}
