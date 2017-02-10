package tn.sem.isetch.kolyoumkelma;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Med Melek on 28/05/2016.
 */
public class DataBase extends SQLiteOpenHelper {

    public DataBase(Context context) {
        super(context,"KolYoumKelma.db",null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table IF NOT EXISTS joueur (nom varchar(20) , pseudo varchar(20), password varchar(20) ,picture integer , primary key(pseudo))");
        db.execSQL("create table IF NOT EXISTS statut (pseudo varchar(20) , publication varchar(80) )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if (oldVersion != newVersion) {
            db.execSQL("Drop table IF EXISTS  joueur ");
            db.execSQL("Drop table IF EXISTS  statut ");
            onCreate(db);
        }
    }

    public void InsertRowJouer(String nom, String pseudo,String password, int picture) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("nom",nom);
        contentValues.put("pseudo",pseudo);
        contentValues.put("password", password);
        contentValues.put("picture", picture);
        db.insert("joueur", null, contentValues);
    }

    public void InsertRowStaut(String pseudo,String publication) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("pseudo",pseudo);
        contentValues.put("publication", publication);
        db.insert("statut", null, contentValues);
    }

    public int checkcount(String pseudo) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from joueur", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            String chaine1 = res.getString(res.getColumnIndex("pseudo"));

            if (chaine1.equals(pseudo)) {
                return 0;
            }

            res.moveToNext();
        }


        return 1;

    }

    public int checkcountALL(String pseudo , String password) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = db.rawQuery("select * from joueur", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            String chaine1 = res.getString(res.getColumnIndex("pseudo"));
            String chaine2 = res.getString(res.getColumnIndex("password")) ;
            if ((chaine1.equals(pseudo))&& (chaine2.equals(password))) {
                return 1;
            }

            res.moveToNext();
        }


        return 0;

    }

    public int getPicture(String pseudo) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from joueur", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {

            if (res.getString(res.getColumnIndex("pseudo")).equals(pseudo)) {
                return  res.getInt(res.getColumnIndex("picture"));
            }

            res.moveToNext();
        }

        return 0 ;
    }
    public String getUsername(String pseudo) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from joueur", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {

            if (res.getString(res.getColumnIndex("pseudo")).equals(pseudo)) {
                return  res.getString(res.getColumnIndex("nom"));
            }

            res.moveToNext();
        }

        return "erreur" ;
    }
    public void suprimer ( String pseudo) {

        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("delete  from joueur where pseudo='"+pseudo+"'");


    }
    public ArrayList getAllrecord() {
        ArrayList array_list = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from statut", null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            array_list.add (res.getString(res.getColumnIndex("pseudo"))+"\n "+" "+res.getString(res.getColumnIndex("publication")));
            res.moveToNext();
        }
        return array_list;

    }


    public String getBestPerso() {
        String pseudo ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select pseudo,MAX(publication) from statut GROUP BY pseudo", null);
        res.moveToFirst();
       return res.getString(res.getColumnIndex("pseudo"));

    }
    public void modifier (String pseudo ,String nom, int src ) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update joueur set nom='"+nom+"',picture="+src+" where pseudo='"+pseudo+"'");

    }

}
