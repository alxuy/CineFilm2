package com.cinefilm.rmili.cinefilm;

import java.util.List;

/**
 * Created by Mw on 24/04/2017.
 */

public class User {  // classe type de la structure de notre table user_db, on utilise User pour extraire et traiter des donnée de la bdd

    private int id;
    private String imdbID;
    private List<String> watchedMovie;
    private List<String> wantWatchMovie;

    public User(){}

    public User(int id, String imdbID){this.id = id; this.imdbID=imdbID;}

    public String getImdbID() { return imdbID; }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getWatchedMovie() {
        return watchedMovie;
    }

    public void setWatchedMovie(List<String> watchedMovie) {
        this.watchedMovie = watchedMovie;
    }

    public List<String> getWantWatchMovie() { return wantWatchMovie; }

    public void setWantWatchMovie(List<String> wantWatchMovie) { this.wantWatchMovie = wantWatchMovie; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + imdbID + '\'' +
                '}';
    }
}
