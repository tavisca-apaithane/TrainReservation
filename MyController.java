package train;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private TrainRepo trainRepo;
    @GetMapping("/train")
    public String getTrain(){
        TicketAllocationService ticketService = new TicketAllocationService(trainRepo);
        String s = ticketService.getSeatNumber("1").toString();
        return s;
    }
}
