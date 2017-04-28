package com.cinefilm.rmili.cinefilm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;



public class MaBibliothequeActivity extends AppCompatActivity {

    ListView listView;
    TextView MywishList;
    ArrayList<String> wishList = new ArrayList<String>();
    int cpt = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_bibliotheque);

        UserManagerDb userManagerDb = new UserManagerDb(this);
        userManagerDb.open();

        do
        {
            wishList.add(userManagerDb.getUser(cpt).getImdbID()); //On viens recuperer chaque titre de films dans une arraylist
            cpt++;

        }while (userManagerDb.getUser(cpt).getId() != 0);



        listView = (ListView) findViewById(R.id.listView);
        MywishList = (TextView)findViewById(R.id.MywishList);

        if (userManagerDb.getUser(1).getId() == 1) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,  // on creer la listView avec wishList
                    android.R.layout.simple_list_item_1, wishList);
            listView.setAdapter(adapter);
            MywishList.setText("My Wishlist");
        }
        else
        {
            MywishList.setText("My Wishlist is empty");
        }

    }






}


