package main.controller;

import main.model.DAO.BookDAO;
import main.model.DAO.UserDAO;
import main.model.entity.Book;
import main.model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.println("<head>");
        out.println("<title>Add User Form</title>");
        out.println("</head>");
        out.println("<body>");
        req.getRequestDispatcher("adminMenu.html").include(req, resp);

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = new User(1, firstName, lastName, email, password, "user");
        int i = UserDAO.create(user);
        if (i > 0) {
            out.println("<h3>User created successfully</h3>");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addUserForm.html").include(req, resp);

    }
}
