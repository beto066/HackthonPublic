package br.unitins.dto;

import br.unitins.model.Notice;

public class NoticeDTO {
    private String text;
    private String title;

    public void toNotice(Notice notice){
        notice.text = this.text;
        notice.title = this.title;
    }

    public static boolean isValid(NoticeDTO dto){
        return (dto.text != null && dto.text.length() > 2 &&
            (dto.title == null || dto.title.length() <= 255));
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
