package com.example.upgradedblogengine.mapper;



import com.example.upgradedblogengine.model.Blogpost;
import com.example.upgradedblogengine.web.dto.blogpost.BlogpostDTO;
import com.example.upgradedblogengine.web.dto.blogpost.NewBlogpostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BlogpostMapper {

    BlogpostMapper INSTANCE = Mappers.getMapper(BlogpostMapper.class);

    BlogpostDTO BlogpostToDTO(Blogpost blogpost);

    void updateFromDto(NewBlogpostDTO dto, @MappingTarget Blogpost blogpost);
}
