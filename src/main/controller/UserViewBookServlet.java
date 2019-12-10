package main.controller;

import main.model.DAO.BookDAO;
import main.model.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserViewBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.println("<head>");
        out.println("<title>View Book</title>");
        out.println("</head>");
        out.println("<body>");
        req.getRequestDispatcher("userMenu.html").include(req, resp);

        List<Book> books = BookDAO.getAll();

        out.print("<table><tr><th>ID</th><th>Name></th><th>Author></th><th>Genre></th><th>Series></th></tr>");
        books.forEach(book -> {
            out.println("<tr><td>" + book.getId() + "</td><td>" + book.getName() + "</td><td>" +
                    book.getAuthor() + "</td><td>" + book.getGenre() + "</td><td>" + book.getSeries() + "</td>");
            ;
        });

    }
}
