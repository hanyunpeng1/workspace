package com.hanyun.controller;

import com.hanyun.dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminloginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminName,password;
        int result = 0;
        //1、从请求头中获取浏览器中的请求参数
        adminName = request.getParameter("adminName");
        password = request.getParameter("password");
        //2、通过【AdminDao】将登录信息借助JDBC规范发送到数据库服务器
        AdminDao dao = new AdminDao();
        result = dao.login(adminName,password);
        //3、通过请求转发，向Tomcat索要loginInfo.jsp将处理结果写入到响应体
        if (result == 1){
            request.setAttribute("key","管理员"+adminName+"登录成功");
            //request.getRequestDispatcher("/info.jsp").forward(request,response);
            request.getRequestDispatcher("/index02.html").forward(request,response);
        }else {
            request.setAttribute("key","管理员账户输入信息有误，请重新输入！");
            request.getRequestDispatcher("/info.jsp").forward(request,response);
        }
    }
}
