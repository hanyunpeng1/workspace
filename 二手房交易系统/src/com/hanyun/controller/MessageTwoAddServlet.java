package com.hanyun.controller;

import com.hanyun.dao.MessageDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MessageTwoAddServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,text,time;
        int result = 0;
        //1、从请求头中获取参数信息userName
        text = request.getParameter("text");
        userName = request.getParameter("userName");
        time = request.getParameter("time");

        System.out.println("userName = "+userName);
        System.out.println("text = " + text);
        System.out.println("time = "+time);

        //2、调用【MessageDao】向数据库发送信息
        MessageDao dao = new MessageDao();
        result = dao.add(userName,text,time);
        //3、通过请求转发，向Tomcat索要info.jsp将处理结果写入到响应体
        if (result == 1){
            request.setAttribute("key","留言发布成功");
        }else {
            request.setAttribute("key","留言发布失败");
        }
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }
}
