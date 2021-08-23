package com.company.creationalPattern.singleton;

public class DatabaseConnectionV2 {

    public static final DatabaseConnectionV2 instance;
    static {
        instance=new DatabaseConnectionV2();
    }


    private DatabaseConnectionV2(){

    }
}
