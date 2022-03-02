package com.example.upgradedblogengine.mapper;

import com.example.upgradedblogengine.model.Category;
import com.example.upgradedblogengine.web.dto.category.CategoryDTO;
import com.example.upgradedblogengine.web.dto.category.NewCategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {


    //ez igazából beaneket mappol össze, még csak definiálni sem kell
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToDTO(Category airport);

    void updateFromDto(NewCategoryDTO dto, @MappingTarget Category category);

}
