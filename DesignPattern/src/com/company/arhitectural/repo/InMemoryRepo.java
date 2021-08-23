package com.company.arhitectural.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InMemoryRepo<T> implements Repository<T>{
    private List<T>  entries=new ArrayList<>();

    @Override
    public void insert(T entry) {
     entries.add(entry);
    }

    @Override
    public void delete(T entry) {
        entries.remove(entry);
    }

    @Override
    public void update(T oldEntry, T newEntry) {
        entries.set(entries.indexOf(oldEntry),newEntry);
    }

    @Override
    public List<T> getAll(Predicate<T> condition) {
        return entries.stream().filter(condition).collect(Collectors.toList());
    }
}
