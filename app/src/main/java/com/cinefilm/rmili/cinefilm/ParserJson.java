package com.cinefilm.rmili.cinefilm;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

/**
 * Created by Mw on 27/04/2017.
 */

public class ParserJson {

   /* public String Parser(String jsonData) {
        String titre = null;


        try {
            JSONObject reader = new JSONObject(jsonData);
            JSONArray results = new JSONArray("results");



            for(int cpt = 0; cpt < results.length(); cpt++)
            {
                JSONObject movie = results.getJSONObject(cpt);
                titre = movie.getString("poster_path");


            }
            System.out.println(titre);


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return titre;

    }*/

    public TmdbResult parseResult(String jsonData) {
        GsonBuilder gsonb = new GsonBuilder();
        Gson gson = gsonb.create();

        JSONObject j;
        TmdbResult tmdbResult = null;

        try
        {
            j = new JSONObject(jsonData);
            tmdbResult = gson.fromJson(j.toString(), TmdbResult.class);

        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return tmdbResult;
    }
}
