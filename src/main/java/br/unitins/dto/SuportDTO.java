package br.unitins.dto;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.unitins.model.Message;
import br.unitins.model.Suport;

public class SuportDTO {
    private String name;
    private String email;
    private String senha;

    public void toSuport(Suport suport){
        suport.name = this.name;
        suport.email  = this.email;
        suport.senha = this.senha;
        suport.messages = new ArrayList<Message>();
    }

    public static boolean isValid(SuportDTO dto){
        return (dto.name != null && dto.name.length() > 2 &&
            (dto.email == null || isEmailValid(dto.email)));
    }
    
    private static boolean isEmailValid(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
