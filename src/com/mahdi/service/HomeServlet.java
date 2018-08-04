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
import java.sql.SQLException;

@WebServlet(name = "HomeServlet", urlPatterns = {"/HomeServlet"})
public class HomeServlet extends HttpServlet {

    BookDao bookDao=null;


    @Override
    public void init() throws ServletException {
        super.init();
        try {
            bookDao = new BookDao();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Entity[] entities = new Entity[0];
        try {
            entities = bookDao.readAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("books", entities);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
