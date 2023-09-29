package uk.gov.dwp;

public class TravelTimeCalculator {
    public String getTravelTime(String fromLocation, String toLocation) {
        if(fromLocation.equals(toLocation)){
            return "00:00";
        }
        return "";
    }

    public String getTravelLocations() {
        return "";
    }

    public String getTravelDestinations() {
        return "";
    }

    public void setTravelTime(String fromLocation, String toLocation, String travelTime) {
    }
}
