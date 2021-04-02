package com.hanyun.dao;

import com.hanyun.entity.Admin;
import com.hanyun.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {
    JdbcUtil util = new JdbcUtil();
    //管理员登录
    public int login(String adminName,String password){
        int result = 0;
        String sql = "select count(*) from Admin where adminName = ? and password = ?";
        PreparedStatement ps = util.creatPs(sql);
        ResultSet rs = null;
        try {
            ps.setString(1,adminName);
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

    //管理员表查看
    public List find(){
        List list = new ArrayList();
        Admin admin = null;
        String sql = "select * from Admin";
        PreparedStatement ps = util.creatPs(sql);
        ResultSet rs = null;
        try {
            rs =ps.executeQuery();
            while (rs.next()){
                Integer adminId = rs.getInt("adminId");
                String adminName = rs.getString("adminName");
                String password = rs.getString("password");
                admin = new Admin(adminId,adminName,password);
                list.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(rs);
        }
        return list;
    }

    //admin表——删除数据
    public int delete(String adminId){
        int result = 0;
        String sql = "delete from Admin where adminId = ?";
        PreparedStatement ps = util.creatPs(sql);
        try {
            ps.setInt(1,Integer.valueOf(adminId));
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }

    //admin表——更新数据
    public int update(Admin admin){
        int result = 0;
        String sql = "update Admin set adminName =?,password =? where adminId =?";
        PreparedStatement ps = util.creatPs(sql);
        try {
            ps.setString(1,admin.getAdminName());
            ps.setString(2,admin.getPassword());
            ps.setInt(3,admin.getAdminId());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }

    //admin表——查看某一条数据
    public Admin findById(String adminId){
        int result = 0;
        Admin admin = null;
        String sql = "select * from Admin where adminId = ?";
        PreparedStatement ps = util.creatPs(sql);
        ResultSet rs = null;
        try {
            ps.setInt(1,Integer.valueOf(adminId));
            rs = ps.executeQuery();
            while (rs.next()){
                Integer adminId1 = rs.getInt("adminId");
                String adminName = rs.getString("adminName");
                String password = rs.getString("password");
                admin = new Admin(adminId1,adminName,password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(rs);
        }
        return admin;
    }
}
