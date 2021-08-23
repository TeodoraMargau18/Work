package training.java.week3.day1;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class GeoLocationService implements Callable<String>, Supplier<String> {

    @Override
    public String call() throws Exception {
        System.out.println("getting your location....");
        Thread.sleep(2000);
        return "Lat: 45, long: 16";
    }

    @Override
    public String get() {
        System.out.println("getting your location with get....");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Lat: 130, long: 77";
    }
}
