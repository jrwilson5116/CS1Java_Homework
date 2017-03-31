package lab10b;

/**Joey Wilson
 * 3/30/2017
 * Creating GUIs with java.awt and javax.swing
 */

import java.awt.*;
import javax.swing.*;

public class Lab10B extends JFrame{
    
    public static void main(String[] args) {
        // Create frame
        Lab10B frame = new Lab10B();
        frame.setTitle("Lab10B Joey Wilson");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
    //default constructor
    public Lab10B(){
        JPanel p1 = new NewPanel(1);
        JPanel p2 = new NewPanel(4);
        getContentPane().setLayout(new GridLayout(2,1));
        getContentPane().add(p1);
        getContentPane().add(p2);
    }
    
    class NewPanel extends JPanel{
        //One argument constructor
        public NewPanel(int n){
            setLayout(new GridLayout(2,2));
            add(new JButton("Button "+n));
            add(new JButton("Button "+(n+1)));
            add(new JButton("Button "+(n+2)));
        }
    }  
}
