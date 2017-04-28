package com.cinefilm.rmili.cinefilm;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mw on 26/04/2017.
 */

public class TmdbMovie implements Serializable {
   /* {
        "poster_path": "/IfB9hy4JH1eH6HEfIgIGORXi5h.jpg",
            "adult": false,
            "overview": "Jack Reacher must uncover the truth behind a major government conspiracy in order to clear his name. On the run as a fugitive from the law, Reacher uncovers a potential secret from his past that could change his life forever.",
            "release_date": "2016-10-19",
            "genre_ids": [
        53,
                28,
                80,
                18,
                9648
        ],
        "id": 343611,
            "original_title": "Jack Reacher: Never Go Back",
            "original_language": "en",
            "title": "Jack Reacher: Never Go Back",
            "backdrop_path": "/4ynQYtSEuU5hyipcGkfD6ncwtwz.jpg",
            "popularity": 26.818468,
            "vote_count": 201,
            "video": false,
            "vote_average": 4.19
    }*/

    public String poster_path;
    public String adult;
    public String overview;
    public String release_date;
    public List genre_ids;
    public int id;
    public String original_title;
    public String original_language;
    public String title;
    public String backdrop_path;
    public String popularity;
    public String vote_count;
    public String video;
    public String vote_average;

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public List getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List genre_ids) {
        this.genre_ids = genre_ids;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getVote_count() {
        return vote_count;
    }

    public void setVote_count(String vote_count) {
        this.vote_count = vote_count;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }
}
