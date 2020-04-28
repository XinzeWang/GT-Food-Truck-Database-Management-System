package com.database.foodtruck.dao;

import com.database.foodtruck.vo.ManagerGetStation;

import java.util.List;

/*query 23*/
public interface ManagerGetStationDAO {
    List<ManagerGetStation> mnGetStation(String managerUserName);

}
