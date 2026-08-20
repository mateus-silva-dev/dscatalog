package io.github.mateussilva.dscatalog.mapper;

import io.github.mateussilva.dscatalog.dto.CategoryDTO;
import io.github.mateussilva.dscatalog.entities.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toEntity(CategoryDTO dto);
    CategoryDTO toDTO(Category entity);
}
