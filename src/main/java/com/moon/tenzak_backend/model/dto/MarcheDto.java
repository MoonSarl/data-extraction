package com.moon.tenzak_backend.model.dto;

import com.moon.tenzak_backend.model.enumeration.TypeMarche;
import com.moon.tenzak_backend.model.enumeration.TypePublication;
import com.moon.tenzak_backend.model.enumeration.ValidationStatus;

public record MarcheDto(
        Long id,
        String titre,
        String autoriteContractante,
        TypePublication typePublication,
        TypeMarche typeMarche,
        ValidationStatus status,
        Long entrepriseId
) {}

