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
    @DisplayName("When getTravelLocations is called it returns a list of recognised locations in alphabetical order")
    public void testGetTravelLocationsReturnsListOfRecognisedLocations(){
        TravelTimeCalculator calculator = new TravelTimeCalculator();
        String result = calculator.getTravelLocations();
        assertEquals("Blackpool,Leeds,London,Manchester,Newcastle", result, "Should return a list of recognised location");
    }


}
