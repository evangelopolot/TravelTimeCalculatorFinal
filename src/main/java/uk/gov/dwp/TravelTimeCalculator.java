package uk.gov.dwp;

import java.util.*;

public class TravelTimeCalculator {
    private Map<String, Map<String, String>> travelTimes;
    private Set<String> recognisedLocations;

    public TravelTimeCalculator(){
        travelTimes = new HashMap<>();
        recognisedLocations = new HashSet<>();
        recognisedLocations.add("Blackpool");
        recognisedLocations.add("Manchester");
        recognisedLocations.add("Leeds");
        recognisedLocations.add("London");
        recognisedLocations.add("Newcastle");
    }

    public String getTravelTime(String fromLocation, String toLocation) {
        String travelTime = "";
        if(fromLocation.equals(toLocation)){
            return "00:00";
        }
        return travelTimes.get(fromLocation).get(toLocation);
    }

    public void setTravelTime(String fromLocation, String toLocation, String travelTime) {

        if(!travelTimes.containsKey(fromLocation)){
            travelTimes.put(fromLocation,new HashMap<>());
        }

        String[] timeParts = travelTime.split(":");
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);
        int time = hours * 60 + minutes;

        int hoursFormat = time / 60;
        int minutesFormat = time % 60;
        String formatedTime = String.format("%d:%02d", hoursFormat ,minutesFormat);

        travelTimes.get(fromLocation).put(toLocation,formatedTime);
    }

    public void getTravelTimes(String fromLocation, String toLocation){

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

    public void addLocation(String newLocation) {
        recognisedLocations.add(newLocation);
    }
}
