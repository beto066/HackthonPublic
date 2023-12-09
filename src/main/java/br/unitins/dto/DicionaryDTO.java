package br.unitins.dto;

import br.unitins.model.Dicionary;
import br.unitins.model.Notice;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


public class DicionaryDTO{  
    private String name;
    private Long noticeId;

    public static boolean isValid(DicionaryDTO dto){
        return (dto.name != null && dto.name.length() > 2);
    }

    public Long getNoticeId() {
        return noticeId;
    }
    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }
    public void toDicionary(Dicionary dicionary,Notice notice){
        dicionary.name = this.name;
        dicionary.notice = notice;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
