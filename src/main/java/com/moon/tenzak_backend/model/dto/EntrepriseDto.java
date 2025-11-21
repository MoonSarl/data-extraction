package com.moon.tenzak_backend.model.dto;

public record EntrepriseDto(
        Long id,
        String nomLegal,
        String registreCommerce,
        String email,
        String paysEnregistrement
) {}
