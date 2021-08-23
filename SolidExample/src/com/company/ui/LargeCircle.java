package com.company.ui;

import com.company.ui.contracts.LargeShape;
import com.company.shape.contracts.Shape;

public class LargeCircle implements LargeShape {

//    private Shape shape;
//    Method injection
//    public LargeCircle(Shape shape){
//        this.shape=shape;
//    }
    @Override
    public boolean isLargeShape(Shape shape) {
        return shape.area()>5;
    }
}
