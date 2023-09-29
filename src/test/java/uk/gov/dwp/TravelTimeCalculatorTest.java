package uk.gov.dwp;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class TravelTimeCalculatorTest {
    @Test
    @DisplayName("Creating time calculator Class and its methods")
    public void createClassAndMethods(){
        TravelTimeCalculator calculator = new TravelTimeCalculator();
        calculator.getTravelTime("fromLocation", "toLocation");
        calculator.getTravelLocations();
        calculator.getTravelDestinations();
        calculator.setTravelTime("fromLocation", "toLocation","travelTime");
    }

}
