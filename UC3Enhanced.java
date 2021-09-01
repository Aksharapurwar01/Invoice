package invoice;

public class UC3Enhanced {
	
	 private static final double MINFARE = 5;
     private static final double MINCOSTPERKM = 10;
     private static final int COSTPERTIME = 1;
     
     public double calculateFare(double distance, int time) {
    	 double totalFare = distance * MINCOSTPERKM + time * COSTPERTIME;
    	 return Math.max(totalFare, MINFARE);
     }

     public double calculateFare(Ride[] rides) {
    	 double totalFare = 0;
    	 for (Ride ride:rides) {
         	totalFare += this.calculateFare(ride.distance, ride.time);
     }
    	 return (rides.length);
 }

}
