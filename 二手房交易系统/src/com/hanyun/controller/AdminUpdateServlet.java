package com.hanyun.controller;

import com.hanyun.dao.AdminDao;
import com.hanyun.entity.Admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class AdminUpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminId,adminName,password;
        int result = 0;
        Admin admin = null;
        //1、从请求头中获取参数信息
        adminId = request.getParameter("adminId");
        adminName = request.getParameter("adminName");
        password = request.getParameter("password");
        //2、通过【AdminDao】将adminId填充到update命名并推送到数据库
        AdminDao dao = new AdminDao();
        admin = new Admin(Integer.valueOf(adminId),adminName,password);
        result = dao.update(admin);
        //3、通过请求转发，向Tomcat索要info.jsp将处理结果写入到响应体
        if (result == 1){
            request.setAttribute("key","更新成功");
        }else {
            request.setAttribute("key","更新失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }
}
