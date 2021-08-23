package com.company.locator;

import com.company.shape.Circle;
import com.company.shape.contracts.Shape;
import com.company.ui.LargeCircle;
import com.company.ui.contracts.LargeShape;
public class ServiceLocator {

    public static Shape getShape(){
        return new Circle(5);
    }
    public static LargeShape getLargeShape(){
        return new LargeCircle();
    }
}
