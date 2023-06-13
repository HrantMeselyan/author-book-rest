package com.example.authorbookrest.mapper;

import com.example.authorbookrest.dto.AuthorDto;
import com.example.authorbookrest.dto.CreateAuthorRequestDto;
import com.example.authorbookrest.dto.CreateAuthorResponseDto;
import com.example.authorbookrest.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    Author map(CreateAuthorRequestDto dto);

    CreateAuthorResponseDto map(Author entity);

    @Mapping(target = "fullName", source = "entity", qualifiedByName = "fullNameMapping")
    AuthorDto mapToDto(Author entity);

    @Named("fullNameMapping")
    default String getFullName(Author entity) {
        return entity.getName() + " " + entity.getSurname();
    }

}
