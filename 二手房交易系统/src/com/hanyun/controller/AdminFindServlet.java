package com.hanyun.controller;

import com.hanyun.dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminFindServlet extends HttpServlet {
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     List list = new ArrayList();
     //1、通过【AdminDao】将信息借助JDBC规范发送到数据库服务器
     AdminDao dao = new AdminDao();
     list = dao.find();
     //2、通过请求转发，向Tomcat索要loginInfo.jsp将处理结果写入到响应体
     request.setAttribute("key",list);
     request.getRequestDispatcher("/admin_find.jsp").forward(request,response);
    }
}
