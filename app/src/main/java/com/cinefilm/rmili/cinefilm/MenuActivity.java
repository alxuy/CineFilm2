package com.cinefilm.rmili.cinefilm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;
import android.content.Intent;


import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView buttonBibliotheque;
    ImageView buttonAlaffiche;
    ImageView buttonQueregarder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_menu);

            //--------------------Connexion à la base de donnée -----------------------------       // Ce code est utilisé pour visualiser la table user_db dans sur la console.

          /*  UserManagerDb userManagerDb = new UserManagerDb(this);

            userManagerDb.open();
            int userSupp;

            ArrayList<User> userList = new ArrayList<User>();

           for(int cpt = 0; cpt<=20; cpt++)
            {
                userList.add(userManagerDb.getUser(cpt));
                System.out.println(userList.get(cpt).getImdbID() + " " + userList.get(cpt).getId());
            }
      userManagerDb.close();*/
//================================================================================================

            ImageView buttonBibliotheque = (ImageView)findViewById(R.id.mabibliothequeButton);
            ImageView buttonAlaffiche  = (ImageView)findViewById(R.id.filmsalafficheButton);
            ImageView buttonQueregarder = (ImageView)findViewById(R.id.quevaisjeregarderButton);


            buttonBibliotheque.setOnClickListener(this);
            buttonAlaffiche.setOnClickListener(this);
            buttonQueregarder.setOnClickListener(this);



    }

    public void onClick(View view)   // Le menu presente 3 activités principales
    {
        Intent intent;

        switch (view.getId()){
            case R.id.mabibliothequeButton :
                intent = new Intent(this,MaBibliothequeActivity.class);   // Ma bibliotheque, ou son listé tout les film ajouté a notre wishlist
                startActivity(intent);
                break;
            case R.id.filmsalafficheButton :
                intent = new Intent(this,AfficheActivity.class); // Les films à l'affiche permet une recherche de film via le service TMDB
                startActivity(intent);
                break;
            case R.id.quevaisjeregarderButton :
                intent = new Intent(this,QueVaisJeRegarderActivity.class); // Que vais je regarder ? génére aleatoirement  un film parmis sa wishlist
                startActivity(intent);
                break;

        }
    }
}
