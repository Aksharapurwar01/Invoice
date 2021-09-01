package invoice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
public class RidesReposi {
	
	static Map<String, List<Ride>> map = new HashMap();

    public Map<String, List<Ride>> addRideForUser(Ride ride, String userID) {
        if (map.containsKey(userID)) {
            List<Ride> rides = map.get(userID);
            rides.add(ride);
        } else {
            List<Ride> ride1 = new ArrayList<Ride>();
            ride1.add(ride);
            map.put(userID, ride1);
        }
        return map;
    }

    public static List<Ride> getRideForUser(String userID) {
        return (List<Ride>) (map.containsKey(userID)? map.get(userID): Collections.emptyList());
    }

}
