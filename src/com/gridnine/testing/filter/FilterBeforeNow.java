package com.gridnine.testing.filter;

import com.gridnine.testing.test.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class FilterBeforeNow implements FlightFilter {

    @Override
    public List<Flight> filter(List<Flight> flightList) {
        return flightList
                .stream()
                .filter(flight -> flight.getSegments()
                        .stream()
                        .anyMatch(segment -> segment.getDepartureDate().isBefore(currentMoment))
                )
                .collect(Collectors.toList());
    }
}