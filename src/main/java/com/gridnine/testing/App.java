package com.gridnine.testing;

import com.gridnine.testing.filters.ArrivalBeforeDepartureFilter;
import com.gridnine.testing.filters.FilterService;
import com.gridnine.testing.filters.TimeOnGroundMoreTwoHoursFilter;
import com.gridnine.testing.filters.UpToCurrentTimeFilter;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();

        //Исключаем перелеты, где вылет до текущего момента времени
        UpToCurrentTimeFilter upToCurrentTimeFilter = new UpToCurrentTimeFilter();
        List<Flight> res1 = FilterService.performFilter(flights, upToCurrentTimeFilter);
        System.out.println("Перелеты с корректным временем вылета : " + res1);

        //Исключаем перелеты, где дата прилета раньше даты вылета
        ArrivalBeforeDepartureFilter arrivalBeforeDepartureFilter = new ArrivalBeforeDepartureFilter();
        List<Flight> res2 = FilterService.performFilter(flights, arrivalBeforeDepartureFilter);
        System.out.println("Перелеты с корректным временем прилета : " + res2);

        //Исключаем перелеты, где общее время, проведенное на земле более 2 часов
        TimeOnGroundMoreTwoHoursFilter timeOnGroundMoreTwoHoursFilter = new TimeOnGroundMoreTwoHoursFilter();
        List<Flight> res3 = FilterService.performFilter(flights, timeOnGroundMoreTwoHoursFilter);
        System.out.println("Перелеты, где общее время, проведенное на земле менее или равняется двум часам : "
                + res3);


    }
}
