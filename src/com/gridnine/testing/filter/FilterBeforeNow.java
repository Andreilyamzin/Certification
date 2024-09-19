package com.gridnine.testing.filter;

import com.gridnine.testing.test.Flight;

import java.time.LocalDateTime;
import java.util.List;

public class FilterBeforeNow implements FlightFilter {
//Вылет до текущего момента времени
    public List<Flight> filter(List<Flight> flights) {
        LocalDateTime now = LocalDateTime.now();
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate().isAfter(now)))
                .toList();

    }
}

