/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.patientappp;

import javax.swing.JFrame;

/**
 *
 * @author Omar_Lord_War
 */
public class PatientAppp {

    public static void main(String[] args) {
     
        PatientFrame  patientFrame =new PatientFrame ();
       patientFrame.setSize(300,300);     
       patientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       patientFrame.setVisible(true);
    }
}