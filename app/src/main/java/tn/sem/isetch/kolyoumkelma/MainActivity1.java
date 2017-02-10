package tn.sem.isetch.kolyoumkelma;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity1 extends AppCompatActivity {
public static int etat =0 ;
    public MediaPlayer mp ;

    Button startpause ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);


        startpause = (Button) findViewById(R.id.startpause);

        Button home = (Button) findViewById(R.id.home);
        Button about = (Button) findViewById(R.id.about);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragment=getFragmentManager() ;
                fragment.beginTransaction().replace(R.id.content, new FragAcceuil()).commit();
            }
        });

       about.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               FragmentManager fragment=getFragmentManager() ;
               fragment.beginTransaction().replace(R.id.content, new Iam()).commit();


           }
       });


        startpause.setBackgroundResource(R.drawable.logomusic);

        mp = MediaPlayer.create(getApplicationContext(),R.raw.extraire);
        mp.start();
        mp.setLooping(true);

        FragmentManager fragment=getFragmentManager() ;
        fragment.beginTransaction().replace(R.id.content, new FragAcceuil()).commit();


        startpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etat==0){
                    etat=1 ;
                    startpause.setBackgroundResource(R.drawable.stoplogo);
                    mp.pause();
                }else{
                    etat=0;
                    startpause.setBackgroundResource(R.drawable.logomusic);
                    mp.start();
                }



            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();
        mp.stop();
    }
}
