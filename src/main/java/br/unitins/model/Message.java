package br.unitins.model;

//import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Message extends DefaultEntity {
    public String text;
    public String title;
    // @OneToMany(
    //     mappedBy = "message",
    //     cascade = CascadeType.ALL
    //     //orphanRemoval = true
    // )
    // public List<Suport> suports;
}
