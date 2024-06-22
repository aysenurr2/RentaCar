package view;

import javax.swing.*;
import java.awt.*;

public class Layout extends JFrame {

    public void guiInitilize(int width, int height){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Rent a Car");
        this.setSize(width,height);

        int x = (Toolkit.getDefaultToolkit().getScreenSize().width-this.getSize().width) / 2 ;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height-this.getSize().height) / 2 ;
        this.setLocation(x,y);
        this.setVisible(true);
    }

}
