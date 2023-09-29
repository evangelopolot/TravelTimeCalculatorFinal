package uk.gov.dwp;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class TravelTimeCalculatorTest {
    private TravelTimeCalculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new TravelTimeCalculator();
    }

    @Test
    @DisplayName("When given a location and a destination which are the same, return zero in time")
    public void givenLocationAndDestinationWhichAreTheSameReturnZeroTime(){
        String result = calculator.getTravelTime("Blackpool", "Blackpool");
        assertEquals("00:00", result, "Should return zero in format 'hh:mm'");
    }

    @Test
    @DisplayName("Given a not recognised location add to dictionary of locations and return its travel time")
    public void givenUnrecognisedLocationAddItToTheDictionaryLocationAndReturnTravelTime() {
        calculator.setTravelTime("Blackpool", "Leeds", "1:39");
        String result = calculator.getTravelTime("Blackpool", "Leeds");
        assertEquals("1:39", result, "Should add and return the travel time");
    }

    @Test
    @DisplayName("Given a not recognised destination add to dictionary of destinations and return its travel time")
    public void givenUnrecognisedDestinationAddItToTheDictionaryOfDestinationsAndReturnTravelTime() {
        calculator.setTravelTime("Blackpool", "Leeds", "1:39");
        calculator.setTravelTime("Leads","Blackpool", "1:39");
        String result = calculator.getTravelTime("Leeds", "Blackpool");
        assertEquals("1:39", result, "Should add and return travel time");
    }

    @Test
    @DisplayName("When getTravelLocations is called it returns a list of recognised locations in alphabetical order")
    public void testGetTravelLocationsReturnsListOfRecognisedLocations(){
        String result = calculator.getTravelLocations();
        assertEquals("Blackpool,Leeds,London,Manchester,Newcastle", result, "Should return a list of recognised location");
    }

    @Test
    @DisplayName("When given an unrecognised location, add the location to recognised list")
    public void testAddLocationUpdateRecognisedLocationsList(){
        calculator.addLocation("Lancaster");
        String result = calculator.getTravelLocations();
        assertEquals("Blackpool,Lancaster,Leeds,London,Manchester,Newcastle", result,"Should return updated recognised location list");
    }


}
