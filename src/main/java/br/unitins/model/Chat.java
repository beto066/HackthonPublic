package br.unitins.model;
import java.util.List;
import jakarta.persistence.Entity;

@Entity
public class Chat {
    public User usuario;
    public Suport suporte;
    public boolean fromUser;
    public List<Message> mensagensUsuario;
    public List<Message> mensagenSuporte;
}
