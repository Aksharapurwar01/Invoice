package invoice;

import java.util.List;

public class InvoiceService {
	
	private static final double MINFARE = 5;
    private static final double MINCOSTPERKM = 10;
    private static final int COSTPERTIME = 1;
    RidesReposi ridesRepository = new RidesReposi();

    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINCOSTPERKM + time * COSTPERTIME;
        return Math.max(totalFare, MINFARE);
    }

    public InvoiceSummary calculateFare(List<Ride> rides) {
        double totalFare = 0;
        for (Ride ride:rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.size(), totalFare);
    }

    public void addRidesForUser(String userID, Ride ride) {
        RidesReposi ridesReposi = new RidesReposi();
		ridesReposi.addRideForUser(ride, userID);
    }

    public List<Ride> getRidesForUser(String userID) {
        return RidesReposi.getRideForUser(userID);
    }

    public InvoiceSummary calculateFare(String userID) {
        return calculateFare(getRidesForUser(userID));
    }

}
