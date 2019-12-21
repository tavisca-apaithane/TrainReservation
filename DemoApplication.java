package train;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import train.da.StationDao;
import train.da.TrainDAO;
import train.dp.StationRepo;
import train.dp.TrainRepo;

import java.util.ArrayList;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@Bean
	public CommandLineRunner demo(TrainRepo trainRepo, StationRepo stationRepo){
		return (args)-> {

//			TrainDAO trainManager = new TrainDAO(trainRepo, stationRepo);
//			System.out.println(trainManager.addNewTrainWithItsStations("4", "maharaja express",
//					"nashik-delhi", "10", "8.30 pm",
//					"8.35 pm"));
//			trainManager.doBooking("4", "1", "abhishek", "22", "male",
//					"nashik", "mumbai", "21-12-19");
//			System.out.println(trainManager.getTrain("4").getBookings().get(0).getPassengerGender());
////			System.out.println(trainManager.addNewTrainWithItsStations("2", "shatabdi express",
//					"nashik-pune-mumbai", "10", "7 pm",
//					"7.30 pm"));f
//			System.out.println(trainManager.addNewTrainWithItsStations("3", "shivneri express",
//					"nashik-pune", "10", "8.50 pm",
//					"9 pm"));


//
//			stationRepo.save(new Station("a", new ArrayList<Train>()));
//			stationRepo.save(new Station("b", new ArrayList<Train>()));
//			stationRepo.save(new Station("c", new ArrayList<Train>()));
//			stationRepo.save(new Station("d", new ArrayList<Train>()));
//			Train train1 = 	new Train("1", "sahyadri express", "a-b-c-d", "10", "8 pm","8.10 pm", new ArrayList<TrainBooking>(), new ArrayList<Station>());
//			System.out.println("check1");
//			train1.getBookings().add(new TrainBooking("2", "shivam", "22", "Male", "a", "d", "20-12-19"));
//			System.out.println("check2");
//			train1.getBookings().add(new TrainBooking("1", "abhishek","22", "Male","b","d","21-12-19"));
//			System.out.println("check3");
//			train1.getBookings().add(new TrainBooking("3", "bibek","22", "Male","c","d","20-12-19"));
//			System.out.println("check4");
//			train1.getStations().add(new Station("a", new ArrayList<Train>()));
//			System.out.println("check5");
//			trainRepo.save(train1);
//			System.out.println("check6");
//			stationRepo.findById("a").get().getTrains().add(train1);
//			trainRepo.findById("1").get().getStations().add(stationRepo.findById("a").get());
//
//



		};
	}
}
