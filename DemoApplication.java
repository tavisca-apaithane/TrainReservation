package train;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(TrainRepo trainRepo){
	return (args)->{
		Train train1 = new Train("1", "sahyadri express", "A-b-c-d", new ArrayList<TrainBooking>());
		train1.getBookings().add(new TrainBooking("1", "abhishek", "22", "Male", "mumbai", "nashik","19-12-19"));
		trainRepo.save(train1);
		System.out.println("success");
	};
	}
}
