package tn.sem.isetch.kolyoumkelma;

import android.app.Fragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Med Melek on 29/05/2016.
 */

public class FragConnexion extends Fragment {
    EditText pseudo ;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragconnexion, container, false);

              pseudo = (EditText) view.findViewById(R.id.pseudo);
        final EditText password = (EditText) view.findViewById(R.id.password);

        Button valider =(Button)view.findViewById(R.id.valider) ;
        final DataBase db = new DataBase(getActivity());

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if( (String.valueOf(pseudo.getText()).length()>0)&&(String.valueOf(password.getText()).length()>0)){

                    if ( db.checkcountALL(String.valueOf(pseudo.getText()), String.valueOf(password.getText()))==1){
                        Intent intent = new Intent () ;
                        PendingIntent pIntent = PendingIntent.getActivity(getActivity(), 0, intent, 0);
                        Notification noti = new Notification.Builder(getActivity())
                                .setTicker("KolYoumKelma Vous Souhaite la Bienvenue ")
                                .setContentTitle("<"+String.valueOf(pseudo.getText())+">")
                                .setContentText("Mar7bé Bik m3anna")
                                .setSmallIcon(R.drawable.logokolyoumkelmatoolbar)
                                .setContentIntent(pIntent)
                                .getNotification();
                        noti.flags= Notification.FLAG_AUTO_CANCEL ;
                        NotificationManager nm = (NotificationManager) getActivity().getSystemService(getActivity().NOTIFICATION_SERVICE);

                        nm.notify(0, noti);

                        Intent versMain2 = new Intent(getActivity(),MainActivity2.class);
                        versMain2.putExtra("pseudo",String.valueOf(pseudo.getText()));
                        startActivity(versMain2);

                    }else{
                        Toast.makeText(getActivity(),"Invalider Pseudo or Password",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getActivity(),"Formulaire est Vide !",Toast.LENGTH_LONG).show();
                }



            }
        });


        return view;
    }
}
