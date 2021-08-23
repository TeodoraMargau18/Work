package training.java.week3.day1.threads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        int noThreads = 3;
        CountDownLatch countDownLatch = new CountDownLatch(noThreads);

        Worker worker1 = new Worker(countDownLatch, 10, 5, 50);
        Worker worker2 = new Worker(countDownLatch, 2, 0, 50);
        Worker worker3 = new Worker(countDownLatch, 1, 3, 50);

        System.out.println("Starting worker");

        ExecutorService executors = Executors.newFixedThreadPool(noThreads);

//        submit intoarce un Future
//        pentru a lua rez  am nevoie de Future

        Future<List<Integer>> future1 = executors.submit(worker1);
        Future<List<Integer>> future2 = executors.submit(worker2);
        Future<List<Integer>> future3 = executors.submit(worker3);

        System.out.println("Waiting result...");
//        timeout e mi ok decat await pt ca await e blocant
//        thread ul principal se trezeste dupa 3 secunde-pun ceva
//        foarte mare ca sa fiu sigur ca nu ajunge niciodata acolo
//        await fara param -> countDownLatch ==0?, doar atunci trezeste thread ul principal
        boolean normalTerminate = countDownLatch.await(3, TimeUnit.SECONDS);
        System.out.println("Counter value "+countDownLatch.getCount());
        System.out.println("Normal termination: "+normalTerminate);
        System.out.println("Printing results");
//All threads have finish
        System.out.println(future1.get());

        if (future2.isDone()) {
            System.out.println(future2.get());
        } else {
            System.out.println("Worker2 is still running.....");
//            il termin ca sa nu mai stau dupa el
            future2.cancel(true);
        }
        System.out.println(future3.get());

//        executors.shutdown();


//Fara countDownLatch
        List<Worker> workers= Arrays.asList(worker1,worker2,worker3);
        List<Future<List<Integer>>> futures= executors.invokeAll(workers,3,TimeUnit.SECONDS);
        System.out.println("Results = "+futures.size());
        for(Future<List<Integer>> future:futures){
//            all future is done, but which is cancelled?
//           if( future.isDone()&&!future.isCancelled()){
            if( !future.isCancelled()){
                System.out.println("Result= "+future.get().toString());
            }else{
                System.out.println("Task cancelled ");
            }
        }

//        If you need result in their order(how thread terminated)
        System.out.println("----------------executorCompletionService----------------");
        CompletionService<List<Integer>> executorCompletionService=new ExecutorCompletionService(executors);
        for(Worker worker:workers){
            executorCompletionService.submit(worker);
        }

        while(!executors.isTerminated()){
            Future<List<Integer>> results=executorCompletionService.poll();
            if(results!=null){
                System.out.println("Obtained result "+results.get());
            }
        }

        executors.shutdown();
    }
}
