package com.example.upgradedblogengine.mapper;

import com.example.upgradedblogengine.model.Category;
import com.example.upgradedblogengine.model.Label;
import com.example.upgradedblogengine.web.dto.category.CategoryDTO;
import com.example.upgradedblogengine.web.dto.category.NewCategoryDTO;
import com.example.upgradedblogengine.web.dto.label.LabelDTO;
import com.example.upgradedblogengine.web.dto.label.NewLabelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LabelMapper {

    //ez igazából beaneket mappol össze, még csak definiálni sem kell
    LabelMapper INSTANCE = Mappers.getMapper(LabelMapper.class);

    LabelDTO labelToDTO(Label airport);

    void updateFromDto(NewLabelDTO dto, @MappingTarget Label label);
}
