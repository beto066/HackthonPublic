package br.unitins.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Usuario extends DefaultEntity {
    public String nome; 
    public String email;
    public String cpf;
    public String rani;
    public String senha;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "message_id")
    public Message message;
}