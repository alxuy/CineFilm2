package com.cinefilm.rmili.cinefilm;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mw on 26/04/2017.
 */

public class TmdbResult implements Serializable {

    public int page;
    public List<TmdbMovie> results;
    public int total_results;
    public int total_pages;
}
