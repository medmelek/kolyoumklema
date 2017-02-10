package tn.sem.isetch.kolyoumkelma;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Med Melek on 29/05/2016.
 */
public class profil extends Fragment {
Button choix ;
    EditText nom ;
    String choixfinal="" ;

    String pseudo ;
    public profil(String pseudo){
        this.pseudo=pseudo ;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profil, container, false);


        Button a= (Button) view.findViewById(R.id.a);
        Button b= (Button) view.findViewById(R.id.b);
        Button c= (Button) view.findViewById(R.id.c);
        Button d= (Button) view.findViewById(R.id.d);

         choix= (Button) view.findViewById(R.id.choix);
        choix.setBackgroundResource(R.drawable.a);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choix.setBackgroundResource(R.drawable.a);
                choixfinal="a";
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choix.setBackgroundResource(R.drawable.b);
                choixfinal="b";
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choix.setBackgroundResource(R.drawable.c);
                choixfinal="c";
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choix.setBackgroundResource(R.drawable.d);
                choixfinal="d";
            }
        });

             nom = (EditText)view.findViewById(R.id.nom);


        final DataBase db = new DataBase(getActivity());
                nom.setText(db.getUsername(pseudo));
        Button modifier = (Button) view.findViewById(R.id.modifier)  ;

        modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (choixfinal) {
                    case "a":db.modifier(pseudo,String.valueOf(nom.getText()),R.drawable.a);
                        break ;
                    case "b":db.modifier(pseudo,String.valueOf(nom.getText()),R.drawable.b);
                        break ;
                    case "c":db.modifier(pseudo,String.valueOf(nom.getText()),R.drawable.c);
                        break ;
                    case "d":db.modifier(pseudo,String.valueOf(nom.getText()),R.drawable.d);
                        break ;
                }


                FragmentManager fragment=getFragmentManager() ;
                fragment.beginTransaction().replace(R.id.content2, new acceuil(pseudo)).commit();
            }
        });



        return view;
    }
}
