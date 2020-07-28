package samplevoting;

import javax.swing.*;
import java.awt.*;

class Demo extends JFrame{
    Demo(){
        JLabel background;
        setSize(690,430);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon img = new ImageIcon("bgg.jpg");
        
        background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,690,430);
        add(background);
        
        setVisible(true);
    }
}

public class Background{

    public static void main(String a[]){
        new Demo();
}
}
