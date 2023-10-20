package br.unitins.dto;

import br.unitins.model.Dicionary;
import br.unitins.model.Notice;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


public class DicionaryResponseDTO {  
    private String name;
    private NoticeResponseDTO notice;

    public DicionaryResponseDTO(Dicionary dicionary) {
        this.name = dicionary.name;
        this.notice = new NoticeResponseDTO(dicionary.notice);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public NoticeResponseDTO getNotice() {
        return notice;
    }
    public void setNotice(NoticeResponseDTO notice) {
        this.notice = notice;
    }
}
