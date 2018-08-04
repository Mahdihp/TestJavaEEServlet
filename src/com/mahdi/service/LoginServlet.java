package com.mahdi.service;

import com.mahdi.service.dao.BookDao;
import com.mahdi.service.dao.UserDao;
import com.mahdi.service.model.Entity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {


    UserDao userDao= null;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            userDao=new UserDao();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username!=null && password!=null){

            try {
                userDao = new UserDao();
                if(userDao.login(username,password)){
                    writer.write("Successefully....");
                    response.sendRedirect("./HomeServlet");
                }else{
                    writer.write("Invalide Username & Password");
                    response.sendRedirect("./login.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
