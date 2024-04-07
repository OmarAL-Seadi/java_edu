/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject15;
import java.util.Scanner;

/**
 *
 * @author Omar_Lord_War
 */
public class Mavenproject15 {

    public static void main(String[] args) {
        Order AO= new Order("AL",69);  
                        System.out.println(AO.getorderName()+ AO.orderPrice()+AO.NumberOfOrders);

        Order LL= new Order("ss",84584);
                System.out.println(LL.getorderName()+ LL.orderPrice()+LL.NumberOfOrders);
    }
    }
    
