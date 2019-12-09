package main.model.DAO;

import main.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public static int create(User user) {
        int status = 0;
        Connection con = DataBaseConnector.getConnection();
        try {
            PreparedStatement statement = con.prepareStatement("INSERT INTO simplelibrary.users VALUES (DEFAULT ,?,?,?,?,?)");
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getRole());
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
            PreparedStatement statement = con.prepareStatement("DELETE FROM simplelibrary.users WHERE ID=?");
            statement.setInt(1, id);
            status = statement.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int update(User user) {
        int status = 0;
        Connection con = DataBaseConnector.getConnection();
        try {
            PreparedStatement statement = con.prepareStatement("UPDATE simplelibrary.users SET firstName=?, " +
                    "lastName=?, email=?, password=?, role=? WHERE ID=?");
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getRole());
            status = statement.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static List<User> getAll() {
        List<User> users = new ArrayList<User>();
        Connection con = DataBaseConnector.getConnection();
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM simplelibrary.users");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setFirstName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
                user.setPassword(resultSet.getString(5));
                user.setRole(resultSet.getString(6));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;

    }

    public static User getByID(int id) {
        User user = new User();
        Connection con = DataBaseConnector.getConnection();
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM simplelibrary.users WHERE ID=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
                user.setFirstName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
                user.setPassword(resultSet.getString(5));
                user.setRole(resultSet.getString(6));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static List<User> getAllByRole(String role) {
        List<User> users = new ArrayList<User>();
        Connection con = DataBaseConnector.getConnection();
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM simplelibrary.users WHERE role=?");
            statement.setString(1, role);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setFirstName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
                user.setPassword(resultSet.getString(5));
                user.setRole(resultSet.getString(6));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}