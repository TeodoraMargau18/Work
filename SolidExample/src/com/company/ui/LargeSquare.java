package com.company.ui;

import com.company.ui.contracts.LargeShape;
import com.company.shape.contracts.Shape;

public class LargeSquare implements LargeShape {
    @Override
    public boolean isLargeShape(Shape shape) {
        return shape.area()>50;
    }
}
