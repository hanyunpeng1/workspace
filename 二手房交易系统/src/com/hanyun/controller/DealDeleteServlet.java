package com.hanyun.controller;

import com.hanyun.dao.DealDao;
import com.hanyun.dao.HouseDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class DealDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dealId = null;
        int result = 0;
        //1、从请求头中获取houseId参数信息
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()){
            String paramName = (String)paramNames.nextElement();
            dealId = request.getParameter(paramName);
        }
        System.out.println("dealId="+dealId);
        //2、通过【DealDao】将dealId填充到delete命名并推送到数据库
        DealDao dao = new DealDao();
        result = dao.delete(dealId);
        //3、请求转发向Tomcat调用info.jsp将结果与html标签写入到响应体中
        if (result == 1){
            request.setAttribute("key","删除成功");
        }else {
            request.setAttribute("key","删除失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }
}
