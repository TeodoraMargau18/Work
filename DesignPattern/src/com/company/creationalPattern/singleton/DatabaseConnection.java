package com.company.creationalPattern.singleton;

public class DatabaseConnection {

    private static DatabaseConnection instance = null;
    private static String adress="127.0.0.1";
    private static String port="8080";

    public static synchronized DatabaseConnection getInstance() {
        System.out.println(adress);
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private DatabaseConnection() {
    }
    public synchronized void reset(){
        System.out.println("Connection reset");
    }
    public synchronized void connect(String adress){
        DatabaseConnection.adress=adress;
        System.out.println(adress);
    }
}
