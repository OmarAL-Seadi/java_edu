/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject13;

import java.util.Scanner;

/**
 *
 * @author Omar_Lord_War
 */

public class Mavenproject13 {

    public static void main(String[] args) {
       Scanner input= new Scanner (System.in);
       
       System.out.println("Type in a string:");
       String str = input.nextLine();
       
       System.out.println("Enter a letter to delete:");
       char ch = input.nextLine().charAt(0);
       
       deleteCHAR( str , ch );
    }
    public static void deleteCHAR (String s1, char c) {
        String s2 = "";
        for ( int i = 0 ; i< s1.length() ; ++i )
            if ( s1.charAt(i)!=c)
                s2 += s1.charAt(i);

        System.out.println("The string after deleting the character "+ c + ": "+ s2 );
    }
}

    