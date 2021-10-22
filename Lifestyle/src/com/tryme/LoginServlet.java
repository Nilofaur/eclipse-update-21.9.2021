package com.tryme;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import SQL.SQL;

//import net.javaguides.login.bean.LoginBean;
//import net.javaguides.login.database.LoginDao;




public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;
    public static String username;
    public static   String name2 ;
public static String un;
    public void init() {
        loginDao = new LoginDao();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);

        try {
            if (loginDao.validate(loginBean)) {
                HttpSession session = request.getSession();
                 session.setAttribute("username",username);
                 response.sendRedirect("loginsuccess.jsp?name="+username);
                 un=username;
                 System.out.println(un + " "  + "logged in :) ");
                 SQL.un(un);
                name2 = DaoClass.un(un);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("user", username);
                //FILENAME
                
                response.sendRedirect("login.jsp");
               session.invalidate();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
