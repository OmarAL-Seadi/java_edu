/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.courserecordtest;

import java.util.Scanner;
import java.util.*;



/*    CourseRecordTest */


public class CourseRecordTest {

    /**
     * @param args the command line arguments
     */
    
    
    static int level1_Counter = 0, level2_Counter = 0, level3_Counter = 0;
    static Scanner input = new Scanner(System.in);
    

    
    public static void main(String[] args) {
        // TODO code application logic here
        CourseRecord[][] courseRecords = new CourseRecord[3][5];
        int choice = menu();
        
        while (choice != 5) {
            switch (choice) {
                case 1:
                    addCourse(courseRecords);
                    break;
                case 2:
                    printCourseRecords(courseRecords);
                    break;
                case 3:
                    searchCourseRecord(courseRecords);
                    break;
               
            }
            input.nextLine();
            choice = menu();
            
        }
        
        
    }
    
    static int menu() {
       
        System.out.println("\n\nMenu:");
        System.out.println("1- Add Course");
        System.out.println("2- Print all course records");
        System.out.println("3- Search");
        System.out.println("5- Exit");
        System.out.println("Enter your choice: ");
        return input.nextInt();
    }
    
    static void addCourse(CourseRecord[][] courseRecords) {
        
       int level = 0;
        
        try {
            
            System.out.println("Adding New Course:");
            System.out.println("-------------------------");
            System.out.println("Please enter level number: ");
       
            level = input.nextInt();
            
            if ( level < 1 || level>3)
                System.out.println("Available levels are: 1, 2 and 3");
             else 
            {
            System.out.println("Please enter course information:\nCourse Code: ");
            String code = input.next(); //** string
            
            input.nextLine();
            System.out.println("Course Title: ");
            String title = input.nextLine();
            
            System.out.println("Instructor Name: ");
            String name = input.nextLine();
           
            System.out.println("Credit Hours: ");
            double hours = input.nextDouble();
           
            System.out.println("Room Number: ");
            int room = input.nextInt();
            
            
            switch (level) {
                case 1:
                    courseRecords[0][level1_Counter++] = new CourseRecord(code, title, name, room, hours);
                    break;
                case 2:
                    courseRecords[1][level2_Counter++] = new CourseRecord(code, title, name, room, hours);
                    break;
                case 3:
                    courseRecords[2][level3_Counter++] = new CourseRecord(code, title, name, room, hours);
                    break;
                
               } // switch
            } //else     
        } // try
        catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println("Level [" + level + "] has 5 courses."
                    + "You cannot add more courses to this level..");
        }       
        catch (InputMismatchException ex) {
            System.err.println("Input Mismatch Exception");
            input.nextLine();            
        } 
        catch (Exception ex) {
            System.err.println(ex.getMessage());
               input.nextLine();
        }
        
    }
    
    static void printCourseRecords(CourseRecord[][] courseRecords) {
        System.out.println("Printing All Available Courses");
        System.out.println("--------------------------------");

        //printing level1 courses:
        if (level1_Counter != 0) {
            System.out.println("Available Courses in Level 1:");
            
            for (int col = 0; col < level1_Counter; col++) {
                System.out.println("Course " + (col + 1) + ":\n" + courseRecords[0][col].toString() + "\n");
            }
        }

        //printing level2 courses:
        if (level2_Counter != 0) {
            System.out.println("Available Courses in Level 2:");
            for (int col = 0; col < level2_Counter; col++) {
                System.out.println("Course " + (col + 1) + ":\n" + courseRecords[1][col].toString() + "\n");
            }
        }
        //printing level3 courses:
        if (level3_Counter != 0) {
            System.out.println("Available Courses in Level 3:");
            for (int col = 0; col < level3_Counter; col++) {
                System.out.println("Course " + (col + 1) + ":\n" + courseRecords[2][col].toString() + "\n");
            }
        }
    }
    
    static void searchCourseRecord(CourseRecord[][] courseRecords) {
        System.out.println("Updating Course Record");
        System.out.println("-------------------------");
        System.out.println("Please enter level number:");
        int level = input.nextInt();
        System.out.println("Please enter course code:");
        String code = input.next();
        int found = -1;
        
        switch (level) {
            case 1:
                for (int i = 0; i < level1_Counter; i++) {
                    if (courseRecords[0][i] != null && courseRecords[0][i].getCourseCode().equals(code)) {
                        found = i;
                        break;
                    }
                }
                
                 case 2:
                for (int i = 0; i < level1_Counter; i++) {
                    if (courseRecords[0][i] != null && courseRecords[0][i].getCourseCode().equals(code)) {
                        found = i;
                        break;
                    }
                }
                
                 case 3:
                for (int i = 0; i < level1_Counter; i++) {
                    if (courseRecords[0][i] != null && courseRecords[0][i].getCourseCode().equals(code)) {
                        found = i;
                        break;
                    }
                }
                
                           
                
        }
        
        if (found>-1){
            System.out.println("Found");
        }
           else
        {
             System.out.println(" Not Found");
        }
    }}
    


/* Course record*/
class CourseRecord {
    
    private String courseCode;  
    private String  courseTitle, instructorName;
    private int classRoom;
    private double creditHours;

    
    public CourseRecord(String courseCode, String courseTitle, String instructorName, int classRoom, double creditHours) {
            this.courseCode = courseCode;
            this.courseTitle = courseTitle;
            this.instructorName = instructorName;
            this.classRoom = classRoom;
            this.creditHours = creditHours;
}
    
@Override
    public String toString() {
        return  "Course Code: " + courseCode + "\nTitle: " + courseTitle + "\nInstructor: " + instructorName + "\nClass Room:" + classRoom + "\nCredit Hours: " + creditHours + "\n\n";
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public String getCourseCode() {
        return courseCode;
    }


    public int getClassRoom() {
        return classRoom;
    }

    public double getCreditHours() {
        return creditHours;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public void setClassRoom(int classRoom) {
        this.classRoom = classRoom;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCreditHours(double creditHours) {
        this.creditHours = creditHours;
    }
    
}


