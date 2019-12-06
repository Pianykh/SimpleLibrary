package main.model;



import main.model.DAO.UserDAO;




public class Test {
    public static void main(String[] args) {


      //  User user = new User(1, "Vitalina", "Ivonenko", "vitalina@gmail.com", "aaaaaa", "user");
      //  UserDAO.create(user);

        System.out.println(UserDAO.getAll().toString());
        System.out.println(UserDAO.getByID(1).getFirstName());


    }

}
