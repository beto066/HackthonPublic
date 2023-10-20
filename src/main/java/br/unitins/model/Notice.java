package br.unitins.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Notice extends DefaultEntity {
    public String text;
    public String title;
    @OneToMany(
        mappedBy = "notice",
        cascade = CascadeType.ALL
        //orphanRemoval = true
    )
    public List<Dicionary> dicionaries;

    
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
    public List<Dicionary> getDicionaries() {
        return dicionaries;
    }
    public void setDicionaries(List<Dicionary> dicionaries) {
        this.dicionaries = dicionaries;
    }
}
