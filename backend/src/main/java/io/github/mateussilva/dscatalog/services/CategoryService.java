package io.github.mateussilva.dscatalog.services;

import io.github.mateussilva.dscatalog.dto.CategoryDTO;
import io.github.mateussilva.dscatalog.entities.Category;
import io.github.mateussilva.dscatalog.mapper.CategoryMapper;
import io.github.mateussilva.dscatalog.repositories.CategoryRepository;
import io.github.mateussilva.dscatalog.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    public CategoryService(CategoryRepository repository, CategoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> list = repository.findAll();
        return list.stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        Category entity = repository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return mapper.toDTO(entity);
    }

    @Transactional
    public CategoryDTO insert(CategoryDTO dto) {
        Category category = mapper.toEntity(dto);
        category = repository.save(category);
        return mapper.toDTO(category);
    }

    @Transactional
    public CategoryDTO update(Long id, CategoryDTO dto) {
        try {
            Category category = repository.getReferenceById(id);
            category.setName(dto.name());
            return mapper.toDTO(repository.save(category));
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException();
        }
    }
}
