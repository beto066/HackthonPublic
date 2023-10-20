package br.unitins.dto;

import br.unitins.model.Notice;

public class NoticeResponseDTO {
    private String text;
    private String title;
    private String lero;

    public NoticeResponseDTO(Notice notice)/* NoticiaReponse Noticia -> Message */ {
        this.text = notice.text;
        this.title = notice.title;
        this.lero = "lerolero";
    }

    public String getLero() {
        return lero;
    }

    public void setLero(String lero) {
        this.lero = lero;
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
