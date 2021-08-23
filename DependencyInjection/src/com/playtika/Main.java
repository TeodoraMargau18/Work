package com.playtika;

import com.playtika.spring.BubbleSort;
import com.playtika.spring.InterchangeSort;
import com.playtika.spring.MyData;

public class Main {


//Main=IoC pentru ca el alege ce referinta sa injecteze
    public static void main(String[] args) {
        MyData data = new MyData();
//        data.sort();
//        data.sort(1);
//        data.sort(2);
        data.sort(new BubbleSort());
        data.sort(new InterchangeSort());

        MyData myData2=new MyData(new InterchangeSort());
        myData2.sort();
    }
}
