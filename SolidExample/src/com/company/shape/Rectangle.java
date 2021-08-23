package com.company.shape;

import com.company.shape.contracts.Shape;

public class Rectangle implements Shape {
    private int width;
    private int height;

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int area() {
        return width * height;
    }
}
