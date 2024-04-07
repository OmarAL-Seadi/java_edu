/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.school;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


 import java.util.*;
 import java.lang.*;
 import javax.print.DocFlavor.STRING;
 import javax.swing.GroupLayout.Alignment;
 import javax.xml.crypto.Data;
 
 public class School{
      
     static String teacher_menu="\n\n\n\t** Welcome to Teacher Sub-system **\n"+
     "\t1- add your personal information \n" +
     "\t2- add new course \n" +
     "\t3- remove a course\n"+
     "\t4- Print all courses \n"+
     "\t5- back \n"+
     "\nYour Choice: " ;
 
     // will need an array of office and class  
     static String manager_menu="\n\n\n\t** Welcome to Manager Sub-system **\n"+
     "\t1- add your personal information \n" +
     "\t2- show your roles \n" +
     "\t3- show all staff \n" +
     "\t4- add office information \n"+
     "\t5- show office information\n"+
     "\t6- add class information\n"+
     "\t7- add students to the class\n"+
     "\t8- show students of this class\n"+
     "\t9- add class utils storage info\n"+
     "\t10- add class utils to the storage\n"+
     "\t11- show all class utils storage info\n"+
     "\t12- add equipments storage info\n"+
     "\t13- add equipments to the storage\n"+
     "\t14- show all equipments storage info\n"+
     "\t15- back \n"+
     "\nYour Choice: " ;
 
     static String student_menu="\n\n\n\t** Welcome to Student Sub-system **\n"+
         "\t1- add your personal information \n" +
         "\t2- add course \n" +
         "\t3- add Teacher \n" +
         "\t4- print grades\n"+
         "\t5- show Teachers\n"+
         "\t6- back \n"+
         "\nYour Choice: " ;
 
     static String main_menu="\n** Welcome to the School System **\n"+
         "1- Teacher Subsystem\n" +
         "2- Student Subsystem\n" +
         "3- Manager Subsystem\n" +
         "4- Exit \n"+
         "\nYour Choice: " ;
 
 
         public static boolean isNumeric(String input) 
         {
             //try block attempts to parse the input string as a double using Double.parseDouble().
             try {
                 Double.parseDouble(input);
                 return true;
             }
             
             
             //The NumberFormatException is a specific exception class in Java that is thrown when a method attempts to convert a string to a numeric type
             // if a NumberFormatException is thrown during the parsing process, the catch block is executed. In this case, it means that the input string is not a valid number, and false is returned from the method.
             catch (NumberFormatException e) {
                 return false;
             }
         }
 
 
     
       
 
         
     public static void main(String args[])
     {
          
 
         Scanner input = new Scanner(System.in);
         ClassUtil utils = new ClassUtil();
         Equipment equipment = new Equipment();
         Manager manager = new Manager();
 
         Teacher teacher = new Teacher();
         Student student=new Student();
 
 
         ArrayList<Office> offices = new ArrayList<Office>();
         ArrayList<Classes> classes = new ArrayList<Classes>();
         ArrayList<Person> staff = new ArrayList<Person>(); // it uses polymorphisim.
 
         staff.add(new Teacher("Ali","200000000"));
         staff.add(new Teacher("Khalid","200000001"));
         staff.add(new Teacher("Essam","200000002"));
 
 
         staff.add(new Student("Mohammed","222000000"));
         staff.add(new Student("Ahmed","222000001"));
         staff.add(new Student("Saad","222000002"));
 
             String mainMenue;
             // CowSay
             System.out.println("_________________");
             System.out.println(" THE CORRECT PLACE TO MANAGE ALL YOUR SCHOOL STAFFS ");
             System.out.println("---------------------------------------------------");
             System.out.println("         \\   ^__^");
             System.out.println("          \\  (oo)\\___");
             System.out.println("             (__)\\       )\\/\\");
             System.out.println("                 ||----w |");
             System.out.println("                 ||     ||");
             System.out.print(main_menu);
             mainMenue = input.nextLine();
             
        
         while(!mainMenue.equals("4"))
         {
            
 
             if(mainMenue.equals("1"))
             {
 
                 String Tmenue;
                 System.out.print(teacher_menu);
                 Tmenue = input.nextLine();
                 
                 while(!Tmenue.equals("5"))
                 {
                    if (Tmenue.equals("1")) 
                    {
                        teacher=new Teacher();
                         String n, i;
                         System.out.print("\nEnter teacher name: ");
                         n = input.nextLine();
 
                         boolean validName = false;
                         while (!validName) 
                         {
                             if (!isNumeric(n)) {
                                 validName = true; // Set validName to true to exit the loop
                             } else {
                                 System.out.println("\nInvalid name! The name should not be a number.");
                                 System.out.print("\nEnter teacher name: ");
                                 n = input.nextLine();
                             }
                         }
                        boolean validId = false;
                         while (!validId) 
                         {
                             System.out.print("\nEnter teacher ID (ID length should be 9): ");
                             i = input.nextLine();
 
                             if (i.length() == 9&& isNumeric(i)) {
                                 boolean found = false;
 
                                 for (int j = 0; j < staff.size(); j++) {
                                     if (i.equals(staff.get(j).getId())) {
                                         found = true;
                                         break;
                                     }
                                 }
 
                                 if (!found) {
                                     teacher.setName(n);
                                     teacher.setId(i);
                                     staff.add(teacher);
                                     validId = true; // Set validId to true to exit the loop
                                      System.out.println("\nTeacher added successfully.");
                                 } else {
                                     System.out.println("\nThis ID is already used! Please enter a different ID.");
                                 }
                             } else {
                                 System.out.println("\nInvalid ID, enter 9 numbers");
                             }
                         }
                     }




                     else if (Tmenue.equals("2"))
                     {  
                        if(teacher.numCourses<5){
                            String cn;
                            System.out.print("\nEnter the name of the course: ");
                            cn=input.nextLine();
                            teacher.addCourses(cn);
                         }else{
                            System.out.println("you can only add up to 5 courses!");
                         }
                         
                     }
 
                     else if (Tmenue.equals("3"))
                     {
                         if(teacher.numCourses!=0){
                         teacher.ShowCourses();
                         String dcn;
                         System.out.print("\nEnter the name of the course to remove: ");
                         dcn=input.nextLine();
                         teacher.removeCource(dcn);
                         }
                         else
                         {
                             System.out.println("\nYou don't have courses");
                         }
                     }
 
                     else if (Tmenue.equals("4"))
                     {
                         
                         teacher.ShowCourses();
                     }
 




                else
                 {
                     System.out.print("\nPlease Enter number between 1-5");
                 }
 
 
 
 
 
 
 
 
 
                     
                     System.out.print(teacher_menu);
                     Tmenue = input.nextLine();

                 
                 }
             }
 
 
 
 
 
 
 
 
             else if (mainMenue.equals("2")) 
             {
                 
 
                 String Smenue;
                 System.out.print(student_menu);
                 Smenue = input.nextLine();
                 
                 while(!Smenue.equals("6"))
                 {
  
                     // Student ifs here
                        if (Smenue.equals("1")) 
                        {
                         student = new Student();
                         String ns, i2;
                         System.out.print("\nEnter student name: ");
                         ns = input.nextLine();
 
                         boolean validName2 = false;
                         while (!validName2) {
                             if (!isNumeric(ns)) {
                                 validName2 = true; // Set validName to true to exit the loop
                                        
                             } else {
                                 System.out.println("\nInvalid name! The name should not be a number.");
                                 System.out.print("\nEnter student name: ");
                                 ns = input.nextLine();
                             }
                         }
                        boolean validId2 = false;
                         while (!validId2) {
                             System.out.print("\nEnter student ID (ID length should be 9): ");
                             i2 = input.nextLine();
 
                             if (i2.length() == 9&& isNumeric(i2)) {
                                 boolean found = false;
 
                                 for (int j = 0; j < staff.size(); j++) {
                                     if (i2.equals(staff.get(j).getId())) {
                                         found = true;
                                         break;
                                     }
                                 }
 
                                 if (!found) {
                                     student.setName(ns);
                                     student.setId(i2);
                                     staff.add(student);
                                     validId2 = true; // Set validId to true to exit the loop
                                     System.out.println("\nstudent added successfully.");
                                 } else {
                                     System.out.println("\nThis ID is already used! Please enter a different ID.");
                                 }
                             } else {
                                 System.out.println("\nInvalid ID, enter 9 numbers");
                             }
                         }
                     }
 
                     // "\t2- add course \n" +
                     else if(Smenue.equals("2"))
                     {
                         String nc;
                         double gc;
                         System.out.print("\nEnter course name: ");
                         nc = input.nextLine();
                         System.out.print("\nEnter the grade: ");
                         String gradeInput = input.nextLine();
                         
 
                         if (isNumeric(gradeInput)) 
                         {
                             gc = Double.parseDouble(gradeInput);
                             if (gc >= 0 && gc <= 100) 
                             {
                                 student.addCourses(nc, gc);
                                 System.out.println("\nGrade added successfuly");
                             } 
                             else 
                             {
                                 System.out.println("\nPlease enter a number in this range 0-100.");
                             }
                         } 
                         else
                         {
                             System.out.println("\nInvalid grade input. Please enter a number.");
     
                         }
                     }
                     
 
 
 
 
 
 
 
 
                     
                     else if(Smenue.equals("3"))
                     {
 
                         String nat,idt;
                         for(int i=0; i<staff.size(); i++)
                         {
                             if(staff.get(i) instanceof Teacher)
                             {
                             System.out.println("\n"+staff.get(i).getName()+" "+staff.get(i).getId());
                             }
                         }
                        
                         System.out.print("\nEnter the id of the teacher: ");
                         idt=input.nextLine();
                         boolean found =false;
                         for(int i=0; i<staff.size(); i++)
                         {
                             if(idt.equals(staff.get(i).getId())&& staff.get(i) instanceof Teacher)
                             {
                                 nat = staff.get(i).getName();
                                 student.addTeacher(nat,idt);
                                 found=true;
                                 break;
                             }
                             
                         }
 
                         if(found)
                         {}
                         else
                         {
                             System.out.print("\nThe teacher not found" );
                         }
 
                     }
                     
 
 
                      // "\t4- print grades\n"+
                     else if(Smenue.equals("4"))
                     {
                        
                         student.ShowCourses();
 
                     }
 
                     // "\t5- show Teachers\n"+
                     else if(Smenue.equals("5"))
                     {
                          student.showTeachers();
                          
                          
                         
                     }
 
 
 
 
 
 
                 else
                 {
                     System.out.print("\nPlease Enter number between 1-6");
                 }
 
 
 
 
 
 
 
 
 
 
 
 
                 System.out.print(student_menu);
                 Smenue = input.nextLine();
                 
 
                 }
             }
 
 
 
 
 
 
 

             
             else if (mainMenue.equals("3")) 
             {
                 
                String Mamenue;
                Office office = new Office();
                Classes class0 = new Classes();
                System.out.print(manager_menu);
                Mamenue= input.next();
                
                input.nextLine();



                
                    
                while (!(Mamenue.equals("15"))) {

                  

                    if(Mamenue.equals("1"))
                    {
                         
                        String name,id;
                        System.out.print("\nEnter your name: ");
                        name = input.nextLine();

                        System.out.print("\nEnter your ID: ");
                        id = input.nextLine();

                        manager.setName(name);
                        manager.setId(id);

                    }




                    
                    else if(Mamenue.equals("2"))
                    {

                        System.out.println();
                        for(String role:manager.ROLES){

                            System.out.println(role);

                        }

                    }
                    
                    




                    else if(Mamenue.equals("3"))
                    {

                        manager.showAllStaff(staff);

                    }
                    
                    



                    else if(Mamenue.equals("4"))
                    {
                        office = new Office();
                        String number;
                        int capacity = 1;
                        
                        System.out.print("\nEnter the office number: ");
                        number = input.nextLine();
                        office.setNumber(number);

                        System.out.print("\nEnter the capacity: ");
                        capacity = input.nextInt();
                        input.nextLine();
                        office.setCapacity(capacity);
                        

                        //Teacher adding

                        String nat,idt;
                        for(int i=0; i<staff.size(); i++)
                        {
                            if(staff.get(i) instanceof Teacher)
                            {
                            System.out.println("\n"+staff.get(i).getName()+" "+staff.get(i).getId());
                            }
                        }
                       
                        System.out.print("\nEnter the id of the teacher: ");
                        idt=input.nextLine();
                        boolean found =false;
                        for(int i=0; i<staff.size(); i++)
                        {
                            if(idt.equals(staff.get(i).getId())&& staff.get(i) instanceof Teacher)
                            {
                            
                                nat = staff.get(i).getName();
                                office.addTeacher(nat,idt);
                                found=true;
                                break;
                            }
                            
                        }

                        boolean isther = false;
                        for(int k = 0; k<offices.size(); k++){
                            if(offices.get(k).teacher.getId().equals(idt) || offices.get(k).getNumber().equals(number)){
                                isther = true;
                                break;
                            }
                        }

                        if(found && !isther)
                        {
                            System.out.print("\nThe teacher added successfully" );
                            offices.add(office);
                        }
                        else
                        {
                            System.out.print("The teacher not found or a problem has occured!" );
                        }

                        

                    }
                    
                    





                    
                    else if(Mamenue.equals("5"))
                    {
                        String ofnum;
                        System.out.print("\nEnter office numeber: ");

                        ofnum = input.nextLine();
                        boolean found = false;
                        
                        //for-each
                        for(Office off: offices)
                        {
                            if(off.getNumber().equals(ofnum)){
                                found = true;

                                System.out.println();
                                off.showOfficeInfo();
                                break;
                            }
                        }


                        if(!found)
                        {
                            System.out.println("\nThis office was not found!");
                        }

                    }
                    
                    





                    else if(Mamenue.equals("6"))
                    {
                        class0 = new Classes();
                        String number;
                        int capacity = 3;
                        
                        System.out.print("\nEnter the class number: ");
                        number = input.nextLine();
                        class0.setNumber(number);

                        System.out.print("\nEnter the capacity: ");
                        capacity = input.nextInt();
                        input.nextLine();
                        class0.setCapacity(capacity);

                        //Teacher adding

                        String nat,idt;
                        for(int i=0; i<staff.size(); i++)
                        {
                            if(staff.get(i) instanceof Teacher)
                            {
                            System.out.println("\n"+staff.get(i).getName()+" "+staff.get(i).getId());
                            }
                        }
                       
                        System.out.print("\nEnter the id of the teacher: ");
                        idt=input.nextLine();
                        boolean found =false;
                        boolean isther = false;

                        for(int i=0; i<staff.size(); i++)
                        {
                            if(idt.equals(staff.get(i).getId())&& staff.get(i) instanceof Teacher)
                            {
                                nat = staff.get(i).getName();

                                class0.addTeacher(nat, idt);
                                found=true;
                                break;
                            }
                            
                        }

                        for(int x = 0; x<classes.size(); x++){
                            if(classes.get(x).getNumber().equals(number)){
                                isther = true;
                            }
                        }

                        if(found && !isther)
                        {
                            System.out.print("\nThe teacher added successfully" );
                            classes.add(class0);
                            // System.out.println(classes.size());
                        }
                        else
                        {
                            System.out.print("\nThe teacher not found or problem has occuerd!!" );
                        }


                    }
                    
                    
                    
                    else if(Mamenue.equals("7"))
                    {
                        //Student adding
                        System.out.println();
                        String number;
                        boolean found1 = false;
                        System.out.print("\nEnter the number of the class: ");
                        number = input.nextLine();


                        for(int j =0; j<classes.size(); j++){
                            // System.out.println(classes.get(j));


                            if(classes.get(j).getNumber().equals(number)){
                                found1 = true;
                                String nat,idt;

                                for(int i=0; i<staff.size(); i++)
                                    {
                                        if(staff.get(i) instanceof Student)
                                        {
                                        System.out.println("\n"+staff.get(i).getName()+" "+staff.get(i).getId());
                                        }
                                    }
                            
                                
                                System.out.print("\nEnter the id of the Student: ");
                                idt=input.nextLine();
                                boolean found =false;
                                for(int i=0; i<staff.size(); i++)
                                {
                                    if(idt.equals(staff.get(i).getId())&& staff.get(i) instanceof Student)
                                    {
                                        nat = staff.get(i).getName();

                                        classes.get(j).addStudent(nat, idt);
                                        found=true;
                                        break;
                                    }
                                    
                                }

                                if(found)
                                {
                                    System.out.print("\nThe Student added successfully" );

                                }
                                else
                                {
                                    System.out.print("\nThe Student was not found" );
                                }
                                break;
                            }
                        }

                        if(!found1){
                            System.out.println();
                            System.out.println("This class was not found!");
                        }
                    }
                    
                    
                    
                    else if(Mamenue.equals("8"))
                    {

                        System.out.println();
                        String number;
                        boolean found1 = false;

                        System.out.print("Enter the number of the class: ");
                        number = input.nextLine();

                        for(Classes class1:classes){
                            if(class1.getNumber().equals(number)){
                                found1 = true;
                                System.out.println("*******");

                                System.out.println("class capacity:"+class1.getCapacity());
                                System.out.println("class number:"+class1.getNumber());

                                System.out.println("class Teacher:"+class1.teacher.getName());
                                System.out.println("*******");

                                class1.showStudentInfo();
                                break;
                            }
                        }

                        if(!found1){
                            System.out.println("This class was not found!");
                        }
                    }
                    
                    
                    
                    else if(Mamenue.equals("9"))
                    {
                        utils.setName("Class utils Storage");
                        String code;
                        System.out.print("\nEnter the number of the storage: ");

                        code = input.nextLine();
                        utils.setCode(code);
                    }
                    
                    
                    
                    
                    
                    
                     if(Mamenue.equals("10"))
                    {
                        String noPens,noErasers,noChairs,noTables;
                        System.out.print("\nEnter the number of chairs: ");
                        noChairs = input.nextLine();
                        
                        System.out.print("\nEnter the number of tabels: ");
                        noTables = input.nextLine();
                        
                        System.out.print("\nEnter the number of erasers: ");
                        noErasers = input.nextLine();
                        
                        System.out.print("\nEnter the number of pens: ");
                        noPens = input.nextLine();
                        
                        utils.setNoErasers(noErasers);
                        utils.setNoPens(noPens);
                        utils.setNoChairs(noChairs);
                        utils.setNoTables(noTables);
                    }
                    
                    
                    
                    
                    else if(Mamenue.equals("11"))
                    {
                        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$");
                        System.out.println("Storage code:" + utils.getStoreCode());
                        System.out.println("number of pens:" + utils.getNoPens());
                        System.out.println("number of tabels:" + utils.getNoTables());
                        System.out.println("number of erasers:" + utils.getNoErasers());
                        System.out.println("number of chairs:" + utils.getNoChairs());
                        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$");
                    }
                    
                    
                    
                    
                    else if(Mamenue.equals("12"))
                    {
                        String Snum;
                        equipment.setName("Equipments Storage");
                        System.out.print("\nEnter the Number of the Storage: ");

                        Snum = input.nextLine();
                        equipment.setCode(Snum);
                    }
                    
                    
                    
                    
                    
                    else if(Mamenue.equals("13"))
                    {
                        String noCarts,noComputer,noSpareLights;
                        System.out.print("\nEnter the number of computers: ");

                        noComputer = input.nextLine();
                        
                        System.out.print("\nEnter the number of SpareLights: ");
                        noSpareLights = input.nextLine();
                        
                        System.out.print("\nEnter the number of Carts: ");
                        noCarts = input.nextLine();
                        
                        equipment.setNoCarts(noCarts);
                        equipment.setNoSpareLights(noSpareLights);
                        equipment.setNoComputers(noComputer);
                    }
                    
                    
                    
                    
                    else if(Mamenue.equals("14"))
                    {
                        System.out.println("######################");
                        System.out.println("Storage code: " + equipment.getStoreCode());
                        System.out.println("number of computers: " + equipment.getNoComputer());
                        System.out.println("number of spare lights: " + equipment.getNoSpareLights());
                        System.out.println("number of carts: " + equipment.getNoCarts());
                        System.out.println("######################");
                    }
                    
                    System.out.print(manager_menu);
                    Mamenue= input.nextLine();
                
                }
                
             }
               else
             {
                 System.out.println("\nPlease Enter number between 1-4");
             }
             
       
             
            
 
 
             System.out.print(main_menu);
             mainMenue = input.nextLine();
             
         }
 
     }
 }
 
 class Person{
     private String name;
     private String id;
     Person(){}
 
     public String getName(){
         return this.name;
     }
 
     public String getId(){
         return this.id;
     }
 
     public void setName(String name) {
         this.name = name;
     }
 
     public void setId(String id) {
         this.id = id;
     }
 
 }
 
 class Student extends Person
 {
 
 
 
     int numCourses = 0;
     int numTeacher = 0;
     final static int MAX_COURSES = 10;
     String Courses[] = new String[MAX_COURSES];
     double Grades[] = new double[MAX_COURSES];
     Teacher teachers[] = new Teacher[MAX_COURSES];
     public Student(){}
     public Student(String name,String id){
         super.setName(name);
         super.setId(id);
     }
     
     public void showTeachers()
     {
         if(numTeacher!=0){
         for(int i =0; i<numTeacher; i++)
         {
             System.out.println("\n"+(i+1)+"- the teacher name: " + "[ "+teachers[i].getName() +" ]" + " and the teacher id: " + teachers[i].getId());
         }
     }
     else
     {
         System.out.println("\nyou don't add teacher");
     }
     }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
     public void addTeacher(String name, String id)
     {
 
     boolean found=false;
     for (int i = 0; i < numTeacher; i++) 
     {
         if (id.equals(teachers[i].getId()))
         {
         found=true;
         } 
 
     }
 
     if(found)
     {
         System.out.println("\nit will not add because it duplicate");
     }
     else
     {
         System.out.println("\nThe teacher "+name + " was added successfully");
         teachers[numTeacher] = new Teacher(name,id);
         numTeacher ++;
     }
 
         
     }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
     public void ShowCourses()
     {
         if(numCourses!=0)
         {
         System.out.println("\nThe Course you have: ");
         for(int i =0; i<numCourses; i++){
             System.out.println(("\n")+(1+i)+"- the Course name: " +"[ "+Courses[i]+" ]" + " and the Course grade: " + Grades[i]);
         }
         }
 
         else
         {
             System.out.println("\nYou dont have Courses");
 
         }
 
     }
 
 
 
 
 
 
 
 
     public void  addCourses(String Course, double grade){
         
     boolean found=false;
     for (int i = 0; i < numCourses; i++) 
     {
         if (Course.equals(Courses[i])) 
         {
         found=true;
         } 
 
     }
 
     if(found)
     {
         System.out.println("\nit will not add because it duplicate");
     }
     else
     {
         System.out.println("\nThe course "+Course + " added successfully");
         Courses[numCourses] = Course;
         Grades[numCourses] = grade;
         numCourses ++;
     }
 
     }
 }
 
 
 
 
 
 
 
 
 class Teacher extends Person
 {
     final static int MAX_COURSES = 6;
     int numCourses = 0;
     String courses[] = new String[MAX_COURSES];
 
     public Teacher(){}
     public Teacher(String name, String id){
         super.setName(name);
         super.setId(id);
     }
 
     public void ShowCourses()
     {
 
         if(numCourses==0)
         {
             System.out.println("\nYoud don't have courses");
         }
 
         else
         {
         System.out.println("\nThe courses you have:");
         for(int i = 0; i<numCourses; i++)
         {
         System.out.println("\n"+(i+1)+("- ")+courses[i]);
         }
         }
     }
     
     public boolean removeCource(String name){
         boolean found = false;
         for(int i =0; i<numCourses; i++)
         {
             if(name.equals(courses[i]))
             {
                 for(int j =i; j<numCourses; j++)
                 {
                     courses[j] = courses[j+1];
                 }
                 found = true;
                 numCourses --;
                 break;
             }
             
         }
         if(found==true)
         {
             System.out.println("\nThe course "+name + " was removed successfully");
            return found; 
         }
         else
         {
             System.out.println("\ncourse not found!!");
             return found;
         }
     }
 
 
 
 
 
 
     public void addCourses(String name) 
     {
     
     boolean found=false;
     for (int i = 0; i < numCourses; i++) 
     {
         if (name.equals(courses[i])) 
         {
         found=true;
         } 
 
     }
 
     if(found)
     {
         System.out.println("\nit will not add because it duplicate");
     }
     else
     {
         System.out.println("\nThe course "+name + " was added successfully");
         courses[numCourses] = name;
         numCourses++;
     }
 
 
     
     }
     
 }
 
 
 
 class Manager extends Person{
     final static String ROLES[] = {"manageing Stoarges", "manageing buldings", "manageing all other school people"};
     public Manager(){}
     public Manager(String name, String id){
         super.setName(name);
         super.setId(id);
     }
     public void showAllStaff(ArrayList<Person> staff){
         int numStu=0;
         int numTea=0;
         for(int i =0; i<staff.size(); i++){
             if(staff.get(i) instanceof Teacher){
                 numTea++;
             }
             if(staff.get(i) instanceof Student){
                 numStu++;
             }
         }
         System.out.println("\n****Number of Students:" + numStu + "****");
         System.out.println("****Number of Teachers:" + numTea + "****");
         for(int i =0; i<staff.size(); i++){
            if(staff.get(i) instanceof Teacher){
                System.out.println("\n"+(i+1+"- Name: ")+staff.get(i).getName()+":Teacher , Id: "+ staff.get(i).getId());
            }else{
                System.out.println("\n"+(i+1+"- Name: ")+staff.get(i).getName()+":Student , Id: "+ staff.get(i).getId());
            }  
             
         }
     }
 
     public void shoeRoles(){
         for(String role:ROLES){
             System.out.println(role);
         }
     }
     
 }
 
 //
 class Buildings 
     {
         private String name;
         private String number;
         private int capacity;
     
         public Buildings() 
         {
         }
     
         public Buildings(String number, int capacity) 
         {
             this.number = number;
             this.capacity = capacity;
         }
     
       
 
     
         public String getNumber() 
         {
             return number;
         }
     
 
         public int getCapacity() 
         {
             return capacity;
         }
 
 
         public void setNumber(String number)
         {
             this.number = number;
         }
 
     
         public void setCapacity(int capacity) 
         {
             this.capacity = capacity;
         }
     }
 
     
      class Office extends Buildings 
     {
         private static int numOfOffice = -1;
         Teacher teacher;
 
     
         public Office() 
         {
             numOfOffice++;
             
         }
     
 
 
         public Office(String number, int capacity) 
         {
             super(number, capacity);
             numOfOffice++;
             
         }
     
         public void showOfficeInfo() {
             System.out.println("number of offices " + (numOfOffice));
             System.out.println("\nTeacher: " + teacher.getName());
         }
     
 
 
         public void addTeacher(String name, String id) 
         {
             teacher = new Teacher(name, id);
         }
 
     }
 
 class Classes extends Buildings 
     {
         ArrayList<Student> students = new ArrayList<Student>();
 
         Teacher teacher;
     
         public Classes() 
         {
             
         }
     
 
         public Classes(String number, int capacity) 
         {
             super( number, capacity);
             // students = new Student[capacity];
         }
 
         public void showStudentInfo() 
         {
             System.out.println("Number of Students: " + students.size());
             for (int i = 0; i < students.size(); i++) 
             {
                 System.out.println("Student " + (i + 1) + ": " + students.get(i).getName());
             }
         }
     
 
         public void addStudent(String name, String id)
         {
             students.add(new Student(name, id));
         }
 
 
     
         public void addTeacher(String name, String id) 
         {
             teacher = new Teacher(name, id);
         }
     }
 
 class Storage {
     private String storageName;
     private String storageNo;
 
     public Storage() 
     {
         
     }
 
     public Storage(String storageName, String storageNo) {
         this.storageName = storageName;
         this.storageNo = storageNo;
     }
 
     public String getStoreCode() {
         return storageNo;
     }
 
     public String getStoreName() {
         return storageName;
     }
 
     public void setCode(String c) {
         storageNo = c;
     }
 
     public void setName(String n) {
         storageName = n;
     }
 }
 
  class ClassUtil extends Storage {
     private String noPens;
     private String noErasers;
     private String noChairs;
     private String noTables;
 
     public ClassUtil() {
     }
 
     public ClassUtil(String storageName, String storageNo) {
         super(storageName,storageNo);
     }
 
     public String getNoPens() {
         return noPens;
     }
 
     public String getNoErasers() {
         return noErasers;
     }
 
     public String getNoChairs() {
         return noChairs;
     }
 
     public String getNoTables() {
         return noTables;
     }
 
     public void setNoPens(String np) {
         noPens = np;
     }
 
     public void setNoErasers(String ne) {
         noErasers = ne;
     }
 
     public void setNoChairs(String nc) {
         noChairs = nc;
     }
 
     public void setNoTables(String nt) {
         noTables = nt;
     }
 }
 
  class Equipment extends Storage {
     private String noCarts;
     private String noComputer;
     private String noSpareLights;
 
     public Equipment() {
     }
 
     public Equipment(String storageName, String storageNo) {
           super(storageName,storageNo);
     }
 
     public String getNoCarts() {
         return noCarts;
     }
 
     public String getNoComputer() {
         return noComputer;
     }
 
     public String getNoSpareLights() {
         return noSpareLights;
     }
 
     public void setNoCarts(String nC) {
         noCarts = nC;
     }
 
     public void setNoComputers(String nCo) {
         noComputer = nCo;
     }
 
     public void setNoSpareLights(String nS) {
         noSpareLights = nS;
     }
 }