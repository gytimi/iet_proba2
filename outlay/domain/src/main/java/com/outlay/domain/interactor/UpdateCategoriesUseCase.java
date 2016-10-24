package com.outlay.domain.interactor;

import com.outlay.core.executor.PostExecutionThread;
import com.outlay.core.executor.ThreadExecutor;
import com.outlay.domain.model.Category;
import com.outlay.domain.repository.CategoryRepository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by bmelnychuk on 10/24/16.
 */

public class UpdateCategoriesUseCase extends UseCase<List<Category>, List<Category>> {
    private CategoryRepository categoryRepository;

    @Inject
    public UpdateCategoriesUseCase(
            ThreadExecutor threadExecutor,
            PostExecutionThread postExecutionThread,
            CategoryRepository categoryRepository
    ) {
        super(threadExecutor, postExecutionThread);
        this.categoryRepository = categoryRepository;
    }

    @Override
    protected Observable<List<Category>> buildUseCaseObservable(List<Category> categories) {
        return categoryRepository.saveAll(categories);
    }
}