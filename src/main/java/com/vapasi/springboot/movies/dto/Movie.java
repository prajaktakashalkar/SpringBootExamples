package com.vapasi.springboot.movies.dto;

public class Movie {
    String Name;
    String Actor;
    String Director;

    public Movie(String name, String actor, String director) {
        Name = name;
        Actor = actor;
        Director = director;
    }

    public String getName() {
        return Name;
    }

    public String getActor() {
        return Actor;
    }

    public String getDirector() {
        return Director;
    }
}
