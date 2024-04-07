/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject2;

import java.util.Scanner;

/**
 *
 * @author Omar_Lord_War
 */
public class Mavenproject2 {

    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a degree in Fahrenheit: ");
    double fahrenheit = input.nextDouble(); 
    double celsius = (5.0 / 9) * (fahrenheit - 32);
    System.out.println("Fahrenheit " + fahrenheit + " is " + 
      celsius + " in Celsius");  


  }
}