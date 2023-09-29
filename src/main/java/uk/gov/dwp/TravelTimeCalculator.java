package uk.gov.dwp;

import java.util.*;

public class TravelTimeCalculator {
    private Map<String, Map<String, String>> travelTimes;
    private Set<String> recognisedLocations;

    public TravelTimeCalculator(){
        travelTimes = new HashMap<>();
    }

    public String getTravelTime(String fromLocation, String toLocation) {
        if(fromLocation.equals(toLocation)){
            return "00:00";
        }
        return travelTimes.get(fromLocation).get(toLocation);
    }

    public void setTravelTime(String fromLocation, String toLocation, String travelTime) {

        if(!travelTimes.containsKey(fromLocation)){
            travelTimes.put(fromLocation,new HashMap<>());
        }
        if(!travelTimes.containsKey(toLocation)){
            travelTimes.put(toLocation,new HashMap<>());
        }

        String time = formatTime(travelTime);

        travelTimes.get(fromLocation).put(toLocation,time);
        travelTimes.get(toLocation).put(fromLocation, time);
    }
    public String formatTime(String travelTime){
        String[] timeParts = travelTime.split(":");
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);
        int time = hours * 60 + minutes;

        int hoursFormat = time / 60;
        int minutesFormat = time % 60;
        return String.format("%d:%02d", hoursFormat ,minutesFormat);
    }

    public String getTravelLocations() {

        StringBuilder locations = new StringBuilder();
        List<String> locationsSorted = new ArrayList<>(travelTimes.keySet());
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
