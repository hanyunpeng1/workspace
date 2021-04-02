package com.hanyun.controller;

import com.hanyun.dao.HouseDao;
import com.hanyun.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class HouseDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String houseId = null;
        int result = 0;
        //1、从请求头中获取houseId参数信息
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()){
            String paramName = (String)paramNames.nextElement();
            houseId = request.getParameter(paramName);
        }
        //houseId = request.getParameter("houseId");
        //2、通过【HouseDao】将houseId填充到delete命名并推送到数据库
        HouseDao dao = new HouseDao();
        result = dao.delete(houseId);
        //3、请求转发向Tomcat调用info.jsp将结果与html标签写入到响应体中
        if (result == 1){
            request.setAttribute("key","删除成功");
        }else {
            request.setAttribute("key","删除失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }
}
