package com.hanyun.controller;

import com.hanyun.dao.AdminDao;
import com.hanyun.dao.UserDao;
import com.hanyun.entity.Admin;
import com.hanyun.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserUpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId,userName,password,realName,sex,address,tel,email;
        int result = 0;
        Users user = null;
        //1、从请求头中获取参数信息
        userId = request.getParameter("userId");
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        realName = request.getParameter("realName");
        sex = request.getParameter("sex");
        address = request.getParameter("address");
        tel = request.getParameter("tel");
        email = request.getParameter("email");
        //2、通过【UserDao】将userId填充到update命名并推送到数据库
        UserDao dao = new UserDao();
        user = new Users(Integer.valueOf(userId),userName,password,realName,sex,address,tel,email,null);
        result = dao.update(user);
        //3、通过请求转发，向Tomcat索要info.jsp将处理结果写入到响应体
        if (result == 1){
            request.setAttribute("key","更新成功");
        }else {
            request.setAttribute("key","更新失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }
}
