package com.hanyun.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;

/*
将JDBC规范下相关对象【创建】与【销毁功能】封装到方法

一、JDBC开发步骤：
    1、注册数据库服务提供的Driver接口实现类
    2、创建一个连接通道交给Connection接口的实例对象【JDBC4Connection】
    3、创建一个交通工具交给PreparedStatement接口的实例对象【JDBC4PreparedStatement】管理
    4、由交通工具在java工程与数据库服务器之间进行传输，推送sql命令并带回执行结果
    5、交易结束之后，销毁相关资源【Connection，PreparedStatement，ResultSet】
 */
public class JdbcUtil {
    Connection con = null;//类文件属性，可以在类文件中所有的方法中使用
    PreparedStatement ps = null;//类文件属性，可以在类文件中所有的方法中使用

    //--------通过全局作用域对象得到Connection----------start
    public Connection creatCon(HttpServletRequest request){
        //1、通过请求对象，得到全局作用域对象
        ServletContext appliaction = request.getServletContext();
        //2、从全局作用域对象得到map
        Map map = (Map) appliaction.getAttribute("key1");
        //3、从map得到一个处于空闲状态Connection（拖鞋）
        Iterator it = map.keySet().iterator();
        while (it.hasNext()){
            con = (Connection) it.next();
            boolean flag = (boolean)map.get(con);
            if(flag){
                //为true表示Connection处于空闲状态
                map.put(con,false);//这里的con是key，key重复，value会被覆盖。即更新数据
                break;
            }
        }
        return con;
    }
    public PreparedStatement creatPs(String sql, HttpServletRequest request){
        //Connection con = creatCon(request);//调用了creatCon()方法，这里已经进行了创建连接通道。
        try {
            ps = creatCon(request).prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }
    public void close(HttpServletRequest request){
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        ServletContext application = request.getServletContext();
        Map map = (Map)application.getAttribute("key1");
        map.put(con,true);
    }
    //--------通过全局作用域对象得到Connection----------end

    //静态代码块 static{}
    //在当前类文件第一次被加载到JVM时，JVM将会自动调用当前类文件静态语句块
    static {
        /*ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("driver");*/

        try {
            //1、注册数据库服务器提供的Driver接口实现类
            //或：Class.forName(driver);
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Driver接口实现类被注册了");
    }

    //封装Connection对象创建细节
    public Connection creatCon(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/House","root","666");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection对象创建失败....");
        }
        return con;
    }

    //封装PreparedStatement对象创建细节
    public PreparedStatement creatPs(String sql){
        Connection con = creatCon();//调用了creatCon()方法，这里已经进行了创建连接通道。
        try {
            ps = con.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    //封装PreparedStatement对象与Connection对象销毁细节
    public void close(){
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //封装PreparedStatement对象与Connection对象与ResultSet对象销毁细节
    public void close(ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close();
    }
}
