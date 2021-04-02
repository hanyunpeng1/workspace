package com.hanyun.dao;

import com.hanyun.entity.Admin;
import com.hanyun.entity.Users;
import com.hanyun.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    JdbcUtil util = new JdbcUtil();
    //user表插入信息
    public int add(Users user){
        int result = 0;
        String sql = "insert into users(userName,password,realName,sex,address,tel,email) values(?,?,?,?,?,?,?)";
        PreparedStatement ps = util.creatPs(sql);
        try {
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getRealName());
            ps.setString(4,user.getSex());
            ps.setString(5,user.getAddress());
            ps.setString(6,user.getTel());
            ps.setString(7,user.getEmail());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }

    //user表——登录
    public int login(String userName,String password){
        int result = 0;
        String sql = "select count(*) from users where userName = ? and password = ? ";
        PreparedStatement ps = util.creatPs(sql);
        ResultSet rs = null;
        try {
            ps.setString(1,userName);
            ps.setString(2,password);
            rs = ps.executeQuery();
            while (rs.next()){
               result = rs.getInt("count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(rs);
        }
        return result;
    }

    //user表——查看user表
    public List find(){
        List list = new ArrayList();
        Users user = new Users();
        String sql = "select * from users ";
        PreparedStatement ps = util.creatPs(sql);
        ResultSet rs = null;
        try {
            rs  = ps.executeQuery();
            while (rs.next()){
                Integer userId = rs.getInt("userId");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String realName = rs.getString("realName");
                String sex = rs.getString("sex");
                String address = rs.getString("address");
                String tel = rs.getString("tel");
                String email = rs.getString("email");
                String user_del = rs.getString("user_del");
                user = new Users(userId,userName,password,realName,sex,address,tel,email,user_del);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(rs);
        }
        return list;
    }

    //user表——删除数据
    public int delete(String userId){
        int result = 0;
        String sql = "delete from users where userId = ?";
        PreparedStatement ps = util.creatPs(sql);
        try {
            ps.setInt(1,Integer.valueOf(userId));
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }

    //Users表——查看某一条数据
    public Users findById(String userName){
        Users user = null;
        String sql = "select * from users where userName = ?";
        PreparedStatement ps = util.creatPs(sql);
        ResultSet rs = null;
        try {
            ps.setString(1,userName);
            rs = ps.executeQuery();
            while (rs.next()){
                Integer userId = rs.getInt("userId");
                //String userName = rs.getString("userName");
                String password = rs.getString("password");
                String realName = rs.getString("realName");
                String sex = rs.getString("sex");
                String address = rs.getString("address");
                String tel = rs.getString("tel");
                String email = rs.getString("email");
                String user_del = rs.getString("user_del");
                user = new Users(userId,userName,password,realName,sex,address,tel,email,null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(rs);
        }
        return user;
    }

    //Users表——更新数据
    public int update(Users user){
        int result = 0;
        String sql = "update users set userName=?,password=?,realName=?,sex=?,address=?,tel=?,email=? " +
                "where userId =?";
        PreparedStatement ps = util.creatPs(sql);
        try {
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getRealName());
            ps.setString(4,user.getSex());
            ps.setString(5,user.getAddress());
            ps.setString(6,user.getTel());
            ps.setString(7,user.getEmail());
            ps.setInt(8,user.getUserId());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }
}
