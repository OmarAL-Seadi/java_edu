/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject21;

import java.io.IOException;

/**
 *
 * @author Omar_Lord_War
 */
public class Mavenproject21 {

    public static void main(String[] args) {
     readFile("omar" );
    }

    
    public static void readFile(String filename) {
  try {
            processFile(filename);  
            
        } catch (IOException e) {
            System.err.println("An IOException occurred: " + e.getMessage());
        }
    }
    
public static void  processFile(String filename) throws IOException {
 throw new IOException("Error occurred while reading file: ") ;
}
}
