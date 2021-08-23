package com.company.creationalPattern.factory;

public class DevelopmentDatabaseServer implements DatabaseServer{
    DevelopmentDatabaseServer (){

    }
    @Override
    public void connect() {
        System.out.println("******Development DatabaseServer");
    }
}
