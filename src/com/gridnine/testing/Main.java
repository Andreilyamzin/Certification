package com.gridnine.testing;

import com.gridnine.testing.filter.FilterBeforeNow;
import com.gridnine.testing.filter.FlightFilter;
import com.gridnine.testing.filter.FlightsArrivalBeforeDeparture;

import com.gridnine.testing.filter.FilterLongTimeWaiting;
import com.gridnine.testing.test.Flight;
import com.gridnine.testing.test.FlightBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println("All flights:");
        flights.forEach(System.out::println);

        FlightFilter beforeNow = new FilterBeforeNow();
        FlightFilter arrivalBeforeDeparture = new FlightsArrivalBeforeDeparture();
        FlightFilter longTimeWaiting = new FilterLongTimeWaiting();

        System.out.println("Flights after departure before now filter:");
        beforeNow.filter(flights).forEach(System.out::println);

        System.out.println("Flights after arrival before departure filter:");
        arrivalBeforeDeparture.filter(flights).forEach(System.out::println);

        System.out.println("Flights after ground time exceeds two hours filter:");
        longTimeWaiting.filter(flights).forEach(System.out::println);
    }
}
