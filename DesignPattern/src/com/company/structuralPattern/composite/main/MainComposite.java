package com.company.structuralPattern.composite.main;

import com.company.structuralPattern.composite.classes.Employee;
import com.company.structuralPattern.composite.classes.Manager;
import com.company.structuralPattern.composite.classes.Staff;

public class MainComposite {
    public static void main(String[] args) {
        Staff e1=new Employee("Cristi");
        Staff e2=new Employee("Vasile");
        Staff e3=new Employee("Florin");
        Staff e4=new Employee("Viorel");

        Staff m1=new Manager("Ionel");
        m1.addStaff(e1);
        m1.addStaff(e4);

        Staff m2=new Manager("Marius");
        m2.addStaff(e3);

        Staff m3=new Manager("Gigel");
        m3.addStaff(e2);
        m3.addStaff(m1);
        m3.addStaff(m2);
        m3.display();

        m3.removeStaff(m2);
        System.out.println("<Manager dupa stergere>");
        m3.display();
//        m3.getStaff(0).display();

    }
}
