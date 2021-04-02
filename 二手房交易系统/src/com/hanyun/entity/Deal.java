package com.hanyun.entity;

public class Deal {
    private Integer dealId;
    private Integer houseId;
    private String userNameA;
    private String userNameB;
    private String time;

    public Deal() {
    }

    public Deal(Integer houseId, String userNameA, String userNameB, String time) {
        this.houseId = houseId;
        this.userNameA = userNameA;
        this.userNameB = userNameB;
        this.time = time;
    }

    public Deal(Integer dealId, Integer houseId, String userNameA, String userNameB, String time) {
        this.dealId = dealId;
        this.houseId = houseId;
        this.userNameA = userNameA;
        this.userNameB = userNameB;
        this.time = time;
    }

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public String getUserNameA() {
        return userNameA;
    }

    public void setUserNameA(String userNameA) {
        this.userNameA = userNameA;
    }

    public String getUserNameB() {
        return userNameB;
    }

    public void setUserNameB(String userNameB) {
        this.userNameB = userNameB;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
