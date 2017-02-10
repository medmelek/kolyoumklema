package tn.sem.isetch.kolyoumkelma;

import android.app.Fragment;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Med Melek on 29/05/2016.
 */
public class score extends Fragment {
    String pseudo ;
    public score(String pseudo){

        this.pseudo=pseudo  ;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.score, container, false);

        Button avatar= (Button) view.findViewById(R.id.avatar);
        TextView nom1 = (TextView) view.findViewById(R.id.nom);


       final DataBase db = new DataBase(getActivity());

        String bestpseudo=db.getBestPerso();

        avatar.setBackgroundResource(R.drawable.a);



        nom1.setText(db.getUsername(bestpseudo));


        return view;
    }

}
