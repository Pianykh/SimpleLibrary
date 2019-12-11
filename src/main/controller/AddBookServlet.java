package main.controller;

import main.model.DAO.BookDAO;
import main.model.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.println("<head>");
        out.println("<title>Add Book Form</title>");
        out.println("</head>");
        out.println("<body>");
        req.getRequestDispatcher("adminMenu.html").include(req, resp);

        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String genre = req.getParameter("genre");
        String series = req.getParameter("series");
        Book book = new Book(1, name, author, genre, series);
        int i = BookDAO.create(book);
        if (i > 0) {
            out.println("<h3>Book saved successfully</h3>");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addBookForm.html").include(req, resp);
    }
}
