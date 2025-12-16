package com.gridnine.testing.filters;

import com.gridnine.testing.Flight;

import java.time.LocalDateTime;

public class UpToCurrentTimeFilter implements FlightFilter {

    @Override
    public boolean filter(Flight flight) {

        return flight.getSegments().get(0).getDepartureDate().isBefore(LocalDateTime.now());
    }
}
