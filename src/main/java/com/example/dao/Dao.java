package com.example.dao;

import java.util.List;

public interface Dao <T>{
    int add(T t);
    void delete(T t);
    void update(T t);
    T getById(int id);
    List<T> getAll();
}
