package training.java.week3.day2;

import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class Sum implements Callable<Integer> {
    private Vector<Integer> values = new Vector();

    public Sum(Integer... value) {
        for (Integer i : value) {
            values.add(i);
        }
    }

    @Override
    public Integer call() throws Exception {
//        int sum=0;
//        for(Integer i:values){
//            sum+=i;
//        }
//        return sum;
//        return values.stream().mapToInt(i->(int)i).sum();
        return values.stream().filter((x) -> x % 2 == 0).reduce((a, b) -> a + b).get();
    }
}
