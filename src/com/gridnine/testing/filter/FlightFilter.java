package com.gridnine.testing.filter;

import com.gridnine.testing.test.Flight;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightFilter {
    LocalDateTime currentMoment = LocalDateTime.now();
    int timeWaiting = 2;

    List<Flight> filter(List<Flight> flightList);
}