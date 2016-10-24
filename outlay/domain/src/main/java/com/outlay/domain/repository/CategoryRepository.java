package com.outlay.domain.repository;

import com.outlay.domain.model.Category;

import java.util.List;

import rx.Observable;

/**
 * Created by bmelnychuk on 10/24/16.
 */

public interface CategoryRepository {
    Observable<List<Category>> getDefault();

    Observable<List<Category>> getAll();

    Observable<Category> getById(Long id);

    Observable<List<Category>> saveAll(List<Category> categories);

    Observable<Category> save(Category category);

    Observable<Category> remove(Category category);
}
