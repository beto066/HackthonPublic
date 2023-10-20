package br.unitins.dto;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.List;

import br.unitins.model.Suport;

public class SuportDTO {
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String email;
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void toSuport(Suport suport){
        suport.name = this.name;
        suport.email  = this.email;
        suport.senha = this.senha;
    }
    //tosuport
}
