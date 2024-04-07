/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.patientappp;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author fawaz
 */
public class PatientFrame extends JFrame  {
    ArrayList<Patient> patientsListArrayList=new ArrayList<Patient>();
    JButton submitButton;
    JLabel nameLabel, phoneLabel, bloodTypeLabel,counterLabel;
    ButtonGroup genderGroup;
    JRadioButton maleRadioBtn, femaleRadioBtn;
    JTextField nameText, phoneText, companyText;
    JComboBox<String> bloodTypeCombo;
    String[] bloodTypesArr = {"A+","A-","B+","B-", "AB-", "AB+", "O+", "O-"};
    static int  patientCounter=0;
    JCheckBox insuranceCheckBox;
    JPanel namePanel, phonePanel;

    PatientFrame() {
        super("Patient Details");
        setLayout(new FlowLayout());

          counterLabel=new JLabel("Patient  # "+(patientCounter+1));
        add(counterLabel);
        
         nameLabel = new JLabel("Name:");
        nameText = new JTextField("",20);
        namePanel = new JPanel();
        namePanel.add(nameLabel);
        namePanel.add(nameText);
        add(namePanel);

        genderGroup = new ButtonGroup();
        maleRadioBtn = new JRadioButton("Male", true);
        femaleRadioBtn = new JRadioButton("Female", false);
        genderGroup.add(maleRadioBtn);
        genderGroup.add(femaleRadioBtn);
        add(maleRadioBtn);
        add(femaleRadioBtn);

        phonePanel = new JPanel();
        phoneLabel = new JLabel("Phone:");
        phoneText = new JTextField("",20);
        phonePanel.add(phoneLabel);
        phonePanel.add(phoneText);
        add(phonePanel);

        //bloodTypePanel
        bloodTypeLabel = new JLabel("Blood Type:");
        bloodTypeCombo = new JComboBox<String>(bloodTypesArr);
        bloodTypeCombo.setMaximumRowCount(3);
        bloodTypeCombo.setSelectedIndex(-1);
        add(bloodTypeLabel);
        add(bloodTypeCombo);

        insuranceCheckBox = new JCheckBox("Do you hava medical insurance?");
        insuranceCheckBox.addItemListener(new ItemListener()
        {

            @Override
            public void itemStateChanged(ItemEvent e) {
               if(insuranceCheckBox.isSelected())
                   companyText.setEditable(true);
               else
               {
                  companyText.setEditable(false);
                  companyText.setText("");
               }
            }
            
        }
       );
        
        add(insuranceCheckBox);
        
        
        companyText=new JTextField("",20);
        companyText.setEditable(false);
        add(companyText);
        submitButton = new JButton("Submit");
        add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                 
               //first ensure that the user enter all required data. (name,phone,blood type)
                 if(nameText.getText().length()!=0 && phoneText.getText().length()!=0 && bloodTypeCombo.getSelectedIndex()!=-1)
                 {
                    String name=nameText.getText();
                    String phone=phoneText.getText();
                   char gender=(maleRadioBtn.isSelected())?'M':'F';
                   String bloodType=bloodTypesArr[bloodTypeCombo.getSelectedIndex()];
                   
                   String hasInsurance,insuranceCompany ;
                   if (insuranceCheckBox.isSelected())
                   {
                        hasInsurance= "Yes";
                        insuranceCompany=companyText.getText();
                   }
                   else
                   {
                        hasInsurance= "No";
                        insuranceCompany="NA";
                   }
                   
                   
                   //Are you sure you want to add this patient?
                  //Create new Patient Object: 
                  Patient newPatient=new Patient(name,phone,bloodType,gender,hasInsurance,insuranceCompany);
              int ans= JOptionPane.showConfirmDialog(PatientFrame.this,
"Patient Info\n---------------------------\n"+newPatient.toString(),
"Confirm Patient Info.", JOptionPane.YES_NO_OPTION);
                 
                 if(ans==0) //yes?
                 {
                   patientCounter++;
                   //add it to ArrayList
                  patientsListArrayList.add(newPatient);
                   
                   //Clear inputs and update counter
                   counterLabel.setText("Patient  # "+(patientCounter+1));
                   nameText.setText("");
                   phoneText.setText("");
                   maleRadioBtn.setSelected(true);
                   bloodTypeCombo.setSelectedIndex(-1);
                   insuranceCheckBox.setSelected(false);
                 }
                 }
                 else  
                 {
                       JOptionPane.showMessageDialog(PatientFrame.this,"You have to fill all the information","Missing Information",JOptionPane.WARNING_MESSAGE);
                 }
                 
                }
                }
        );
    
} //end of constructor
} //end of frame


