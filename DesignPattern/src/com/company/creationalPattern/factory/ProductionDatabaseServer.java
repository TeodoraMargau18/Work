package com.company.creationalPattern.factory;

public class ProductionDatabaseServer implements DatabaseServer{
    ProductionDatabaseServer(){}
    @Override
    public void connect() {
        System.out.println("Production DatabaseServer!!!");
    }
}
