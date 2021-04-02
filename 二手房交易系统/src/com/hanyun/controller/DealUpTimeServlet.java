package com.hanyun.controller;

import com.hanyun.dao.DealDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class DealUpTimeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int result = 0;
        String dealId = null;
        /*Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()){
            String paramName = (String)paramNames.nextElement();
            houseId = request.getParameter(paramName);
        }*/
        dealId = request.getParameter("dealId");
        String time = request.getParameter("time");

        System.out.println("houseId="+dealId);
        System.out.println("time = " + time);

        DealDao dao = new DealDao();
        result = dao.update(dealId,time);

        if (result == 1){
            request.setAttribute("key","交易时间更新成功");
        }else {
            request.setAttribute("key","交易时间更新失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }
}
