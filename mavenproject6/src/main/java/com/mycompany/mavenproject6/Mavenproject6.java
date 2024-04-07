/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject6;

import java.util.Scanner;

/**
 *
 * @author Omar_Lord_War
 */
public class Mavenproject6 {

    public static void main(String[] args) {
        int word = 1;
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please enter a string to count number of words in it:\n");
        String str = input.nextLine();
        str=str.trim();
        
        if (str.length()==0)
            word=0;
      
        for (int i = 0; i < str.length(); i++) 
          if (str.charAt(i)==' ') 
              word++; 
        
        System.out.println("Number of words " + word );
 }

    }
