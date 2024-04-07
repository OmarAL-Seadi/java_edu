/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.patientappp;


/**
 *
 * @author fawaz
 */
public class Patient {
     String name, phone, bloodType, hasInsurance, insuranceCompany;
    char gender;

    public Patient(String name, String phone, String bloodType, char gender, String hasInsurance, String insuranceCompany) {
        this.name = name;
        this.phone = phone;
        this.bloodType = bloodType;
        this.gender = gender;
        this.hasInsurance=hasInsurance;
        this.insuranceCompany=insuranceCompany;
    }
@Override
    public String toString() {
        return "Name:  " + name + "\nPhone# " + phone + "\nBlood Type: " + bloodType + "\nGender: " + gender + "\nHas insurance: "+hasInsurance+"\nInsurance Company: "+insuranceCompany;
    }
}
