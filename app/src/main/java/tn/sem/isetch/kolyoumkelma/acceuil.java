package tn.sem.isetch.kolyoumkelma;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Med Melek on 29/05/2016.
 */
public class acceuil extends Fragment {
    ArrayList arrlist ;ListView ls ;DataBase db ;
    String pseudo ;
    public acceuil (String pseudo){
        this.pseudo=pseudo ;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.acceuil, container, false);

          db = new DataBase(getActivity());

        Button uplode = (Button) view.findViewById(R.id.uplode);
        final EditText publication = (EditText)view.findViewById(R.id.publication);

        ls = (ListView) view.findViewById(R.id.ls);
         arrlist =db.getAllrecord() ;
        ls.setAdapter(new ArrayAdapter<>(getActivity(), R.layout.statut, arrlist));

        uplode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(publication.getText()).length() > 0) {
                    db.InsertRowStaut(pseudo, String.valueOf(publication.getText()));
                    publication.setText("");
                    arrlist =db.getAllrecord() ;
                    ls.setAdapter(new ArrayAdapter<>(getActivity(), R.layout.statut, arrlist));
                }


            }
        });





        return view;
    }



}
