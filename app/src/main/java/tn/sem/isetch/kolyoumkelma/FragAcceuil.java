package tn.sem.isetch.kolyoumkelma;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Med Melek on 28/05/2016.
 */
public class FragAcceuil extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragacceuil, container, false);

        Button connexion = (Button)view.findViewById(R.id.cnx);
        Button inscri = (Button)view.findViewById(R.id.inscri);

        inscri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragment=getFragmentManager() ;
                fragment.beginTransaction().replace(R.id.content, new FragInscri()).commit();
            }
        });

        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragment=getFragmentManager() ;
                fragment.beginTransaction().replace(R.id.content, new FragConnexion()).commit();
            }
        });



        return view;
    }
}
