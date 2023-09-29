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

    @ParameterizedTest
    @CsvSource({"'Blackpool','Leeds','1:39', 'Blackpool,Leeds'", "'London', 'Manchester', '1:00', 'London,Manchester'"})
    @DisplayName("When given locations, return the list of recognised locations in alphabetical order.")
    public void givenRecognisedLocationsReturnListOfRecognisedLocationsInOrder(String location, String destination, String time, String expected){
        calculator.setTravelTime(location, destination, time);
        String result = calculator.getTravelLocations();
        assertEquals(expected, result, "Should return a list of recognised location in alphabetical order.");
    }

    @Test
    @DisplayName("When given destinations, return the list of recognised destinations in alphabetical order")
    public void givenRecognisedDestinationsReturnTheListOfRecognisedDestinationsInOrder () {
        calculator.setTravelTime("Manchester", "Newcastle", "2:28");
        String result = calculator.getTravelDestinations("Manchester");
        assertEquals("Manchester,Newcastle", result, "Should return recognised destinations in alphabetical order");
    }


}
