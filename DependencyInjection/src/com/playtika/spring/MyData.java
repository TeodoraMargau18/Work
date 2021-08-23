package com.playtika.spring;

public class MyData {
    int[] values;
    Sortable mySortAlgorithm = null;

    public MyData() {
        this.mySortAlgorithm = new BubbleSort();
    }

    public MyData(Sortable mySortAlgorithm) {
        this.mySortAlgorithm = mySortAlgorithm;
    }

    //Setter injection
    public Sortable getMySortAlgorithm() {
        return mySortAlgorithm;
    }

    //    Version 1.

//    public void sort(){
//        System.out.println("Bubble sorting the value");
//    }

//  Version 2.
//    public void bubbleSort(){
//        BubbleSort bubbleSort=new BubbleSort();
//        bubbleSort.bubbleSort(this.values);
//    }

    //  Version 3.
    public void sort(int type) {
        if (type == 1) {
            BubbleSort bubbleSort = new BubbleSort();
            bubbleSort.bubbleSort(this.values);
        }
        if (type == 2) {
            InterchangeSort interchangeSort = new InterchangeSort();
            interchangeSort.interchangeSort(values);
        }
    }

    //    Version 4.
    public void sort(Sortable sortAlgorithm) {
        sortAlgorithm.sort(this.values);
    }
//        Version 5.
    public void sort(){
        if(this.mySortAlgorithm!=null){
            this.mySortAlgorithm.sort(this.values);
        }else{
            throw new UnsupportedOperationException();
        }

    }

}
