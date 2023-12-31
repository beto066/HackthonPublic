package br.unitins.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity 
public class Suport extends DefaultEntity{
    public String name;
    public String email;
    public String senha;

    @OneToMany(
        mappedBy = "suport",
        cascade = CascadeType.ALL
        //orphanRemoval = true
    )
    public List<Message> messages;
}
