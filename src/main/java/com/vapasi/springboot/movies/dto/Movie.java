package com.vapasi.springboot.movies.dto;

import java.util.Objects;

public class Movie {
    int id;
    String name;
    String actor;
    String director;


    public Movie(int id,String name, String actor, String director) {
        this.name = name;
        this.actor = actor;
        this.director = director;
        this.id =id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public String getActor() {
        return actor;
    }

    public String getDirector() {
        return director;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && Objects.equals(name, movie.name) && Objects.equals(actor, movie.actor) && Objects.equals(director, movie.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, actor, director);
    }
}
