package com.company.arhitectural.repo;

import java.util.List;
import java.util.function.Predicate;

public interface Repository <T>{
    void insert(T entry);
    void delete(T entry);
    void update(T oldEntry,T newEntry);
    List<T> getAll(Predicate<T> condition);//fac cu conditie lambda
}
