package training.java.week3.day2;

public class Task extends Thread{



    @Override
    public void run() {
        try {

            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Message from another thread");
    }
}
