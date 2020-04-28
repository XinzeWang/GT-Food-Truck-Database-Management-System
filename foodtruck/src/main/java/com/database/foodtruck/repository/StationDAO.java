package com.database.foodtruck.repository;

import com.database.foodtruck.entity.Station;
import com.database.foodtruck.vo.ViewStationQuery;

public interface StationDAO {
    /*query 12*/
    Station findByStationName(String stationName);

    /*query 11*/
    void createStation(String stationName, String buildingName, Integer capacity);

    /*query 5*/
    void deleteByStationName(String stationName);

    /*query 11*/
    void updateStation(String stationName, Integer capacity, String buildingName);
}
