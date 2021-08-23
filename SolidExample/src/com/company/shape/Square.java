package com.company.shape;

import com.company.shape.contracts.Shape;

//OCP
public class Square implements Shape {
    private int width;
    Square(int width) {
        this.width=width;
    }

    @Override
    public int area() {
        return width*width;
    }
}
