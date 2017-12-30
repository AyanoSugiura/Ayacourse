package com.zhou.restfultest.service.impl;

import com.zhou.restfultest.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

public class ServiceImpl<T,TD extends Serializable> implements Service<T,TD> {

    @Autowired
    CrudRepository<T,Integer> myppRepository;

    @Override
    public void save(T model) {
        myppRepository.save(model);
    }
    @Override
    public T findById(Integer id) {
        return myppRepository.findOne(id);
    }

    @Override
    public void deleteById(Integer id) {
        myppRepository.delete(id);
    }
    @Override
    public List<T> findAll() {
      return (List<T>)myppRepository.findAll();
    }
   /* @Override
    public void save(List models) {

    }



    @Override
    public T findById(Integer id) {
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }*/
}
