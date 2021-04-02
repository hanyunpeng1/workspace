package com.hanyun.entity;

public class House {
    private Integer houseId;
    private String type;
    private String acreage;
    private String finish;
    private String price;
    private String address;
    private String userName;
    private String tel;
    private Integer userId;
    private String status;

    public House() {
    }

    public House(Integer houseId, String type, String acreage, String finish, String price, String address, String userName, String tel, Integer userId, String status) {
        this.houseId = houseId;
        this.type = type;
        this.acreage = acreage;
        this.finish = finish;
        this.price = price;
        this.address = address;
        this.userName = userName;
        this.tel = tel;
        this.userId = userId;
        this.status = status;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAcreage() {
        return acreage;
    }

    public void setAcreage(String acreage) {
        this.acreage = acreage;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
