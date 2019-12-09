package main.model.DAO;

import main.model.entity.Book;
import main.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public static int create(Book book) {
        int status = 0;
        Connection con = DataBaseConnector.getConnection();
        try {
            PreparedStatement statement = con.prepareStatement("INSERT INTO simplelibrary.books VALUES (DEFAULT ,?,?,?,?)");
            statement.setString(1, book.getName());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getGenre());
            statement.setString(4, book.getSeries());
            status = statement.executeUpdate();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int delete(int id) {
        int status = 0;
        Connection con = DataBaseConnector.getConnection();
        try {
            PreparedStatement statement = con.prepareStatement("DELETE FROM simplelibrary.books WHERE ID=?");
            statement.setInt(1, id);
            status = statement.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int update(Book book) {
        int status = 0;
        Connection con = DataBaseConnector.getConnection();
        try {
            PreparedStatement statement = con.prepareStatement("UPDATE simplelibrary.users SET firstName=?, " +
                    "lastName=?, email=?, password=?, role=? WHERE ID=?");
            statement.setString(1, book.getName());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getGenre());
            statement.setString(4, book.getSeries());
            status = statement.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static List<Book> getAll() {
        List<Book> books = new ArrayList<Book>();
        Connection con = DataBaseConnector.getConnection();
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM simplelibrary.books");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt(1));
                book.setName(resultSet.getString(2));
                book.setAuthor(resultSet.getString(3));
                book.setGenre(resultSet.getString(4));
                book.setSeries(resultSet.getString(5));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public static Book getByID(int id) {
        Book book = new Book();
        Connection con = DataBaseConnector.getConnection();
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM simplelibrary.books WHERE ID=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                book.setId(resultSet.getInt(1));
                book.setName(resultSet.getString(2));
                book.setAuthor(resultSet.getString(3));
                book.setGenre(resultSet.getString(4));
                book.setSeries(resultSet.getString(5));

            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }
}
