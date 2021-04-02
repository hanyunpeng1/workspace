package com.hanyun.dao;

import com.hanyun.entity.House;
import com.hanyun.entity.Users;
import com.hanyun.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HouseDao {
    JdbcUtil util = new JdbcUtil();
    //house表插入信息
    public int add(House house){
        int result = 0;
        String sql = "insert into houses(type,acreage,finish,price,address,userName,tel,userId) values(?,?,?,?,?,?,?,?)";
        PreparedStatement ps = util.creatPs(sql);
        try {
            ps.setString(1,house.getType());
            ps.setString(2,house.getAcreage());
            ps.setString(3,house.getFinish());
            ps.setString(4,house.getPrice());
            ps.setString(5,house.getAddress());
            ps.setString(6,house.getUserName());
            ps.setString(7,house.getTel());
            ps.setInt(8,house.getUserId());
            //ps.setString(9,house.getStatus());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }

    //houses表——查看houses表
    public List find(){
        List list = new ArrayList();
        House house = null;
        String sql = "select * from houses ";
        PreparedStatement ps = util.creatPs(sql);
        ResultSet rs = null;
        try {
            rs  = ps.executeQuery();
            while (rs.next()){
                Integer houseId = rs.getInt("houseId");
                String type = rs.getString("type");
                String acreage = rs.getString("acreage");
                String finish = rs.getString("finish");
                String price = rs.getString("price");
                String address = rs.getString("address");
                String userName = rs.getString("userName");
                String tel = rs.getString("tel");
                Integer userId = rs.getInt("userId");
                String status = rs.getString("status");
                house = new House(houseId,type,acreage,finish,price,address,userName,tel,userId,status);
                list.add(house);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(rs);
        }
        return list;
    }

    //houses表——删除数据
    public int delete(String houseId){
        int result = 0;
        String sql = "delete from houses where houseId = ?";
        PreparedStatement ps = util.creatPs(sql);
        try {
            ps.setInt(1,Integer.valueOf(houseId));
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }

    //houses表——更新房屋状态
    public int update(String houseId,String status){
        int result = 0;
        String sql = "update houses set status=? where houseId =?";
        PreparedStatement ps = util.creatPs(sql);
        try {
            ps.setString(1,status);
            ps.setInt(2,Integer.valueOf(houseId));
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }

    //houses表——查看某一条数据
    public List findById(String userName){
        List list = new ArrayList();
        House house = null;
        String sql = "select * from houses where userName = ?";
        PreparedStatement ps = util.creatPs(sql);
        ResultSet rs = null;
        try {
            ps.setString(1,userName);
            rs = ps.executeQuery();
            while (rs.next()){
                Integer houseId = rs.getInt("houseId");
                String type = rs.getString("type");
                String acreage = rs.getString("acreage");
                String finish = rs.getString("finish");
                String price = rs.getString("price");
                String address = rs.getString("address");
                //String userName = rs.getString("userName");
                String tel = rs.getString("tel");
                Integer userId = rs.getInt("userId");
                String status = rs.getString("status");
                house = new House(houseId,type,acreage,finish,price,address,userName,tel,userId,status);
                list.add(house);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(rs);
        }
        return list;
    }

    //houses表——查看houses表
    public List findUser(String userName){
        List list = new ArrayList();
        House house = null;
        String sql = "select * from houses where status = '出售中' and userName not in(?)";
        PreparedStatement ps = util.creatPs(sql);
        ResultSet rs = null;
        try {
            ps.setString(1,userName);
            rs  = ps.executeQuery();
            while (rs.next()){
                Integer houseId = rs.getInt("houseId");
                String type = rs.getString("type");
                String acreage = rs.getString("acreage");
                String finish = rs.getString("finish");
                String price = rs.getString("price");
                String address = rs.getString("address");
                String userName1 = rs.getString("userName");
                String tel = rs.getString("tel");
                Integer userId = rs.getInt("userId");
                String status = rs.getString("status");
                house = new House(houseId,type,acreage,finish,price,address,userName1,tel,userId,status);
                list.add(house);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(rs);
        }
        return list;
    }

    //houses表——查看houses表中位于北京的houses
    public List findBJ(){
        List list = new ArrayList();
        House house = null;
        String sql = "select * from houses where address like '北京%'";
        PreparedStatement ps = util.creatPs(sql);
        ResultSet rs = null;
        try {
            rs  = ps.executeQuery();
            while (rs.next()){
                Integer houseId = rs.getInt("houseId");
                String type = rs.getString("type");
                String acreage = rs.getString("acreage");
                String finish = rs.getString("finish");
                String price = rs.getString("price");
                String address = rs.getString("address");
                String userName = rs.getString("userName");
                String tel = rs.getString("tel");
                Integer userId = rs.getInt("userId");
                String status = rs.getString("status");
                house = new House(houseId,type,acreage,finish,price,address,userName,tel,userId,status);
                list.add(house);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(rs);
        }
        return list;
    }

    //houses表——查看houses表中位于address的houses
    public List findSell(String address){
        List list = new ArrayList();
        House house = null;
        String sql = "select * from houses where address like ?";
        PreparedStatement ps = util.creatPs(sql);
        ResultSet rs = null;
        try {
            ps.setString(1,address);
            rs = ps.executeQuery();
            while (rs.next()){
                Integer houseId = rs.getInt("houseId");
                String type = rs.getString("type");
                String acreage = rs.getString("acreage");
                String finish = rs.getString("finish");
                String price = rs.getString("price");
                //String address = rs.getString("address");
                String userName = rs.getString("userName");
                String tel = rs.getString("tel");
                Integer userId = rs.getInt("userId");
                String status = rs.getString("status");
                house = new House(houseId,type,acreage,finish,price,address,userName,tel,userId,status);
                list.add(house);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(rs);
        }
        return list;
    }
}
