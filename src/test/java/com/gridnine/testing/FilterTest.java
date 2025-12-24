package com.gridnine.testing;

import com.gridnine.testing.filters.ArrivalBeforeDepartureFilter;
import com.gridnine.testing.filters.FlightFilter;
import com.gridnine.testing.filters.TimeOnGroundMoreTwoHoursFilter;
import com.gridnine.testing.filters.UpToCurrentTimeFilter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.testng.Assert.*;

public class FilterTest {

    private FlightFilter filter;
    private LocalDateTime threeDaysFromNow;


    @BeforeClass
    public void setUp() {
        threeDaysFromNow = LocalDateTime.now().plusDays(3);
    }

    // Проверка на некорректную дату вылета
    @Test
    public void testUpOnCurrentTimeFilter() {
        filter = new UpToCurrentTimeFilter();
        Flight flight = new Flight(Arrays.asList(new Segment(threeDaysFromNow.minusDays(6), threeDaysFromNow)));
        boolean res = filter.filter(flight);
        assertFalse(res);
    }

    // Проверка на некорректную дату прилета
    @Test
    public void testArrivalBeforeDepartureFilter() {
        filter = new ArrivalBeforeDepartureFilter();
        Flight flight = new Flight(Arrays.asList(new Segment(threeDaysFromNow, threeDaysFromNow.minusHours(6))));
        boolean res = filter.filter(flight);
        assertFalse(res);
    }

    // Проверка на общее время на земле
    @Test
    public void testTimeOnGroundMoreTwoHoursFilter() {
        filter = new TimeOnGroundMoreTwoHoursFilter();
        Flight flight = new Flight(Arrays.asList(new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2)),
                new Segment(threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4)),
                new Segment(threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(7))
        ));
        boolean res = filter.filter(flight);
        assertFalse(res);
    }

}
