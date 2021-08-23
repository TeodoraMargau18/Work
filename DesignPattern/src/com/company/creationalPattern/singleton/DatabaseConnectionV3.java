package com.company.creationalPattern.singleton;

public enum DatabaseConnectionV3 {
    INSTANCE,CEVA;
    public synchronized void reset()
    {}
}
