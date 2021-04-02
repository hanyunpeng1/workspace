package com.hanyun.controller;

import com.hanyun.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserloginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,password;
        int result = 0;
        //1、从请求头中获取参数
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        //2、通过【UserDao】将登录信息借助JDBC规范发送到数据库服务器
        UserDao dao = new UserDao();
        result = dao.login(userName,password);
        //3、通过请求转发，向Tomcat索要loginInfo.jsp将处理结果写入到响应体
        if (result == 1){
            request.setAttribute("key",userName);
            request.getRequestDispatcher("/loginInfo.jsp").forward(request,response);
        }else {
            request.setAttribute("key","登录失败！，请重新登录");
            request.getRequestDispatcher("/info.jsp").forward(request,response);
        }
    }
}
