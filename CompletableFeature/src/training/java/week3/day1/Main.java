package training.java.week3.day1;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        aici primesc vremea
        CompletableFuture<String> weatherTask = new CompletableFuture<>();

//        CompletableFuture<Void> result = weatherTask.supplyAsync(new GeoLocationService())
////                x= ce ne intoarce new GeoLocationService()=locatia
//                .thenApply((x) -> {
//                    System.out.println("Getting weather data for " + x);
//                    try {
//                        Thread.sleep(1500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    return "Weather is sunny. Temp is 32";
//                }).thenApply((y) -> {
//                    System.out.println("Processing the weather data " + y);
//                    return y.toUpperCase();
//                }).thenAccept((z) -> System.out.println("Weather data " + z));
//
//        result.get();

//        CompletableFuture<String> result2 = weatherTask.supplyAsync(new GeoLocationService())
//                .thenApply((x) -> {
//                    System.out.println("Getting weather data for " + x);
//                    try {
//                        Thread.sleep(1500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    return "";
//                })
//                .thenApply((y) -> {
//                    if (y.isEmpty()) {
//                        throw new UnsupportedOperationException();
//                    }
//                    System.out.println("Processing the weather data " + y);
//                    return y.toUpperCase();
//                }).exceptionally((ex) -> {
//                    System.out.println("Service error " + ex.getCause());
//                    return "No data";
//                }).handle((res, ex) -> {
//                    if (ex == null) {
//                        return res.toUpperCase();
//                    } else {
//                        return "Huston we have a problem " + ex.getCause();
//                    }
//                });
//
//        String weatherData = result2.get();
//        System.out.println("The result2 is " + weatherData);
//



//        CompletableFuture<Void> asyncTask = weatherTask.supplyAsync(new GeoLocationService())
//                .thenApply(new WeatherServerConnection()).thenApply((y) -> {
//                    System.out.println("Processing the weather data " + y);
//                    return y.toUpperCase();
//                }).thenAccept((z) -> System.out.println("Weather data " + z));
//
//        System.out.println("------------The result is for WeatherServerConnection----------- ");
//        asyncTask.get();
//        are rolul de a tine programul principal pornit pana se termina acest task
//        un fel de join pe thread uri


//        Callable VS  CompletableFuture
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> geoService = executorService.submit(new GeoLocationService());
//        aici blochez aplicatia pentru ca astept dupa geolocationService

        executorService.shutdown();
        while (!geoService.isDone()) {
//            System.out.println("Waiting for geoData");
        }
        String geoData = geoService.get();
        System.out.println("Your location is " + geoData);
//-----------
        CompletableFuture<String> geoAsyncTask = new CompletableFuture<>();
        Future geoServiceAsync = geoAsyncTask.supplyAsync(new GeoLocationService())
//                aici ar trebui sa fac acel while. Ce se va executa dupa ce thread ul termina
                .thenAccept((x) -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Your location AGAIN is " + x);
                });
        System.out.println("hi there");
        geoServiceAsync.get();

        System.out.println("The end");
    }
}
