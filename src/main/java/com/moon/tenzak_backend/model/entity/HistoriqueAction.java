package com.moon.tenzak_backend.model.entity;

import com.moon.tenzak_backend.model.enumeration.ActionType;
import com.moon.tenzak_backend.model.enumeration.EntiteAction;
import com.moon.tenzak_backend.model.enumeration.ValidationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import io.hypersistence.utils.hibernate.type.json.JsonType;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistoriqueAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private EntiteAction entite;

    private Long entiteId;

    @Enumerated(EnumType.STRING)
    private ActionType action;

    @Type(JsonType.class)
    @Column(columnDefinition = "json")
    private Map<String, Object> champsModifies;

    @Type(JsonType.class)
    @Column(columnDefinition = "json")
    private Map<String, Object> anciennesValeurs;

    @Type(JsonType.class)
    @Column(columnDefinition = "json")
    private Map<String, Object> nouvellesValeurs;


    private String commentaires;

    @Enumerated(EnumType.STRING)
    private ValidationStatus statut;

    @ManyToOne
    private User auteur;
}

