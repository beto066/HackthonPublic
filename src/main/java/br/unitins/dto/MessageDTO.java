package br.unitins.dto;

import br.unitins.model.Message;
import br.unitins.model.Suport;

public class MessageDTO{
    private String text;
    private String topic;

    public void toMessage(Message message) {
        message.text = this.text;
        message.topic = this.topic;
    }

    public static boolean isValid(MessageDTO dto){
        return (
            dto.text != null && dto.text.length() > 2 &&
            (dto.topic.equalsIgnoreCase("Denuncia") ||
            dto.topic.equalsIgnoreCase("Reclamação") ||
            dto.topic.equalsIgnoreCase("Elogio"))
        );
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}