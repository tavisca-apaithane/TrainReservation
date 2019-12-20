package train;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@Bean
	public CommandLineRunner demo(TrainRepo trainRepo){
		return (args)-> {

			Train train1 = 	new Train("1", "sahyadri express", "a-b-c-d", "10", new ArrayList<TrainBooking>());
			Train train2 = 	new Train("2", "chennai express", "a-b-c-d-e-f", "10", new ArrayList<TrainBooking>());
			train1.getBookings().add(new TrainBooking("2", "shivam", "22", "Male", "a", "d", "20-12-19"));
			train1.getBookings().add(new TrainBooking("1", "abhishek","22", "Male","b","d","21-12-19"));
			train1.getBookings().add(new TrainBooking("3", "bibek","22", "Male","c","d","20-12-19"));
			trainRepo.save(train1);
			train2.getBookings().add(new TrainBooking("2", "shivam", "22", "Male", "a", "d", "20-12-19"));
			train2.getBookings().add(new TrainBooking("1", "abhishek","22", "Male","b","d","21-12-19"));
			train2.getBookings().add(new TrainBooking("3", "bibek","22", "Male","c","d","20-12-19"));
			trainRepo.save(train2);

			System.out.println(trainRepo.findById("1").get().getTrainName());
			System.out.println(trainRepo.findById("1").get().getTrainRoute());
			System.out.println(trainRepo.findById("2").get().getTrainName());
			System.out.println(trainRepo.findById("2").get().getTrainRoute());
//			Station station1 = new Station("nashik",Arrays.asList(train1,train2));
//			stationRepo.save(station1);
//			Station station2 = new Station("nashik",Arrays.asList(train1,train2));
//			stationRepo.save(station2);
		};
	}
}
