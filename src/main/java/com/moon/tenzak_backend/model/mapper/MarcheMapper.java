package com.moon.tenzak_backend.model.mapper;



import com.moon.tenzak_backend.model.dto.MarcheDto;
import com.moon.tenzak_backend.model.entity.Marche;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MarcheMapper {
    // @Mapping(source = "entreprise.id", target = "entrepriseId")
    MarcheDto toDto(Marche entity);

    // @Mapping(source = "entrepriseId", target = "entreprise.id")
    Marche toEntity(MarcheDto dto);
}



