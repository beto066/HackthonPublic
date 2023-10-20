package br.unitins.dto;
//import java.util.ArrayList;
import java.util.List;

import br.unitins.model.Suport;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class MessageDTO extends DefaultEntity {
    public String text;
    public String topic;
    @OneToMany(
        mappedBy = "message",
        cascade = CascadeType.ALL
        //orphanRemoval = true
    )
    public List<Suportt> suport;
/*
 * String topic
 * 
 */
}