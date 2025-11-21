package com.moon.tenzak_backend.model.entity;

import com.moon.tenzak_backend.model.enumeration.UserRole;
import com.moon.tenzak_backend.model.enumeration.ValidationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Entreprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomLegal;
    private String formeJuridique;
    private String registreCommerce;
    private LocalDate dateCreation;
    private String paysEnregistrement;
    private String adresse;
    private String telephone;
    private String email;
    private String siteWeb;
    private String secteurActivite;
    @Enumerated(EnumType.STRING)
    private ValidationStatus status;
    @ManyToOne
    private User personneContact;
}