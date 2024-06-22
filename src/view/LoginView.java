package view;

import business.UserManager;
import core.Helper;
import entity.User;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class LoginView extends Layout{
    private JPanel container;
    private JPanel w_top;
    private JLabel lbl_welcome;
    private JLabel lbl_welcome2;
    private JPanel w_bottom;
    private JTextField fld_username;
    private JLabel lbl_username;
    private JLabel lbl_pass;
    private JPasswordField fld_pass;
    private JButton btn_login;
    private final UserManager userManager;

    public LoginView() {
        this.userManager = new UserManager();

        this.add(container);
        this.guiInitilize(500,500);

        btn_login.addActionListener(e -> {
            JTextField[] checkFieldList = {this.fld_username, this.fld_pass};
            if (Helper.isFieldListEmpty(checkFieldList)){
                Helper.showMsg("fill");
            }else {
                User loginUser = this.userManager.findByLogin(this.fld_username.getText(), this.fld_pass.getText());
                if (loginUser == null){
                    Helper.showMsg("notFound");
                }else {
                    AdminView adminView = new AdminView(loginUser);
                    dispose();
                }
            }
        });
    }


}