package br.unitins.dto;

//import java.util.ArrayList;
import java.util.List;

import br.unitins.model.Message;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

public class MessageResponseDTO{
    public String text;
    public String topic;
    
    public MessageResponseDTO(Message message) {
        this.text = message.text;
        this.topic = message.topic;
    }
}
