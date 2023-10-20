package br.unitins.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.List;

import br.unitins.model.DefaultEntity;

@Entity 
public class SuportDTO extends DefaultEntity {
    // public User usuario;
    @ManyToOne
    @JoinColumn(name = "id_notice")
    private MessageDTO message;
}
