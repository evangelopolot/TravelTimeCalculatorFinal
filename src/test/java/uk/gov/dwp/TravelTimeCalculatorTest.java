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
        assertEquals("Should return zero in format 'hh:mm'","00:00", result);
    }

}
