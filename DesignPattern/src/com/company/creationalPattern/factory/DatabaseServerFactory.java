package com.company.creationalPattern.factory;

public class DatabaseServerFactory {
    private final static String DEVELOPMENT="development";
    private final static String PRODUCTION="production";
    public static DatabaseServer createDatabaseServer(String server){
        if(DEVELOPMENT.equals(server)){
            return new DevelopmentDatabaseServer();
        }if(PRODUCTION.equals(server)){
            return new ProductionDatabaseServer();
        }
        return null;//        ori intorc null ori exceptie
    }

    private static class PreProductionDatabaseServer implements DatabaseServer{
        @Override
        public void connect() {

        }
    }
}

