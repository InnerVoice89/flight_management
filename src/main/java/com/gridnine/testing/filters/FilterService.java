package com.gridnine.testing.filters;

import com.gridnine.testing.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class FilterService {

    public static List<Flight> performFilter(List<Flight> flights,FlightFilter flightFilter){

       return flights.stream().filter(flightFilter::filter).collect(Collectors.toList());
        }
    }

