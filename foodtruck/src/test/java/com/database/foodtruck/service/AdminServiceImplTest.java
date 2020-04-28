package com.database.foodtruck.service;

import com.database.foodtruck.dao.AdminBSQueryDAO;
import com.database.foodtruck.repository.AdminRepository;
import com.database.foodtruck.vo.AdminBSQuery;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class AdminServiceImplTest {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminBSQueryDAO adminBSQueryDAO;

    @Test
    public void hello() {

        List<AdminBSQuery> res = adminBSQueryDAO.filterBS("", "", "", null, null);
        for (AdminBSQuery a : res) {
            System.out.println(a.getBuildingName());
            System.out.println(a.getTag());
            System.out.println(a.getCapacity());
        }
    }
}