package com.fabianpinzon;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String name;
    private List<Actor> actors;

    public Movie(String name) {
        this.name = name;
        actors = new ArrayList<>();
    }

    public void addActor(Actor actor){
        this.actors.add(actor);
    }

    public List<Actor> getActors(){
        return actors;
    }
}
