import business.UserManager;
import core.Db;
import core.Helper;
import entity.User;
import view.AdminView;
import view.LoginView;

import javax.swing.*;
import java.sql.SQLException;


public class App {
    public static void main(String[] args) throws SQLException {

        Helper.setTheme();
         //LoginView loginView = new LoginView();
        UserManager userManager = new UserManager();
        AdminView adminView = new AdminView(userManager.findByLogin("admin","1234"));

    }
}