package com.czk.hope.util.jpa;

import com.czk.hope.entity.config.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Optional;


/**
 * @Author: Created by ChenZK
 * @Create: 2019/12/24 13:50
 */
public abstract class CrudService<D extends BaseRepository, T, ID extends Serializable> {

    @Autowired
    private D dao;

    public T getById(ID id) {
        T t = null;
        Optional<T> optional = dao.findById(id);
        if (optional.isPresent()) {
            t = optional.get();
        }
        return t;
    }

    public T save(T entity) {
        return (T) dao.save(entity);
    }

    public void deleteById(ID id) {
        dao.deleteById(id);
    }
}
