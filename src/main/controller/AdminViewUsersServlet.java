package main.controller;

import main.model.DAO.UserDAO;
import main.model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AdminViewUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.println("<head>");
        out.println("<title>View Users</title>");
        out.println("</head>");
        out.println("<body>");
        req.getRequestDispatcher("adminMenu.html").include(req, resp);

        List<User> users = UserDAO.getAllByRole("user");

        out.print("<table><tr><th>ID</th><th>First Name</th><th>Last Name</th><th>E-mail</th><th>Password</th></tr>");
        users.forEach(user -> {
            out.println("<tr><td>" + user.getId() + "</td><td>" + user.getFirstName() + "</td><td>" +
                    user.getLastName() + "</td><td>" + user.getEmail() + "</td><td>" + user.getPassword() + "</td><td><a href='UserDelete?ID=" + user.getId() + "'>Delete</a></td></tr>");

        });
    }
}
