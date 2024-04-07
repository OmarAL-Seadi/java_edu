/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject3;

import java.util.Scanner;

/**
 *
 * @author Omar_Lord_War
 */
public class Mavenproject3 {

    public static void main(String[] args) {
        System.out.println(" Enter Three number");
        Scanner input=new Scanner (System.in);
        Double X, Y, Z, avg, MIX, MIN;
        X=input.nextDouble();
              Y=input.nextDouble();
                Z=input.nextDouble();
        if (Y<0)
             System.out.println(" ERror 2 ");
           if (X<0)
             System.out.println(" ERror 1");
             if (Z<0)
             System.out.println(" ERror 3");
             avg=(X+Y+Z)/3;
             MIX= Math.max(Z, Math.max(X, Y));
             MIN= Math.min(Z, Math.min(X, Y));
              System.out.println("avg "+avg+" MIX "+MIX+" MIN "+MIN);
             
        
        
        
       
    }
}
