package br.unitins.dto;

import br.unitins.model.Message;
import br.unitins.model.Suport;

public class MessageDTO{
    private String text;
    private String topic;
    private Long suportId;

    public void toMessage(Message message, Suport suport) {
        message.text = this.text;
        message.topic = this.topic;
        message.suport = suport;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getSuportId() {
        return suportId;
    }

    public void setSuportId(Long suportId) {
        this.suportId = suportId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}