package br.unitins.model;

//import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Message extends DefaultEntity {
    public String text;
    public String title;
    
    @ManyToOne
    @JoinColumn(name = "id_suport")
    public Suport suport;
}
