package com.hanyun.controller;

import com.hanyun.dao.MessageDao;
import com.hanyun.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class MessageDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String messageId = null;
        int result = 0;
        //1、从请求头中获取adminId参数信息
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()){
            String paramName = (String)paramNames.nextElement();
            messageId = request.getParameter(paramName);
        }
        //messageId = request.getParameter("messageId");
        //2、通过【AdminDao】将adminId填充到delete命名并推送到数据库
        MessageDao dao = new MessageDao();
        result = dao.delete(messageId);
        //3、请求转发向Tomcat调用info.jsp将结果与html标签写入到响应体中
        if (result == 1){
            request.setAttribute("key","删除成功");
        }else {
            request.setAttribute("key","删除失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }
}
