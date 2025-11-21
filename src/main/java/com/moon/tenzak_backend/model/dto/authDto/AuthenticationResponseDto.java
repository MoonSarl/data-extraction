package com.moon.tenzak_backend.model.dto.authDto;


import com.moon.tenzak_backend.model.enumeration.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponseDto {
    private Long id;
    private String email;
    private String nom;
    private String prenom;
    private String telephone;
    private UserRole role;
    private String token;
}
