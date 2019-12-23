package train;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import train.models.Train;

import java.util.List;


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

}
