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

public boolean addNewTrainWithItsStations(String trainId, String trainName,
                                          String trainRoute, String trainCapacity,
                                          String arrivalAtStartStation, String departureFromStartStation){


        Train train = new Train(trainId, trainName, trainRoute, trainCapacity, arrivalAtStartStation,
                departureFromStartStation, new ArrayList<>(), new ArrayList<Station>());
    addStationsToStation_station(trainRoute);
    trainRepo.save(train);

//    addTrainToStation_trains(trainRoute, train);
//    addStationsToTrain_stations(train, trainRoute);
    return checkIfTrainExists(trainId);
}
public void doBooking(String trainId, String seatId, String passengerName, String age, String gender, String startStation, String endStation, String date){
    if(trainRepo.findById(trainId).isPresent())
        trainRepo.findById(trainId).get().getBookings().add(new TrainBooking(seatId, passengerName, age, gender, startStation, endStation, date));

}
public void addStationsToTrain_stations(Train train, String trainRoute){
        for(String station: trainRoute.split("-")){
            train.getStations().add(stationRepo.findById(station).get());
        }
}
public boolean checkIfTrainExists(String trainId){
    if(trainRepo.findById(trainId).isPresent())
        return true;
    else return false;
}
public void addStationsToStation_station(String trainRoute){
    for(String station: trainRoute.split("-"))
    {
        new StationDao(trainRepo, stationRepo).addStation(station);
    }
}
public void addTrainToStation_trains(String trainRoute, Train train){
    for(String station: trainRoute.split("-")){
        stationRepo.findById(station).get().getTrains().add(train);
    }
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

