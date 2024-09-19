package com.gridnine.testing.filter;

import com.gridnine.testing.test.Flight;

import java.util.List;

//Сегменты с датой прилёта раньше даты вылета
public class FlightsArrivalBeforeDeparture implements FlightFilter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream() // Для каждого перелёта проверяем, что все сегменты правильные
                        // Используем метод .allMatch(), чтобы убедиться, что для всех сегментов
                        // дата прилёта (arrivalDate) происходит после даты вылета (departureDate)
                        .allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())))
                .toList();
    }
}