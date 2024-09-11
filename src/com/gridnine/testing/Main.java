package com.gridnine.testing;

import com.gridnine.testing.filter.FilterArrivalBeforeDeparture;
import com.gridnine.testing.filter.FilterBeforeNow;
import com.gridnine.testing.filter.FilterLongTimeWaiting;
import com.gridnine.testing.test.Flight;
import com.gridnine.testing.test.FlightBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flightList = FlightBuilder.createFlights();

        System.out.println("//All flights");
        System.out.println(flightList.toString());

        System.out.println("//Already flown");
        System.out.println((new FilterBeforeNow().filter(flightList)).toString());

        System.out.println("//Arrival before departure");
        System.out.println((new FilterArrivalBeforeDeparture().filter(flightList)).toString());

        System.out.println("//Flights after ground time exceeds two hours filter:");
        System.out.println((new FilterLongTimeWaiting().filter(flightList)).toString());
    }
}
