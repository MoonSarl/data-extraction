package com.moon.tenzak_backend.model.dto;

import com.moon.tenzak_backend.model.enumeration.DocumentType;
import com.moon.tenzak_backend.model.enumeration.ValidationStatus;

public record DocumentDto(
        Long id,
        String titre,
        DocumentType type,
        ValidationStatus status,
        Long marcheId,
        Long entrepriseId
) {}

