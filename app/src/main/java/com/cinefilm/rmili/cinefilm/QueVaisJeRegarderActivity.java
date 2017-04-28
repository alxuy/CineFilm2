package com.cinefilm.rmili.cinefilm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class QueVaisJeRegarderActivity extends AppCompatActivity implements View.OnClickListener {

    Button discover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_que_vais_je_regarder);

        discover = (Button)findViewById(R.id.buttonDiscover);

        discover.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        UserManagerDb userManagerDb = new UserManagerDb(this);
        userManagerDb.open();
        int random;
        int cpt = 1;

        do
        {
            cpt++;                                          // on recupere le nombre de film dans la bdd
        }while (userManagerDb.getUser(cpt).getId() != 0);

        cpt--;

        if (userManagerDb.getUser(1).getId() == 1) {
            random = (int) (Math.random() * (cpt - 1 + 1)) + 1;  // on génére aleatoirement un nombre < nb de films dans la bdd

            Intent intent = new Intent(this, FilmActivity.class);
            intent.putExtra("title", userManagerDb.getUser(random).getImdbID());  // on envoie le titre correspondant au nombre à l'activité Film
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Your wishlist is empty", Toast.LENGTH_LONG).show();
        }

        userManagerDb.close();
    }
}
