package com.hanyun.controller;

import com.hanyun.dao.AdminDao;
import com.hanyun.entity.Admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class AdminFindByIdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminId = null;
        int result = 0;
        //1、从请求头中获取adminId参数信息
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()){
            String paramName = (String)paramNames.nextElement();
            adminId = request.getParameter(paramName);
        }
        //2、通过【AdminDao】将adminId填充到select命名并推送到数据库
        AdminDao dao = new AdminDao();
        Admin admin = new Admin();
        admin = dao.findById(adminId);
        //3、请求转发向Tomcat调用questionById.jsp将结果与html标签写入到响应体中
        request.setAttribute("key",admin);
        request.getRequestDispatcher("/adminById.jsp").forward(request,response);
    }
}
