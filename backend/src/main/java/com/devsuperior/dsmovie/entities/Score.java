package com.devsuperior.dsmovie.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_score")
public class Score {
    
    /*ScorePK é uma chave primaria composta*/
    @EmbeddedId 
    private ScorePK id;
    private Double value;

    public Score() {
        this.id = new ScorePK();
    }

    public void setMovie(Movie movie) {
        id.setMovie(movie);
    }

    public void setUser(User user) {
        id.setUser(user);
    }

    public ScorePK getScorePK() {
        return id;
    }

    public void setScorePK(ScorePK id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
    
}
    