package com.company.structuralPattern.composite.classes;

import java.util.ArrayList;
import java.util.List;

public class Manager implements Staff{
    private String name;
    private List<Staff> subordinates=new ArrayList<>();

    public Manager(String name) {
        this.name = name;
    }
    public Manager() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.printf("Manager: %s \n",name);
        for(Staff staff:subordinates){
            System.out.print("    ");
            staff.display();
        }
    }

    @Override
    public void addStaff(Staff staff) {
        subordinates.add(staff);
    }

    @Override
    public void removeStaff(Staff staff) {
//        ca sa il stearga exact pe acela ar trebui supradefinit equals
        subordinates.remove(staff);
    }

    @Override
    public Staff getStaff(int index) {
        if(index<0||index>=subordinates.size()){
            throw new UnsupportedOperationException();
        }
        return subordinates.get(index);
    }
}
