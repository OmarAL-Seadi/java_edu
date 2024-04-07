/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject8;

/**
 *
 * @author Omar_Lord_War
 */
public class Mavenproject8 {

    public static void main(String[] args) {
        Rectangle op1 = new Rectangle(4,40);
        Rectangle op2 = new Rectangle(3.5,35.9);
         System.out.println("Rectangle 1 ");
System.out.println("The width of the Rectangle is : " + op1.width);
        System.out.println("The height of the Rectangle is: " + op1.height);
         System.out.println("The area of the Rectangle is : " + op1.getArea());
        System.out.println("The Perimeter of the Rectangle is: " + op1.getPerimeter());
System.out.println("Rectangle 2 ");
         System.out.println("The width of the Rectangle is : " + op2.width);
        System.out.println("The height of the Rectangle is: " + op2.height);
         System.out.println("The area of the Rectangle is : " + op2.getArea());
        System.out.println("The Perimeter of the Rectangle is: " + op2.getPerimeter());
    }
}

    