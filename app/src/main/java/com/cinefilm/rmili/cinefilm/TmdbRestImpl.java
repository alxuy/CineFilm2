package com.cinefilm.rmili.cinefilm;


import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Mw on 26/04/2017.
 */

public class TmdbRestImpl extends AsyncTask<String,Void,String> {

    // la fonction doInBackground nous permet d'effectuer la requette http restful à Tmdb
    // Celui-ci nous renvoi ensuite un String sous format json que l'on stockeras par deserialisation dans un objet TmdbResult
    // TmdbResult comprend une list de TmdbMovie, tout les films recupéré par la requette.
        @Override
        protected String doInBackground(String... title)
        {
           String url = "https://api.themoviedb.org/3/search/movie?api_key=b02298847d81302b947f7f95164fe69b&query="+ title[0];
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(url).build();
            Call call = client.newCall(request);

            Response response = null;
            String jsonData = null;

            try {
                response = call.execute();

                if (response.isSuccessful()) {
                    jsonData = response.body().string();

                } else {
                    jsonData = null;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return jsonData;
        }


    @Override
    protected void onPostExecute(String jsonData) {
        super.onPostExecute(jsonData);


    }
}
