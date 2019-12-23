package train;

public class SeatAvailabilityCalculator {
    public String[] trainRoute;
    public Integer[] numberOfSeatsPerRoute;
    public Integer trainCapacity;
    public Integer routeSize;
    public int arrayMin;
    public SeatAvailabilityCalculator(String trainRoute, String trainCapacity){
        this.trainRoute = trainRoute.split("-");
        this.trainCapacity = Integer.parseInt(trainCapacity);
        this.arrayMin = this.trainCapacity;
        this.routeSize = this.trainRoute.length;
        this.numberOfSeatsPerRoute = new Integer[this.routeSize];
        for(int i=0; i<this.routeSize; i++)
            this.numberOfSeatsPerRoute[i] = this.trainCapacity;

    }
    public void numberOfSeatsArrayModify(String startStation, String endStation){

        int flag=0;
         for(int i=0; i<this.routeSize; i++){
             if(flag==0){
                 if(startStation.equals(this.trainRoute[i]))
                     flag=1;
             }
             else{
                 this.numberOfSeatsPerRoute[i]--;
                 if(endStation.equals(this.trainRoute[i]))
                     flag=0;
             }
             if(arrayMin>this.numberOfSeatsPerRoute[i])
                 arrayMin = this.numberOfSeatsPerRoute[i];
         }
//        for(int i: this.numberOfSeatsPerRoute)
//            System.out.print(i + " ");
    }
    public Integer getMin(){
        int min = 99999;
        for(int i: numberOfSeatsPerRoute)
        {
            if(min>i)
                min=i;
        }
        return min;
    }

}
