package com.hanyun.controller;

import com.hanyun.dao.UserDao;
import com.hanyun.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class UserFindServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List list = new ArrayList();
        //1、调用Dao推送查询命令得到所有的用户信息
        UserDao dao = new UserDao();
        Users user = new Users();
        list = dao.find();
        //2、将得到的用户信息添加到请求作用域对象作为共享数据
        request.setAttribute("key",list);
        //3、请求转发向Tomcat调用userFind.jsp将结果与html标签写入到响应体中
        request.getRequestDispatcher("/userFind.jsp").forward(request,response);
    }
}
