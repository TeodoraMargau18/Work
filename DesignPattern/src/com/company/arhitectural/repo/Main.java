package com.company.arhitectural.repo;

public class Main {
    public static void main(String[] args) {
        Repository<Student> repo=new InMemoryRepo<>();
        Student s1=new Student("Gigel",9.7f);
        repo.insert(s1);
        System.out.println(repo.getAll(x->x.getName().startsWith("G")).get(0).getGrade());

    }
}
