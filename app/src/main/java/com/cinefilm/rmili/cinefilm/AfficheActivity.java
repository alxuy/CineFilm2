package com.cinefilm.rmili.cinefilm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

//----------------------------------Activity des Films Au cine ----------------------------------------------------

public class AfficheActivity extends AppCompatActivity implements View.OnClickListener{

    Button rechercher;
    EditText titre;
    ImageView imageView;
    String title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche);

        rechercher = (Button)findViewById(R.id.rechercher);
        titre = (EditText)findViewById(R.id.titre);





            rechercher.setOnClickListener(this);



    }

    public void onClick(View view) {




        title = titre.getText().toString();  // on recupere la chaine de caractère inscrite par l'utilisateur
        title = title.replaceAll(" ", "+"); // on remplace les " " par des +, necessaire à la requette http
            Intent intent = new Intent(this, FilmActivity.class);
            intent.putExtra("title", title); // le titre du film qu'a inscrit l'utilisateur sont transmis à l'activité FilmActivity
            startActivity(intent);



    }
}
