package br.unitins.dto;
//import java.util.ArrayList;
import java.util.List;

import br.unitins.model.Suport;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class MessageDTO {
    public String text;
    public String topic;
    public List<Suport> suport;
/*
 * String topic
 * 
 */
}