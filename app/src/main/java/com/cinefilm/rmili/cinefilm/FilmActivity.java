package com.cinefilm.rmili.cinefilm;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import android.widget.TextView;
import android.widget.Toast;

public class FilmActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView poster;
    TextView titleView;
    TextView date;
    TextView noteDuFilm;
    TextView synopsis;
    String original_title = "       ";
    String realise_date = "   Realise : ";
    String note = "   Note : ";
    Button wishButton;
    Button DeleteButton;
    String titleInDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);

        String title = getIntent().getStringExtra("title");

        //==================HTTP REQUEST ==========================   // On fait appel aux web service TMDB qui nous fournit les données du film par le titre que l'utilisateur a entré dans l'activité AfficheActivty

        TmdbRestImpl tmdbRestImpl = new TmdbRestImpl();
        tmdbRestImpl.execute(title);

        String jsonTmdb = null;

        try {
            jsonTmdb = tmdbRestImpl.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //=================DESERIALIZE====================

        ParserJson parserJson = new ParserJson();
        TmdbResult re;
        re = parserJson.parseResult(jsonTmdb);

        if(re.total_results != 0) { // on verifie que le resultat de la requette n'est pas vide.

            poster = (ImageView) findViewById(R.id.poster);


            String posterRequest = "https://image.tmdb.org/t/p/w500" + re.results.get(0).getPoster_path();

            Picasso.with(getBaseContext()).load(posterRequest).into(poster); // on charge ensuite l'image correspondante au film, fourni dans le json

            titleView = (TextView)findViewById(R.id.title);
            date = (TextView)findViewById(R.id.realise_date);
            noteDuFilm = (TextView)findViewById(R.id.noteOftheMovie);
            synopsis = (TextView)findViewById(R.id.synopsisOftheMovie);
            wishButton = (Button)findViewById(R.id.wishListButton);
            DeleteButton = (Button)findViewById(R.id.deleteWishList);

            original_title = original_title + re.results.get(0).getOriginal_title();
            realise_date = realise_date + re.results.get(0).getRelease_date();
            note = note + re.results.get(0).getVote_average() + "/10";


            date.setText(realise_date);
            noteDuFilm.setText(note);
            synopsis.setText(re.results.get(0).getOverview());
            titleView.setText(original_title);
            titleInDb = re.results.get(0).getOriginal_title();

            wishButton.setOnClickListener(this);
            DeleteButton.setOnClickListener(this);

//



   //


        }
        else
        {
            Toast.makeText(this, "Movie not Found", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onClick(View view) {

        UserManagerDb userManagerDb = new UserManagerDb(this);   // on ouvre la database pour pouvoir la manipuler par la suite
        userManagerDb.open();
        ArrayList<User> userList = new ArrayList<User>();
        int listCpt;
        User user = new User(0, titleInDb);
        int userSupp;
        int i = 0;
        int cpt = 1;

        Boolean exists = false;

        if (userManagerDb.getUser(1).getId() == 1) {  // On verifie que la table n'est pas vide
            do{

                if (userManagerDb.getUser(cpt).getImdbID().equals(titleInDb)) { //on verifie que le film n'est pas deja present dans la table
                    exists = true;
                    user.setId(cpt);
                    i = cpt;
                }
                cpt++;
            }while(userManagerDb.getUser(cpt).getId() != 0);
        }

        switch (view.getId()) {
            case R.id.wishListButton:     //  Cas ou l'utilisateur veut ajouter le film dans sa wishlist

                if (exists == true)
                {
                    Toast.makeText(this, "Movie already in your wishlist", Toast.LENGTH_LONG).show();
                }
                else
                {
                    userManagerDb.addUser(user);
                    Toast.makeText(this, "Movie added to your wishlist", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.deleteWishList:  // Cas ou l'utilisateur veut supprimer le film de sa wishlist

                if (exists == true)
                {
                    userSupp = userManagerDb.supUser(user); // on supprime le film
                    if (userSupp == 1)
                    {
                        Toast.makeText(this, "Movie removed from your wishlist", Toast.LENGTH_LONG).show();
                    }

                    i++;
    listCpt = 0;
                    while(userManagerDb.getUser(i).getId() != 0){   // on viens ensuite dans ces deux boucles while stockez les films de la bdd dans une list et les supprimer un à un de la bdd

                                userList.add(userManagerDb.getUser(i));
                              userSupp = userManagerDb.supUser(userList.get(listCpt));
                        listCpt++;

                        i++;
                    }

                    i = 1;

                    while(userManagerDb.getUser(i).getId() != 0){

                        userList.add(userManagerDb.getUser(i));
                        userSupp = userManagerDb.supUser(userList.get(listCpt));
                        listCpt++;
                        i++;
                    }



                   for (i = 0; i < userList.size(); i++ )  // on les reinjectes ensuite dans la bdd, ceci pour suprimer les cases null presentes entre deux films dans la bdd.
                    {
                       userManagerDb.addUser(userList.get(i));
                    }




                }
                else
                {
                    Toast.makeText(this, "Movie doesn't exists in your wishlist", Toast.LENGTH_LONG).show();
                }

                break;

        }
    userManagerDb.close();
    }
}
