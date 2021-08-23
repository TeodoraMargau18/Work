package training.java.week3.day1;

import java.util.function.Function;

public class WeatherServerConnection implements Function<String, String> {

//    id it s implement callable
//    @Override
//    public String call() throws Exception {
//        Thread.sleep(2000);
//        return "The weather is sunny. Temp is 32";
//    }

    @Override
    public String apply(String s) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return " WeatherServerConnection-The weather is sunny. Temp is 32";
    }

//    @Override
//    public <V> Function<V, String> compose(Function<? super V, ? extends String> before) {
//        return Function.super.compose(before);
//    }
//
//    @Override
//    public <V> Function<String, V> andThen(Function<? super String, ? extends V> after) {
//        return Function.super.andThen(after);
//    }
}
