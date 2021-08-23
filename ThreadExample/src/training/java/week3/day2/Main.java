package training.java.week3.day2;

import training.java.week3.day2.anononimFunction.BinaryOperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Task t=new Task();
        ArrayList<ArrayList> threads=new ArrayList<>();
        t.start();
        t.join();
        System.out.println("Main end");

        Sum s1=new Sum(1,2,3);
        Sum s2=new Sum(4,5,6,7,8,9);

        ExecutorService threadPool= Executors.newFixedThreadPool(2);
        Future<Integer> f1=threadPool.submit(s1);
        Future<Integer> f2=threadPool.submit(s2);
//        threadPool.shutdown();

        List<Future<Integer>> futures= threadPool.invokeAll(Arrays.asList(s1,s2));

        try{
            System.out.println(f1.get()+f2.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        BinaryOperation m=new Multiplication();
        int res=m.operation(4,5);
        Integer x=123454444;
        System.out.println(res);
        BinaryOperation d=new BinaryOperation() {
            @Override
            public int operation(int a, int b) {
                return a/b;
            }
        };

        System.out.println(d.operation(3,8));

         BinaryOperation s=(a,b)-> {
             return (a - b);
         };
        System.out.println(s.operation(3,8));

    }
}
