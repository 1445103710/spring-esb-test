package com.yao.springbootr2dbch2.repository;

import org.springframework.data.repository.Repository;

import java.util.Optional;

/**
 * @className CrudRepository
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/11/06 15:57
 */
public interface CrudRepository<T, ID> extends Repository<T, ID> {

    <S extends T> S save(S entity);

    Optional<T> findById(ID primaryKey);

    Iterable<T> findAll();

    long count();

    void delete(T entity);

    boolean existsById(ID primaryKey);

    // … more functionality omitted.
}
