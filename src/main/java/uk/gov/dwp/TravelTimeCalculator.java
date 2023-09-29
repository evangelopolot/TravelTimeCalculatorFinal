package uk.gov.dwp;

import java.util.*;

public class TravelTimeCalculator {
    private Set<String> recognisedLocations;

    public TravelTimeCalculator(){
        recognisedLocations = new HashSet<>();
    }
    public String getTravelTime(String fromLocation, String toLocation) {
        if(fromLocation.equals(toLocation)){
            return "00:00";
        }
        return "";
    }

    public String getTravelLocations() {
        recognisedLocations.add("Blackpool");
        recognisedLocations.add("Manchester");
        recognisedLocations.add("Leeds");
        recognisedLocations.add("London");
        recognisedLocations.add("Newcastle");

        StringBuilder locations = new StringBuilder();
        List<String> locationsSorted = new ArrayList<>(recognisedLocations);
        Collections.sort(locationsSorted);

        for (String location : locationsSorted){
            locations.append(location).append(",");
        }
        locations.setLength(locations.length() - 1);
        return locations.toString();
    }

    public String getTravelDestinations() {
        return "";
    }

    public void setTravelTime(String fromLocation, String toLocation, String travelTime) {
    }
}
