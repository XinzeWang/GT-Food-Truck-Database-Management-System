package com.database.foodtruck.service;

import com.database.foodtruck.entity.Station;

import java.util.List;

public interface StationService {
    /*query 12*/
    Station findByStationName(String stationName);

    /*query 11*/
    void createStation(String stationName, String buildingName, Integer capacity);

    /*query 5*/
    void deleteByStationName(String stationName);

    /*query 9*/
    void updateStation(String stationName, Integer capacity, String buildingName);

    /*find all the stations*/
    List<Station> findAll();
}
