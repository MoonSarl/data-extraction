package com.moon.tenzak_backend.model.dto.authDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {
    @NotBlank(message = "Le nom  est obligatoire")
    private String nom;
    @NotBlank(message = "Le prénom  est obligatoire")
    private String prenom;

    @NotBlank(message = "Le numéro de téléphone  est obligatoire")
    @Size(min = 8, message = "Le numéro de téléphone 8 characters")
    private String telephone;

@NotBlank(message = "L'email  est obligatoire")
    @Email(message = "Email doit être valide")
    private String email;

    @NotBlank(message = "Le mot de passe  est obligatoire")
    @Size(min = 6, message = "Le mot de passe doit avoir au moins  6 characters")
    private String password;

    /*@NotBlank(message = "Le role est obligatoire")
    private String role;*/
}
