package com.company.structuralPattern.composite.classes;

public interface Staff {
    void display();
    void addStaff(Staff staff);
    void removeStaff(Staff staff);
    Staff getStaff(int index);

}
