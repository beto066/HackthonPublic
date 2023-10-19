package br.unitins.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Notice extends DefaultEntity {
    public String text;
    public String title;
    @OneToMany(
        mappedBy = "dicionary",
        cascade = CascadeType.ALL
        //orphanRemoval = true
    )
    public List<Dicionary> dicionary;
}
