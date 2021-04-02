package com.hanyun.controller;

import com.hanyun.dao.HouseDao;
import com.hanyun.dao.UserDao;
import com.hanyun.entity.House;
import com.hanyun.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HouseAddServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String houseId,type,acreage,finish,price,address,userName,tel,userId,status;
        House house = null;
        int result = 0;
        //1、从请求头中获取参数信息
        //houseId = request.getParameter("houseId");
        type = request.getParameter("type");
        acreage = request.getParameter("acreage");
        finish = request.getParameter("finish");
        price = request.getParameter("price");
        address = request.getParameter("address");
        userName = request.getParameter("userName");
        tel = request.getParameter("tel");
        userId = request.getParameter("userId");
        //status = request.getParameter("status");
        //2、调用【UserDao】将用户信息填充到insert命令并借助JDBC规范发送到数据库服务器
        //house = new House(Integer.valueOf(houseId),type,acreage,finish,price,address,userName,tel,Integer.valueOf(userId),status);
        house = new House(null,type,acreage,finish,price,address,userName,tel,Integer.valueOf(userId),null);
        HouseDao dao = new HouseDao();
        result = dao.add(house);
        //3、通过请求转发，向Tomcat索要info.jsp将处理结果写入到响应体
        if (result == 1){
            request.setAttribute("key","二手房发布成功！");
        }else {
            request.setAttribute("key","二手房发布失败！");
        }
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }
}
