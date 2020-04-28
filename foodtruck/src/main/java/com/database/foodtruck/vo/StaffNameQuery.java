package com.database.foodtruck.vo;

// container for 20a, 20b, available or assigned
public class StaffNameQuery {
    private String concatStaffName;

    public StaffNameQuery(String concatStaffName) {
        concatStaffName = concatStaffName;
    }

    public String getConcatStaffName() {
        return concatStaffName;
    }

    public void setConcatStaffName(String concatStaffName) {
        concatStaffName = concatStaffName;
    }
}
