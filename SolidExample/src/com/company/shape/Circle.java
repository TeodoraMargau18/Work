package com.company.shape;

import com.company.shape.contracts.Shape;

public class Circle implements Shape {

    private int radius;
    public Circle(int radius){
        this.radius=radius;
    }

    @Override
    public int area() {
        return (int) (radius*radius*3.14);
    }
}
