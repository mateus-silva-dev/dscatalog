package io.github.mateussilva.dscatalog.services;

import io.github.mateussilva.dscatalog.entities.Category;
import io.github.mateussilva.dscatalog.repositories.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll() {
        return repository.findAll();
    }
}
