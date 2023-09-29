package uk.gov.dwp;

import java.util.*;

public class TravelTimeCalculator {
    private Set<String> recognisedLocations;

    public TravelTimeCalculator(){
        recognisedLocations = new HashSet<>();
        recognisedLocations.add("Blackpool");
        recognisedLocations.add("Manchester");
        recognisedLocations.add("Leeds");
        recognisedLocations.add("London");
        recognisedLocations.add("Newcastle");
    }
    public String getTravelTime(String fromLocation, String toLocation) {
        if(fromLocation.equals(toLocation)){
            return "00:00";
        }
        return "";
    }

    public String getTravelLocations() {

        StringBuilder locations = new StringBuilder();
        List<String> locationsSorted = new ArrayList<>(getRecognisedLocations());
        Collections.sort(locationsSorted);

        for (String location : locationsSorted){
            locations.append(location).append(",");
        }

        locations.setLength(locations.length() - 1);
        return locations.toString();
    }

    private Set<String> getRecognisedLocations(){
        return recognisedLocations;
    }

    public String getTravelDestinations() {
        return "";
    }

    public void setTravelTime(String fromLocation, String toLocation, String travelTime) {
    }

    public void addLocation(String newLocation) {
        recognisedLocations.add(newLocation);
    }
}
