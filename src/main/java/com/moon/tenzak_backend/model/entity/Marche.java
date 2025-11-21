package com.moon.tenzak_backend.model.entity;

import com.moon.tenzak_backend.model.enumeration.TypeMarche;
import com.moon.tenzak_backend.model.enumeration.TypePublication;
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
public class Marche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String description;
    private String autoriteContractante;

    @Enumerated(EnumType.STRING)
    private TypePublication typePublication;

    private LocalDate datePublication;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    private TypeMarche typeMarche;

    private String modeSelection;
    private Double montant;
    private String referencePPM;

    @Enumerated(EnumType.STRING)
    private ValidationStatus status;

    @ManyToOne
    private Entreprise entreprise;
}
