/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab1;

abstract class StaffMember{
String Name;
int ID;
double re;
double ba;
double salary;

public StaffMember(){}
public StaffMember(String Name, int ID , double re, double ba){
        this.Name= Name;
        this.ID=ID;
        this.ba=ba;
        this.re=re;
        }
public int getID(){
 return ID;
}
public String getName(){
 return Name;
}
public double getRecruitment(){
 return re;
}
public double getBased (){
 return ba;}


public void setID(int ID){
 this.ID= ID;
}
public void setNAme(String Name){
 this.Name= Name;
}
public void setRecruitment(Double re){
 this.re= re;
}
public void setBased (double ba){
 this.ba=ba ;
}
public abstract double Salary();
}

class Managers extends StaffMember {
    
public double Salary(){
salary = ba+(ba*(2024-re)*0.01);
return salary;}

}

class Engineers extends StaffMember{
    
public double Salary(){
salary = ba+(ba*(2024-re)*0.02);
return salary;}
}








        
        
        
public class Lab1 {


    }

