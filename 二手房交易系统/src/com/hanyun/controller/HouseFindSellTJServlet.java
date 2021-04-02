package com.hanyun.controller;

import com.hanyun.dao.HouseDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HouseFindSellTJServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List list = new ArrayList();
        String address = "天津%";
        //1、通过【HouseDao】将信息借助JDBC规范发送到数据库服务器
        HouseDao dao = new HouseDao();
        list = dao.findSell(address);
        //2、通过请求转发，向Tomcat索要house_find.jsp将处理结果写入到响应体
        request.setAttribute("key",list);
        request.getRequestDispatcher("/house_findSell.jsp").forward(request,response);
    }
}
