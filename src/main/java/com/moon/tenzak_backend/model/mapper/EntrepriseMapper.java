package com.moon.tenzak_backend.model.mapper;


import com.moon.tenzak_backend.model.dto.EntrepriseDto;
import com.moon.tenzak_backend.model.entity.Entreprise;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntrepriseMapper {
    EntrepriseDto toDto(Entreprise entreprise);
    Entreprise toEntity(EntrepriseDto dto);
}



