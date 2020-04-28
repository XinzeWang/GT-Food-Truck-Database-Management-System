package com.database.foodtruck.repository;

import com.database.foodtruck.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StationRepository extends JpaRepository<Station, String> {
    /*find all the stations*/
    List<Station> findAll();
}
