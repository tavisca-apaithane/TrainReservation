package train.da;

import train.models.Station;
import train.models.Train;
import train.dp.StationRepo;
import train.dp.TrainRepo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StationDao {

    public StationDao(){}
    private TrainRepo trainRepo;
    private StationRepo stationRepo;
    public StationDao(TrainRepo trainRepo, StationRepo stationRepo){
        this.trainRepo = trainRepo;
        this.stationRepo = stationRepo;
    }
    public void addStation(String stationName){
        stationRepo.save(new Station(stationName, new ArrayList<Train>()));
    }

    public void addTrainToStation(String stationName, String trainId) {
        if(stationRepo.findById(stationName).isPresent()) {
            if(trainRepo.findById(trainId).isPresent()) {
                stationRepo.findById(stationName).get().getTrains().add(trainRepo.findById(trainId).get());
            }
            }
    }

    private List<Train> getListOfTrainsPassing(String stationName){
        List<Train> trains = null;
        if(stationRepo.findById(stationName).isPresent()) {
            trains = stationRepo.findById(stationName).get().getTrains();
        }
        if(trains!=null) {
            Set<Train> trainSet = new HashSet<>(trains);
            trains = new ArrayList<>(trainSet);
        }
        return trains;
    }

    private List<String> getListOfIdsOfTrainsPassing(String stationName){
        List<Train> trains = this.getListOfTrainsPassing(stationName);
        List<String> trainIds = new ArrayList<>();
        for(Train train : trains){
            trainIds.add(train.getTrainId());
        }
        return trainIds;
    }

    public List<Train> getListOfTrainsPassingFromSourceToDestination(String source, String destination){
        List<String> trainIdsPassingSource = this.getListOfIdsOfTrainsPassing(source);
        List<String> trainIdsPassingDestination = this.getListOfIdsOfTrainsPassing(destination);
        List<String> trainIdsFromSourceToDestination = new ArrayList<String>();
        List<String> validTrains = new ArrayList<String>();
        List<Train> result = new ArrayList<>();
        for(String sourceTrainId : trainIdsPassingSource){
            if(trainIdsPassingDestination.contains(sourceTrainId)){
                trainIdsFromSourceToDestination.add(sourceTrainId);
            }
        }
        for(String trainId: trainIdsFromSourceToDestination){
            if(this.checkDirection(trainId, source, destination)){
                validTrains.add(trainId);
            }
        }
        for(String trnId: validTrains){
            if(trainRepo.findById(trnId).isPresent())
            {
                result.add(trainRepo.findById(trnId).get());
            }
        }
        return result;
    }

    private boolean checkDirection(String trainId, String source, String destination) {

        Train train = new TrainDAO(trainRepo, stationRepo).getTrain(trainId);
        String[] route = train.getTrainRoute().split("-");
        int i = this.getIndex(route, source);
        int j = this.getIndex(route, destination);
        if(i<j)
            return true;
        else
            return false;


    }

    private int getIndex(String[] array, String target){
        int length = array.length;
        for(int i = 0; i<length; i++){
            if(array[i].equals(target)){
                return i;
            }
        }
       return 0;
    }
    public Station getStation(String stationName){
        Station station = null;
        if(stationRepo.findById(stationName).isPresent()){
            station = stationRepo.findById(stationName).get();
        }
        return station;
    }

}
