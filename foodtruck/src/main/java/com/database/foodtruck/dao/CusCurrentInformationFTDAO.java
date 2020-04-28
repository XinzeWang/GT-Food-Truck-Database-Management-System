package com.database.foodtruck.dao;

import com.database.foodtruck.vo.CusCurrentInformationFT;

import java.util.List;

/* query 29*/
public interface CusCurrentInformationFTDAO {
    List<CusCurrentInformationFT> findCusInfoFT(String customerUserName);
}
