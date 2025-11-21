package com.moon.tenzak_backend.model.dto;

import com.moon.tenzak_backend.model.enumeration.ActionType;
import com.moon.tenzak_backend.model.enumeration.ValidationStatus;

import java.time.LocalDateTime;
import java.util.Map;

public record HistoriqueActionDto(
        Long id,
        LocalDateTime date,
        String entite,
        ActionType action,
        Map<String, Object> champsModifies,
        Map<String, Object> anciennesValeurs,
        Map<String, Object> nouvellesValeurs,
        String commentaires,
        ValidationStatus statut,
        Long auteurId
) {}
