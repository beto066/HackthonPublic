package br.unitins.dto;

import br.unitins.model.Notice;

public class NoticeResponseDTO {
    private String text;
    private String title;

    public NoticeResponseDTO(Notice notice) {
        this.text = notice.text;
        this.title = notice.title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
