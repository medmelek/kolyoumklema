package tn.sem.isetch.kolyoumkelma;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Med Melek on 28/05/2016.
 */
public class FragInscri extends Fragment {
    String name1="" ;
    String pseudo1="" ;
    String password1=""  ;

    EditText name ;
    EditText pseudo ;
    EditText password ;


    public FragInscri (){

    }
    public FragInscri(String name1 , String pseudo1 , String password1){
        this.name1=name1 ;
        this.pseudo1=pseudo1 ;
        this.password1=password1 ;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fraginsri, container, false);

        Button next = (Button) view.findViewById(R.id.next) ;
          name= (EditText) view.findViewById(R.id.name);
          pseudo = (EditText) view.findViewById(R.id.pseudo);
          password = (EditText) view.findViewById(R.id.password) ;

      final   DataBase db = new DataBase(getActivity());

        if (name1.length()>0){
            name.setText(this.name1);
            pseudo.setText(this.pseudo1);
            password.setText(this.password1);
        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
              if ((String.valueOf(name.getText()).length()>0)&&(String.valueOf(pseudo.getText()).length()>0)&&(String.valueOf(password.getText()).length()>0)){

                if (db.checkcount(String.valueOf(pseudo.getText()))==1){

                    FragmentManager fragment=getFragmentManager() ;
                    fragment.beginTransaction().replace(R.id.content, new FragAvatar(String.valueOf(name.getText()), String.valueOf(pseudo.getText()), String.valueOf(password.getText()))).commit();

                }else{

                    Toast.makeText(getActivity(),"Changer Votre Pseudo :/ ",Toast.LENGTH_LONG).show();
                }
              }else{
                    Toast.makeText(getActivity(),"Verifier votre formaulaire ",Toast.LENGTH_LONG).show();
              }



            }
        });





        return view;
    }
}
