package main.controller;

import main.model.DAO.BookDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDAO.delete(Integer.parseInt(req.getParameter("ID")));
        resp.sendRedirect("AdminViewBook");

    }
}
