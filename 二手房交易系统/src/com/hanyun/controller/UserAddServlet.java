package com.hanyun.controller;

import com.hanyun.dao.UserDao;
import com.hanyun.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserAddServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,password,realName,sex,address,tel,email;
        int result = 0;
        //1、从请求头中获取参数信息
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        realName = request.getParameter("realName");
        sex = request.getParameter("sex");
        address = request.getParameter("address");
        tel = request.getParameter("tel");
        email = request.getParameter("email");
        //2、调用【UserDao】将用户信息填充到insert命令并借助JDBC规范发送到数据库服务器
        Users user = new Users(null,userName,password,realName,sex,address,tel,email,null);
        UserDao dao = new UserDao();
        result = dao.add(user);
        //3、通过请求转发，向Tomcat索要info.jsp将处理结果写入到响应体
        if (result == 1){
            request.setAttribute("key","注册成功！");
        }else {
            request.setAttribute("key","注册失败！");
        }
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }
}
