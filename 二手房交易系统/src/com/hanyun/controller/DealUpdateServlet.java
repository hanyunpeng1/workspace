package com.hanyun.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class DealUpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dealId = null;
        int result = 0;
        //1、从请求头中获取houseId参数信息
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()){
            String paramName = (String)paramNames.nextElement();
            dealId = request.getParameter(paramName);
        }
        request.setAttribute("key",dealId);
        request.getRequestDispatcher("/dealUpdate.jsp").forward(request,response);
    }
}
