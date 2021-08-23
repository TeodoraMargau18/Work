package com.playtika.spring;

public class InterchangeSort implements Sortable {
    public void interchangeSort(int[] values){
        System.out.println("Sorting values from InterchangeSort!");
    }

    @Override
    public void sort(int[] value) {
        interchangeSort(value);
    }
}
