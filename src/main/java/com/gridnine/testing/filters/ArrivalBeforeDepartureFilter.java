package com.gridnine.testing.filters;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;

import java.util.List;

public class ArrivalBeforeDepartureFilter implements FlightFilter {
    @Override
    public boolean filter(Flight flight) {
        List<Segment> segments = flight.getSegments();
        long result = segments.stream().filter(segment ->
                        segment.getArrivalDate().isBefore(segment.getDepartureDate()))
                .count();
        return result == 0;
    }
}
