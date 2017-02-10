package tn.sem.isetch.kolyoumkelma;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Med Melek on 28/05/2016.
 */
public class FragAvatar extends Fragment {

    private String name ;
    private String pseudo ;
    private String password ;

    public FragAvatar (){


    }


    public FragAvatar (String name , String pseudo,String password){

        this.name=name;
        this.pseudo=pseudo ;
        this.password=password ;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragavatar, container, false);

        Button  a = (Button) view.findViewById(R.id.a);
        Button  b = (Button) view.findViewById(R.id.b);
        Button  c = (Button) view.findViewById(R.id.c);
        Button  d = (Button) view.findViewById(R.id.d);

        final  DataBase db = new DataBase(getActivity());

        Button  press = (Button) view.findViewById(R.id.press);

        press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragment=getFragmentManager() ;
                fragment.beginTransaction().replace(R.id.content, new FragInscri(name,pseudo,password)).commit();
            }
        });

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent () ;
                PendingIntent pIntent = PendingIntent.getActivity(getActivity(), 0, intent, 0);
                Notification noti = new Notification.Builder(getActivity())
                        .setTicker("KolYoumKelma Vous Souhaite la Bienvenue ")
                        .setContentTitle(name +"<"+pseudo+">")
                        .setContentText("Mar7bé Bik m3anna")
                        .setSmallIcon(R.drawable.a)
                        .setContentIntent(pIntent)
                        .getNotification();
                noti.flags= Notification.FLAG_AUTO_CANCEL ;
                NotificationManager nm = (NotificationManager) getActivity().getSystemService(getActivity().NOTIFICATION_SERVICE);

                nm.notify(0, noti);

                db.InsertRowJouer(name, pseudo, password,R.drawable.a);
                FragmentManager fragment=getFragmentManager() ;
                fragment.beginTransaction().replace(R.id.content, new FragAcceuil()).commit();

            }
        });
        //--
       b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent () ;
                PendingIntent pIntent = PendingIntent.getActivity(getActivity(), 0, intent, 0);
                Notification noti = new Notification.Builder(getActivity())
                        .setTicker("KolYoumKelma Vous Souhaite la Bienvenue ")
                        .setContentTitle(name +"<"+pseudo+">")
                        .setContentText("Mar7bé Bik m3anna")
                        .setSmallIcon(R.drawable.b)
                        .setContentIntent(pIntent)
                        .getNotification();
                noti.flags= Notification.FLAG_AUTO_CANCEL ;
                NotificationManager nm = (NotificationManager) getActivity().getSystemService(getActivity().NOTIFICATION_SERVICE);
                nm.notify(0, noti);

                db.InsertRowJouer(name, pseudo, password,R.drawable.b);
                FragmentManager fragment=getFragmentManager() ;
                fragment.beginTransaction().replace(R.id.content, new FragAcceuil()).commit();
            }
        });
        //--
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent () ;
                PendingIntent pIntent = PendingIntent.getActivity(getActivity(), 0, intent, 0);
                Notification noti = new Notification.Builder(getActivity())
                        .setTicker("KolYoumKelma Vous Souhaite la Bienvenue ")
                        .setContentTitle(name +"<"+pseudo+">")
                        .setContentText("Mar7bé Bik m3anna")
                        .setSmallIcon(R.drawable.c)
                        .setContentIntent(pIntent)
                        .getNotification();
                noti.flags= Notification.FLAG_AUTO_CANCEL ;
                NotificationManager nm = (NotificationManager) getActivity().getSystemService(getActivity().NOTIFICATION_SERVICE);

                nm.notify(0, noti);

                db.InsertRowJouer(name, pseudo, password, R.drawable.c);
                FragmentManager fragment=getFragmentManager() ;
                fragment.beginTransaction().replace(R.id.content, new FragAcceuil()).commit();
            }
        });
        //--
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent () ;
                PendingIntent pIntent = PendingIntent.getActivity(getActivity(), 0, intent, 0);
                Notification noti = new Notification.Builder(getActivity())
                        .setTicker("KolYoumKelma Vous Souhaite la Bienvenue ")
                        .setContentTitle(name +"<"+pseudo+">")
                        .setContentText("Mar7bé Bik m3anna")
                        .setSmallIcon(R.drawable.d)
                        .setContentIntent(pIntent)
                        .getNotification();
                noti.flags= Notification.FLAG_AUTO_CANCEL ;
                NotificationManager nm = (NotificationManager) getActivity().getSystemService(getActivity().NOTIFICATION_SERVICE);

                nm.notify(0, noti);

                db.InsertRowJouer(name, pseudo, password,R.drawable.d);
                FragmentManager fragment=getFragmentManager() ;
                fragment.beginTransaction().replace(R.id.content, new FragAcceuil()).commit();
            }
        });


        return view;
    }

}
