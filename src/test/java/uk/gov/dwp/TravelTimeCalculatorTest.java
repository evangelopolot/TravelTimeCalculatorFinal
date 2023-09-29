package uk.gov.dwp;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class TravelTimeCalculatorTest {

    @Test
    @DisplayName("When given from and to locations which are the same, return zero in time")
    public void testGetTravelTimeReturnsZeroTimeWhenBothLocationsAreTheSame(){
        TravelTimeCalculator calculator = new TravelTimeCalculator();
        String result = calculator.getTravelTime("Blackpool", "Blackpool");
        assertEquals("00:00", result, "Should return zero in format 'hh:mm'");
    }

    @Test
    @DisplayName("Given a not recognised location add to dictionary of locations and return its travel time")
    public void givenUnrecognisedLocationAddItToTheDictionaryLocation() {
        TravelTimeCalculator calculator = new TravelTimeCalculator();
        calculator.setTravelTime("Blackpool", "Leeds", "1:39");
        String result = calculator.getTravelTime("Blackpool", "Leeds");
        assertEquals("1:39", result, "Should add the travel time");
    }

    @Test
    @DisplayName("When getTravelLocations is called it returns a list of recognised locations in alphabetical order")
    public void testGetTravelLocationsReturnsListOfRecognisedLocations(){
        TravelTimeCalculator calculator = new TravelTimeCalculator();
        String result = calculator.getTravelLocations();
        assertEquals("Blackpool,Leeds,London,Manchester,Newcastle", result, "Should return a list of recognised location");
    }

    @Test
    @DisplayName("When given an unrecognised location, add the location to recognised list")
    public void testAddLocationUpdateRecognisedLocationsList(){
        TravelTimeCalculator calculator = new TravelTimeCalculator();
        calculator.addLocation("Lancaster");
        String result = calculator.getTravelLocations();
        assertEquals("Blackpool,Lancaster,Leeds,London,Manchester,Newcastle", result,"Should return updated recognised location list");
    }


}
