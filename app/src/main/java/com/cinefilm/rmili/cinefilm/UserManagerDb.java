package com.cinefilm.rmili.cinefilm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

/**
 * Created by Mw on 25/04/2017.
 */

public class UserManagerDb {

    private static final String TABLE_NAME = "user_db";
    public static final String KEY_ID_USER = "id_user";
    public static final String KEY_NAME_USER = "name_user"; //imdbID
    public static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
            " (" + " "+KEY_ID_USER+" INTEGER primary key," + " "+KEY_NAME_USER+" TEXT" + ");";

    private MySQLite maBaseSQLite; // notre gestionnaire du fichier SQLite
    private SQLiteDatabase db;

    // Constructeur
    public UserManagerDb(Context context)
    {
        maBaseSQLite = MySQLite.getInstance(context);
    }

    public void open()
    {
        //on ouvre la table en lecture/écriture

        db = maBaseSQLite.getWritableDatabase();

    }

    public void close()
    {
        //on ferme l'accès à la BDD
        db.close();
    }

    public long addUser(User user) {
        // Ajout d'un enregistrement dans la table

        ContentValues values = new ContentValues();
        values.put(KEY_NAME_USER, user.getImdbID());

        // insert() retourne l'id du nouvel enregistrement inséré, ou -1 en cas d'erreur
        return db.insert(TABLE_NAME,null,values);
    }

    public int modUser(User user) {
        // modification d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la requête

        ContentValues values = new ContentValues();
        values.put(KEY_NAME_USER, user.getImdbID());

        String where = KEY_ID_USER+" = ?";
        String[] whereArgs = {user.getId()+""};

        return db.update(TABLE_NAME, values, where, whereArgs);
    }

    public int supUser(User user) {
        // suppression d'un enregistrement
        // valeur de retour : (int) nombre de lignes affectées par la clause WHERE, 0 sinon

        String where = KEY_ID_USER+" = ?";
        String[] whereArgs = {user.getId()+""};

        return db.delete(TABLE_NAME, where, whereArgs);
    }


    public User getUser(int id) {
        // Retourne l'utilisateur dont l'id est passé en paramètre

        User a=new User();

        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+KEY_ID_USER+"="+id, null);
        if (c.moveToFirst()) {
            a.setId(c.getInt(c.getColumnIndex(KEY_ID_USER)));
            a.setImdbID(c.getString(c.getColumnIndex(KEY_NAME_USER)));
            c.close();
        }

        return a;
    }

    public Cursor getUsers() {
        // sélection de tous les enregistrements de la table
        return db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
    }



}
