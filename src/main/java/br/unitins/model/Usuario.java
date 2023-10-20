package br.unitins.model;

import jakarta.persistence.Entity;

@Entity
public class Usuario extends DefaultEntity {
  
    public String nome; 
    public String email;
    public String senha;
    
    // @OneToOne(cascade=CascadeType.ALL)
    // @JoinColumn(name = "id_telefone")
    // public Telefone teLefone;
}