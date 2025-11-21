package com.moon.tenzak_backend.model.mapper;



import com.moon.tenzak_backend.model.dto.DocumentDto;
import com.moon.tenzak_backend.model.entity.Document;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DocumentMapper {
    // @Mapping(source = "marche.id", target = "marcheId")
    // @Mapping(source = "entreprise.id", target = "entrepriseId")
    DocumentDto toDto(Document doc);

    // @Mapping(source = "marcheId", target = "marche.id")
    // @Mapping(source = "entrepriseId", target = "entreprise.id")
    Document toEntity(DocumentDto dto);
}



