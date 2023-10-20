package br.unitins.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DicionaryRepository extends DefaultEntity {  
    public String name;

   

    @ManyToOne
    @JoinColumn(name = "id_notice")
    public Notice notice;

    public DicionaryRepository(String nome){
        this.name = nome;
    }
     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
