package com.company;

import com.company.locator.ServiceLocator;
import com.company.shape.contracts.Shape;
import com.company.ui.contracts.LargeShape;

public class Main {

    public static void main(String[] args) {
        Shape s= ServiceLocator.getShape();
        LargeShape x=ServiceLocator.getLargeShape();
        System.out.println(x.isLargeShape(s));

        var z=5.7f;
        System.out.println(z);
    }
}
