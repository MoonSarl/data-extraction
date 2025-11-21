package com.moon.tenzak_backend.model.entity;

import com.moon.tenzak_backend.model.enumeration.DocumentType;
import com.moon.tenzak_backend.model.enumeration.ValidationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String fichier;

    @Enumerated(EnumType.STRING)
    private DocumentType type;

    @ManyToOne
    private Marche marche;

    @ManyToOne
    private Entreprise entreprise;

    @Enumerated(EnumType.STRING)
    private ValidationStatus status;
}

