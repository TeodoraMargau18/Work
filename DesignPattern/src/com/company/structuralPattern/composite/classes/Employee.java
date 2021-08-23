package com.company.structuralPattern.composite.classes;

public class Employee implements Staff{
    private String name;

    public Employee(String name) {
        this.name = name;
    }
    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("    Employee:  "+name);
    }

    @Override
    public void addStaff(Staff staff) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeStaff(Staff staff) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Staff getStaff(int index) {
        throw new UnsupportedOperationException();
    }
}
