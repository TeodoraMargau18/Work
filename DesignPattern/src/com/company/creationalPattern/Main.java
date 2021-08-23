package com.company.creationalPattern;

import com.company.creationalPattern.singleton.DatabaseConnection;
import com.company.creationalPattern.singleton.DatabaseConnectionV2;
import com.company.creationalPattern.singleton.DatabaseConnectionV3;

public class Main {

    public static void main(String[] args) {
        DatabaseConnection databaseConnection=DatabaseConnection.getInstance();
        databaseConnection.reset();
        databaseConnection.connect("192.168.0.1");
        databaseConnection=DatabaseConnection.getInstance();
        DatabaseConnectionV2 databaseConnectionV2=DatabaseConnectionV2.instance;
        DatabaseConnectionV3 databaseConnectionV3=DatabaseConnectionV3.CEVA;

    }
}
