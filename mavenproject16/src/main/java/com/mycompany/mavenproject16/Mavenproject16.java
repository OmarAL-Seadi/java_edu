/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject16;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


public class Mavenproject16 {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Omar ali","Name",JOptionPane.PLAIN_MESSAGE);
       JOptionPane.showMessageDialog(null, "STOP RIGHT THERE CRIMNAL","WARING",JOptionPane.WARNING_MESSAGE);
       LA one=new LA(); 
       one.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       one.setSize(180,180);
       one.setVisible(true);
       
      
       
    }
}

class LA extends JFrame{
 
     private final JLabel one;
     private final JLabel two;
    
    public LA(){
        super("FAWAZ");
        setLayout(new FlowLayout());
        
        one= new JLabel("QUESTION");
       one.setToolTipText("ALi is the best");
       one.setHorizontalTextPosition(SwingConstants.CENTER);
       one.setVerticalTextPosition(SwingConstants.BOTTOM);
        add(one);
        
         two= new JLabel();
         two.setText("who is the best?");
          two.setHorizontalTextPosition(SwingConstants.LEFT);
       two.setVerticalTextPosition(SwingConstants.BOTTOM);
       two.setToolTipText("ALi is the best");
        add(two);
         
         
         
    }
    
}