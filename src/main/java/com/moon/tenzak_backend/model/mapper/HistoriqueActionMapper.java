package com.moon.tenzak_backend.model.mapper;


import com.moon.tenzak_backend.model.dto.HistoriqueActionDto;
import com.moon.tenzak_backend.model.entity.HistoriqueAction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HistoriqueActionMapper {
    // @Mapping(source = "auteur.id", target = "auteurId")
    HistoriqueActionDto toDto(HistoriqueAction entity);

    // @Mapping(source = "auteurId", target = "auteur.id")
    HistoriqueAction toEntity(HistoriqueActionDto dto);
}



