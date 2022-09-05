package com.huma.exerciseapp.model;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class MovieSerial implements Serializable {

    private String title;
    private String cardImageUrl;
    private String studio;

    public MovieSerial() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getCardImageUrl() {
        return cardImageUrl;
    }

    public void setCardImageUrl(String cardImageUrl) {
        this.cardImageUrl = cardImageUrl;
    }

    @NotNull
    @Override
    public String toString() {

        return "Movie{" +
                ", title='" + title + '\'' +
                ", cardImageUrl='" + cardImageUrl + '\'' +
                '}';
    }
}