package com.hanyun.dao;

import com.hanyun.entity.Message;
import com.hanyun.entity.Users;
import com.hanyun.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDao {
    JdbcUtil util = new JdbcUtil();

    //message表——添加留言信息
    public int add(String userName,String text,String time){
        int result = 0;
        String sql = "insert into message(userName,text,time) values(?,?,?)";
        PreparedStatement ps = util.creatPs(sql);
        try {
            ps.setString(1,userName);
            ps.setString(2,text);
            ps.setString(3,time);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }

    //message表——查看某一条数据
    public List findById(String userName){
        List list = new ArrayList();
        Message message = null;
        String sql = "select * from message where userName = ?";
        PreparedStatement ps = util.creatPs(sql);
        ResultSet rs = null;
        try {
            ps.setString(1,userName);
            rs = ps.executeQuery();
            while (rs.next()){
                Integer messageId = rs.getInt("messageId");
                //String userName = rs.getString("userName");
                String text = rs.getString("text");
                String time = rs.getString("time");
                message = new Message(messageId,userName,text,time);
                list.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(rs);
        }
        return list;
    }

    //message表——查看整个message表
    public List find(){
        List list = new ArrayList();
        Message message = new Message();
        String sql = "select * from message ";
        PreparedStatement ps = util.creatPs(sql);
        ResultSet rs = null;
        try {
            rs  = ps.executeQuery();
            while (rs.next()){
                Integer messageId = rs.getInt("messageId");
                String userName = rs.getString("userName");
                String text = rs.getString("text");
                String time = rs.getString("time");
                message = new Message(messageId,userName,text,time);
                list.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(rs);
        }
        return list;
    }

    //message表——删除数据
    public int delete(String messageId){
        int result = 0;
        String sql = "delete from message where messageId = ?";
        PreparedStatement ps = util.creatPs(sql);
        try {
            ps.setInt(1,Integer.valueOf(messageId));
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }
}
