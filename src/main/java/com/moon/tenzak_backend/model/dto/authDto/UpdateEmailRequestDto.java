package com.moon.tenzak_backend.model.dto.authDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateEmailRequestDto {
    @NotBlank(message = "L'email  est obligatoire")
    @Email(message = "Email doit être valide")
    private String oldEmail;

    @NotBlank(message = "L'email  est obligatoire")
    @Email(message = "Email doit être valide")
    private String newEmail;
}
