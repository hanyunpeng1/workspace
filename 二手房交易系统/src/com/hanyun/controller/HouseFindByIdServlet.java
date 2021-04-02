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
import java.util.ArrayList;
import java.util.List;

public class HouseFindByIdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List list = new ArrayList();
        //1、从请求头中获取userName参数信息
        String userName = request.getParameter("userName");
        //2、通过【HouseDao】将userName填充到select命名并推送到数据库
        HouseDao dao = new HouseDao();
        list = dao.findById(userName);
        //3、请求转发向Tomcat调用houseById.jsp将结果与html标签写入到响应体中
        request.setAttribute("key",list);
        request.getRequestDispatcher("/houseById.jsp").forward(request,response);
    }
}
