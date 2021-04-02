package com.hanyun.dao;

import com.hanyun.entity.Deal;
import com.hanyun.entity.House;
import com.hanyun.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DealDao {
    JdbcUtil util = new JdbcUtil();
    //Deal表插入信息
    public int add(Deal deal){
        int result = 0;
        String sql = "insert into deal(houseId,userNameA,userNameB) values(?,?,?)";
        PreparedStatement ps = util.creatPs(sql);
        try {
            ps.setInt(1,deal.getHouseId());
            ps.setString(2,deal.getUserNameA());
            ps.setString(3,deal.getUserNameB());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }

    //deal表——查看某一条数据
    public List findById(String userName){
        List list = new ArrayList();
        Deal deal = null;
        String sql = "select * from deal where userNameB = ?";
        PreparedStatement ps = util.creatPs(sql);
        ResultSet rs = null;
        try {
            ps.setString(1,userName);
            rs = ps.executeQuery();
            while (rs.next()){
                Integer dealId = rs.getInt("dealId");
                Integer houseId = rs.getInt("houseId");
                String userNameA = rs.getString("userNameA");
                String userNameB = rs.getString("userNameB");
                String time = rs.getString("time");
                deal = new Deal(dealId,houseId,userNameA,userNameB,time);
                list.add(deal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(rs);
        }
        return list;
    }

    //deal表——查看deal表
    public List find(){
        List list = new ArrayList();
        Deal deal = null;
        String sql = "select * from deal ";
        PreparedStatement ps = util.creatPs(sql);
        ResultSet rs = null;
        try {
            rs  = ps.executeQuery();
            while (rs.next()){
                Integer dealId = rs.getInt("dealId");
                Integer houseId = rs.getInt("houseId");
                String userNameA = rs.getString("userNameA");
                String userNameB = rs.getString("userNameB");
                String time = rs.getString("time");
                deal = new Deal(dealId,houseId,userNameA,userNameB,time);
                list.add(deal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(rs);
        }
        return list;
    }

    //deal表——删除数据
    public int delete(String dealId){
        int result = 0;
        String sql = "delete from deal where dealId = ?";
        PreparedStatement ps = util.creatPs(sql);
        try {
            ps.setInt(1,Integer.valueOf(dealId));
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }

    //deal表——更新交易时间
    public int update(String dealId,String time){
        int result = 0;
        String sql = "update deal set time=? where dealId =?";
        PreparedStatement ps = util.creatPs(sql);
        try {
            System.out.println("houseId1 = "+ Integer.valueOf(dealId));
            System.out.println("time1 = "+time);

            ps.setString(1,time);
            ps.setInt(2,Integer.valueOf(dealId));
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }
}
