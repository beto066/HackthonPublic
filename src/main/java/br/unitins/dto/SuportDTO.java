package br.unitins.dto;

package br.unitins.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity 

public class SuportDTO extends DefaultEntity{
    // public User usuario;
    @ManyToOne
    @JoinColumn(name = "id_notice")
    private MessageDTO message;
}
