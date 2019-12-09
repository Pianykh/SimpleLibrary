package main.controller;

import main.model.DAO.UserDAO;
import main.model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.println("<head>");
        out.println("<title>Admin Section</title>");
        out.println("</head>");
        out.println("<body>");

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        List<User> admins = UserDAO.getAllByRole("admin");
        User currentAdmin = null;
        for (User admin : admins) {
            if (email.equals(admin.getEmail()) && password.equals(admin.getPassword())) {
                currentAdmin = admin;

            }
        }
        if (currentAdmin == null) {
            req.getRequestDispatcher("index.html").include(req, resp);
            out.println("<h3>Username or password error</h3>");
            out.close();
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("isAdmin", true);
            req.getRequestDispatcher("adminMenu.html").include(req, resp);

        }

    }
}
