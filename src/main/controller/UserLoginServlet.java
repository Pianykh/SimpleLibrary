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

public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.println("<head>");
        out.println("<title>User Section</title>");
        out.println("</head>");
        out.println("<body>");

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        List<User> users = UserDAO.getAllByRole("user");
        User currentUser = null;
        for (User user : users) {
            if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                currentUser = user;
            }
        }
        if (currentUser == null) {
            req.getRequestDispatcher("index.html").include(req, resp);
            out.println("<h3>Username or password error</h3>");
            out.close();
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("isUser", true);
            req.getRequestDispatcher("userMenu.html").include(req, resp);

        }

    }
}
