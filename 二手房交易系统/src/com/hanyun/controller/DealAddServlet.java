package com.hanyun.controller;

import com.hanyun.dao.DealDao;
import com.hanyun.dao.HouseDao;
import com.hanyun.entity.Deal;
import com.hanyun.entity.House;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DealAddServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String houseId,userNameA,userNameB;
        Deal deal = null;
        int result = 0;
        //1、从请求头中获取参数信息
        houseId = request.getParameter("houseId");
        userNameA = request.getParameter("userNameA");
        userNameB = request.getParameter("userNameB");
        //2、调用【DealDao】将用户信息填充到insert命令并借助JDBC规范发送到数据库服务器
        deal = new Deal(Integer.valueOf(houseId),userNameA,userNameB,null);
        DealDao dao = new DealDao();
        result = dao.add(deal);
        //3、通过请求转发，向Tomcat索要info.jsp将处理结果写入到响应体
        if (result == 1){
            request.setAttribute("key","购买成功，请耐心等待管理员处理合同。");
        }else {
            request.setAttribute("key","购买失败！");
        }
        request.getRequestDispatcher("/info.jsp").forward(request,response);
    }
}
