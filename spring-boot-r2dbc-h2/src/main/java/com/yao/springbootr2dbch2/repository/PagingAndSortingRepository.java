package com.yao.springbootr2dbch2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;

/**
 * @className PagingAndSortingRepository
 * @description: TODO
 * @author: yaoyao
 * @create: 2019/11/06 15:57
 */
public interface PagingAndSortingRepository<T, ID> extends CrudRepository<T, ID> {

    Iterable<T> findAll(Sort sort);

    Page<T> findAll(Pageable pageable);
}
