package com.company.arhitectural.servicelocator;

import java.util.HashMap;
import java.util.Map;

public  class ServiceLocator {
    private static Map<Class<?>,Object> map=new HashMap<>();

    public static void register(Class<?> contract, Object implementation){
        map.put(contract,implementation);
    }

    public static Object resolve(Class<?> contract){
        return map.get(contract);
    }
}
