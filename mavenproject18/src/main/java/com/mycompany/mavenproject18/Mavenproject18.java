/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject18;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;





public class Mavenproject18 {

   
    
    public static void main(String[] args) {
       combo one=new combo(); 
       one.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       one.setSize(180,180);
       one.setVisible(true);
    }
}

class combo extends JFrame{
  private final JComboBox <String>  combo ;
  private final JLabel  label ;
   private  static final String[]  names={"omar","ali","fawaz","yasser"} ;
   public combo()
   {
       super("test");
       setLayout(new FlowLayout());
       combo =new JComboBox <String> (names);
       combo.setMaximumRowCount(3);
       combo.addItemListener(
       new ItemListener() {
           @Override
           public void itemStateChanged(ItemEvent e) {
               if (e.getStateChange()==ItemEvent.SELECTED)
                   label.setText(names[combo.getSelectedIndex()]);
           }
       }
       );
       add(combo);
       label=new JLabel(names[0]);
       add(label);
              
   }
  
        
        }

