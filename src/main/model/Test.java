package main.model;



import main.model.DAO.BookDAO;
import main.model.DAO.UserDAO;
import main.model.entity.Book;


public class Test {
    public static void main(String[] args) {


      //  User user = new User(1, "Vitalina", "Ivonenko", "vitalina@gmail.com", "aaaaaa", "user");
      //  UserDAO.create(user);

      //  System.out.println(UserDAO.getAll().toString());
       // System.out.println(UserDAO.getByID(1).getFirstName());

        System.out.println(UserDAO.getAllByRole("user").get(0).getFirstName());
        System.out.println(UserDAO.getAllByRole("admin").get(0).getFirstName());
    }

}
