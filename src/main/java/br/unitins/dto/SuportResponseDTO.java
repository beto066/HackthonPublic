package br.unitins.dto;

import java.util.ArrayList;

import br.unitins.model.Message;
import br.unitins.model.Suport;

public class SuportResponseDTO {
    private String name;
    private String email;
    private String senha;
    private ArrayList<MessageResponseDTO> messages;

    public SuportResponseDTO(Suport suport) {
        this.name = suport.name;
        this.email = suport.email;
        this.senha = suport.senha;
        if (suport.messages != null) {
            suport.messages.forEach((Message value) -> {
                getMessage().add(new MessageResponseDTO(value));
            });
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
    public ArrayList<MessageResponseDTO> getMessage() {
        if (messages == null) {
            messages = new ArrayList<MessageResponseDTO>();
        }
        return messages;
    }
    public void setMessage(ArrayList<MessageResponseDTO> messages) {
        this.messages = messages;
    }
}
