package com.database.foodtruck.controller;

import com.database.foodtruck.service.AdminService;
import com.database.foodtruck.service.BuildingService;
import com.database.foodtruck.vo.AdminBSQuery;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BuildingControllerTestTest {

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private AdminService adminService;

    @Test
    public void hello() {
        List<AdminBSQuery> res = adminService.filterBS("", "", "", null, null);
        for (AdminBSQuery a : res) {
            System.out.println(a.getBuildingName());
            System.out.println(a.getTag());
            System.out.println(a.getCapacity());
        }
    }

}