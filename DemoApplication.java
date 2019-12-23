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
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}
	public void printList(List<Train> trains){
		System.out.println(trains.size());
		for(Train train: trains){
			System.out.println(train.getTrainName());
		}
		System.out.println("******************");
	}
	@Bean
	public CommandLineRunner demo(TrainRepo trainRepo, StationRepo stationRepo){
		return (args)-> {


//			TrainDAO trainManager = new TrainDAO(trainRepo, stationRepo);
//			StationDao stationManager = new StationDao(trainRepo, stationRepo);
//			trainManager.addNewTrainWithItsStations("1", "sahyadri express", "nashik-pune-mumbai-delhi", "10", "8 pm", "8.05 pm");
//			trainManager.addNewTrainWithItsStations("2", "shivneri express", "nashik-pune-mumbai", "10", "8 pm", "8.05 pm");
//			trainManager.addNewTrainWithItsStations("3", "maharaja express", "nashik-pune", "10", "8 pm", "8.05 pm");
//
//			List<Train> trains = stationManager.getListOfTrainsPassingFromSourceToDestination("nashik", "mumbai");
//			printList(trains);
//
//			stationRepo.save(new Station("nashik", new ArrayList<Train>()));
//			stationRepo.save(new Station("pune", new ArrayList<Train>()));
//			stationRepo.save(new Station("mumbai", new ArrayList<Train>()));
//			stationRepo.save(new Station("delhi", new ArrayList<Train>()));
//			Train train1 = 	new Train("1", "sahyadri express", "nashik-pune-mumbai-delhi", "10", "8 pm","8.10 pm", new ArrayList<TrainBooking>(), new ArrayList<Station>());
//			Train train2 = 	new Train("2", "shivneri express", "nashik-pune-mumbai", "10", "8 pm","8.10 pm", new ArrayList<TrainBooking>(), new ArrayList<Station>());
//			Train train3 = 	new Train("3", "maharaja express", "nashik-pune", "10", "8 pm","8.10 pm", new ArrayList<TrainBooking>(), new ArrayList<Station>());
//
//
////			train1.getBookings().add(new TrainBooking("2", "shivam", "22", "Male", "a", "d", "20-12-19"));
//			System.out.println("check2");
//			train1.getBookings().add(new TrainBooking("1", "abhishek","22", "Male","b","d","21-12-19"));
//			System.out.println("check3");
//			train1.getBookings().add(new TrainBooking("3", "bibek","22", "Male","c","d","20-12-19"));
//			System.out.println("check4");
//			train1.getStations().add(new Station("nashik", new ArrayList<Train>()));
//			train2.getStations().add(new Station("nashik", new ArrayList<Train>()));
//			train3.getStations().add(new Station("nashik", new ArrayList<Train>()));
//			System.out.println("check5");
//			trainRepo.save(train1);
//			trainRepo.save(train2);
//			trainRepo.save(train3);
//			System.out.println("check6");
//			stationRepo.findById("nashik").get().getTrains().add(train1);
//			trainRepo.findById("1").get().getStations().add(stationRepo.findById("nashik").get());

////
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


		};
	}
}
