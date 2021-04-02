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
import java.util.Enumeration;

public class HouseUpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String houseId = null,status;
        int result = 0;
        //1、从请求头中获取参数信息
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()){
            String paramName = (String)paramNames.nextElement();
            houseId = request.getParameter(paramName);
            break;
        }
        //houseId = request.getParameter("houseId");
        status = request.getParameter("status");
        System.out.println("houseId:"+houseId);
        System.out.println("status:"+status);
        //2、通过【HouseDao】将参数信息填充到update命名并推送到数据库
        HouseDao dao = new HouseDao();
        result = dao.update(houseId,status);
        //3、通过请求转发，向Tomcat索要info.jsp将处理结果写入到响应体
        if (result == 1){
            request.setAttribute("key","更新成功");
        }else {
            request.setAttribute("key","更新失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }
}
