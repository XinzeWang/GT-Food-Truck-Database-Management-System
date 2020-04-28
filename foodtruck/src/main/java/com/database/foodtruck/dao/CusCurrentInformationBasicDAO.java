package com.database.foodtruck.dao;

import com.database.foodtruck.vo.CusCurrentInformationBasic;

import java.util.List;

/* query 28 */
public interface CusCurrentInformationBasicDAO {
    CusCurrentInformationBasic findCusInfoBasic(String customerUserName);
}
