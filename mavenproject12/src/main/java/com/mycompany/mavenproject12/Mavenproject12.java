/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject12;

import java.util.Scanner;

/**
 *
 * @author Omar_Lord_War
 */
public class Mavenproject12 {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
     String str;
     int pos;
     
     System.out.println("Enter a String(with at least 3 'm' characters): ");
     str=input.nextLine();
          
     pos=str.toLowerCase().indexOf("m");
     String newStr= str.substring(0, pos) + str.substring(pos + 1); 
     
     pos=newStr.toLowerCase().indexOf("m"); 
     newStr= newStr.substring(0, pos) + newStr.substring(pos + 1); 
   
     pos=newStr.toLowerCase().indexOf("m"); 
     newStr= newStr.substring(0, pos) + newStr.substring(pos + 1);
     System.out.println("The new string: " + newStr );
    }
}
