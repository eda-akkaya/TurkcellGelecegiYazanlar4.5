package com.turkcell.repository;

public interface IRepository<T> {

    void addRegister(T t);
    T findById(int id);

}
