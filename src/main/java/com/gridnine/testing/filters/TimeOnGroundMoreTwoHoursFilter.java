package com.gridnine.testing.filters;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;

import java.time.Duration;
import java.util.List;

public class TimeOnGroundMoreTwoHoursFilter implements FlightFilter {
    @Override
    public boolean filter(Flight flight) {
        List<Segment> segments = flight.getSegments();
        Duration groundTime = Duration.ZERO;
        for (int i = 0; i < segments.size() - 1; i++) {
            groundTime = groundTime.plus(Duration.between(
                    segments.get(i).getArrivalDate(),
                    segments.get(i + 1).getDepartureDate()
            ));
        }
        return groundTime.compareTo(Duration.ofHours(2)) < 0;
    }
}
