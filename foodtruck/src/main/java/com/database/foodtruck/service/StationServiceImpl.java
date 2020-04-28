package com.database.foodtruck.service;

import com.database.foodtruck.entity.Station;
import com.database.foodtruck.repository.StationDAO;
import com.database.foodtruck.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationServiceImpl implements StationService {
    private StationDAO stationDAO;
    private StationRepository stationRepository;

    @Autowired
    public StationServiceImpl(@Qualifier("stationDAOImpl") StationDAO stationDAO,
                              StationRepository stationRepository) {
        this.stationDAO = stationDAO;
        this.stationRepository = stationRepository;
    }

    @Override
    public Station findByStationName(String stationName) {
        return stationDAO.findByStationName(stationName);
    }

    @Override
    public void createStation(String stationName, String buildingName, Integer capacity) {
        stationDAO.createStation(stationName, buildingName, capacity);
    }

    @Override
    public void deleteByStationName(String stationName) {
        stationDAO.deleteByStationName(stationName);
    }

    @Override
    public void updateStation(String stationName, Integer capacity, String buildingName) {
        stationDAO.updateStation(stationName, capacity, buildingName);
    }

    @Override
    public List<Station> findAll() {
        return stationRepository.findAll();
    }
}
