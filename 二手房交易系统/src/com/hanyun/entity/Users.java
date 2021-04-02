package com.hanyun.entity;

public class Users {
    private Integer userId;
    private String userName;
    private String password;
    private String realName;
    private String sex;
    private String address;
    private String tel;
    private String email;
    private String user_del;

    public Users() {
    }

    public Users(Integer userId, String userName, String password, String realName, String sex, String address, String tel, String email, String user_del) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.realName = realName;
        this.sex = sex;
        this.address = address;
        this.tel = tel;
        this.email = email;
        this.user_del = user_del;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_del() {
        return user_del;
    }

    public void setUser_del(String user_del) {
        this.user_del = user_del;
    }
}
