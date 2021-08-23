package com.playtika.spring;

public class BubbleSort implements Sortable{
    public void bubbleSort(int[] values){
        System.out.println("Bubble sorting values from bubble sort!");
    }
    @Override
    public void sort(int[] value) {
        this.bubbleSort(value);
    }
}
