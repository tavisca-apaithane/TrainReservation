package train.da;

import train.Station;
import train.Train;
import train.TrainBooking;
import train.dp.StationRepo;
import train.dp.TrainRepo;

import java.util.ArrayList;

public class TrainDAO {

    private TrainRepo trainRepo;
    private StationRepo stationRepo;
    public TrainDAO(){}
    public TrainDAO(TrainRepo trainRepo, StationRepo stationRepo){
        this.trainRepo = trainRepo;
        this.stationRepo = stationRepo;
    }

    private void saveTrainRouteToStationRepo(String trainRoute){
        for(String station : trainRoute.split("-")){
            if(stationRepo.findById(station).isPresent()){
                System.out.println("here");
            }
            else {
                stationRepo.save(new Station(station, new ArrayList<Train>()));
                System.out.println("station save");
            }
            }
    }
    private void saveTrainStationsToTrainStationList(Train train, String trainRoute){
        for(String station : trainRoute.split("-")){
            train.getStations().add(new Station(station, new ArrayList<Train>()));
        }
    }
    private void saveTrainToStationsInTrainRoute(Train train, String trainRoute){
        for(String station : trainRoute.split("-")){
           if(stationRepo.findById(station).isPresent())
            {
                System.out.println(station+ " here");
                Station stn = stationRepo.findById(station).get();
                stn.getTrains().add(train);
                stationRepo.save(stn);
            }
        }
    }
    private void saveStationsFromTrainRoute_TrainStations(Train train, String trainRoute){
        for(String station : trainRoute.split("-")){
            if(stationRepo.findById(station).isPresent())
            train.getStations().add(stationRepo.findById(station).get());
        }
    }


public boolean addNewTrainWithItsStations(String trainId, String trainName,
                                          String trainRoute, String trainCapacity,
                                          String arrivalAtStartStation, String departureFromStartStation){
            if(trainRepo.findById(trainId).isPresent()){
                return false;
            }
            else {
                saveTrainRouteToStationRepo(trainRoute);
                Train train1 = new Train(trainId, trainName, trainRoute, trainCapacity, arrivalAtStartStation, departureFromStartStation, new ArrayList<TrainBooking>(), new ArrayList<Station>());
//			train1.getBookings().add(new TrainBooking("1", "abhishek","22", "Male","b","d","21-12-19"));
//			train1.getBookings().add(new TrainBooking("3", "bibek","22", "Male","c","d","20-12-19"));
                saveTrainStationsToTrainStationList(train1, trainRoute);
                trainRepo.save(train1);
                saveTrainToStationsInTrainRoute(train1, trainRoute);

//			Station stan = stationRepo.findById("nashik").get();
//			for(Train t : stan.getTrains()){
//                System.out.println(t.getTrainName());
//            }
//    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&");

                saveStationsFromTrainRoute_TrainStations(train1, trainRoute);

                trainRepo.save(train1);
                if (trainRepo.findById(train1.getTrainId()).isPresent())
                    return true;
                else
                    return false;
            }
}
public void doBooking(String trainId, String seatId, String passengerName, String age, String gender, String startStation, String endStation, String date){
    if(trainRepo.findById(trainId).isPresent()) {
        Train train = trainRepo.findById(trainId).get();
        train.getBookings().add(new TrainBooking(seatId, passengerName, age, gender, startStation, endStation, date));
        trainRepo.save(train);
    }
}


public boolean checkIfTrainExists(String trainId){
    if(trainRepo.findById(trainId).isPresent())
        return true;
    else return false;
}




public Train getTrain(String trainId){
        Train train = null;
        if(trainRepo.findById(trainId).isPresent())
        {
            train = trainRepo.findById(trainId).get();
        }
    return train;
}




}

