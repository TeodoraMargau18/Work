package training.java.week3.day1.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class Worker implements Callable<List<Integer>> {

    private CountDownLatch countDownLatch;
    private int initialValue;
    private int step;
    private int upperLimit;



    public Worker(CountDownLatch countDownLatch, int initialValue,int step,int upperLimit) {
        this.countDownLatch = countDownLatch;
        this.initialValue = initialValue;
        this.step = step;
        this.upperLimit = upperLimit;
    }

    @Override
    public List<Integer> call() throws Exception {

        List<Integer> values=new ArrayList<>();

//        to interrupt the threa

        if(step==0){
            Thread.sleep(10000);
        }
        for(int value=initialValue;value<upperLimit;value+=step){
            values.add(value);
        }
        countDownLatch.countDown();
        return values;
    }
}
