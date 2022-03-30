package com.cydeo.service;

import java.util.List;

public interface CrudService <T,ID>{
// we create the generic clas instead of  role and user service

    T save(T object);
     List<T> findAll();
     T findById(ID id);
     void deleteById(ID id);
     void update(T object);
}
