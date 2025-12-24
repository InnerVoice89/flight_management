package com.gridnine.testing.filters;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;

import java.time.LocalDateTime;
import java.util.List;

public class UpToCurrentTimeFilter implements FlightFilter {

    @Override
    public boolean filter(Flight flight) {

        return !flight.getSegments().isEmpty()
                && !flight.getSegments().get(0).getDepartureDate().isBefore(LocalDateTime.now());


//        List<Segment> segments = flight.getSegments();
//        if (segments.isEmpty())
//            return false;
//        long count = segments.stream().filter(segment -> segment.getDepartureDate().isBefore(LocalDateTime.now()))
//                .count();
//        return count == 0;
    }
}
