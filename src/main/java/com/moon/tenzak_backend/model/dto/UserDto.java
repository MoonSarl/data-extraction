package com.moon.tenzak_backend.model.dto;

import com.moon.tenzak_backend.model.enumeration.UserRole;

public record UserDto(
        Long id, String nom, String prenom, String email, String telephone, UserRole role) {}

