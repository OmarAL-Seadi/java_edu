/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject9;

import java.util.Scanner;

/**
 *
 * @author Omar_Lord_War
 */
public class Mavenproject9 {

    public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
        String  name1, name2, name3;
	  int len;
        String longestWord;

        System.out.println("Please enter 3 names: ");
        name1=input.next();
        name2=input.next();
        name3=input.next();
	
        len=name1.length();
	  longestWord=name1;

	  if (name2.length()> len)
        {    len=name2.length();longestWord=name2; }

	  if(name3.length()>len)
        {   len=name3.length();longestWord=name3; }
        
  System.out.println("The longest name is "+ longestWord + " with "+ len + "characters.");
       }
   }