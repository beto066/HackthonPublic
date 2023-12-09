package br.unitins.dto;

//import java.util.ArrayList;
import java.util.List;

import br.unitins.model.Message;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

public class MessageResponseDTO{
    public Long id;
    public String text;
    public String topic;
    public SuportResumeDTO suport;
    public Long userId;
    
    public MessageResponseDTO(Message message) {
        System.out.println(message.id);
        this.text = message.text;
        this.topic = message.topic;
        this.id = message.id;
        if (message.usuario != null) {
            this.userId = message.usuario.id;
        }
        if (message.suport != null) {
            this.suport = new SuportResumeDTO(message.suport);
        }
    }
}
