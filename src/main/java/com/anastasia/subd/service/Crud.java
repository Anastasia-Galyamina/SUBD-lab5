package com.anastasia.subd.service;

import com.anastasia.subd.model.PageableItems;

import java.util.List;
import java.util.Optional;

public interface Crud<T> {

    void create(T t);

    List<T> findAll();

    T get(Integer id);

    Optional<T> find(Integer id);

    PageableItems<T> findAll(int offset, int count);

    void update(T t);

    void delete(T t);
}
