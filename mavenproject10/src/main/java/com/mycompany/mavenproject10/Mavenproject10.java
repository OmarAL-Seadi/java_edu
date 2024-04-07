/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject10;

import java.util.Scanner;

/**
 *
 * @author Omar_Lord_War
 */
public class Mavenproject10 {

    public static void main(String[] args) {
   
     Scanner input=new Scanner(System.in);
     String firstName, middleName, lastName ; 
     int age;    
     System.out.print("First Name: ");
     firstName=input.next();
     System.out.print("Middle Name: ");
     middleName=input.next();
     System.out.print("Last Name: ");
     lastName=input.next();
     System.out.print("Age: ");
     age=input.nextInt();
     
     int midOfMidName=(middleName.length())/2;   
     String initials = firstName.charAt(0) +     middleName.substring(midOfMidName,midOfMidName+1) +    
             lastName.charAt(lastName.length()-1);
     String password = initials.toUpperCase() + age*100; 
     System.out.println("Your Password = "+ password );
     
    }
}

   