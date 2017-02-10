package tn.sem.isetch.kolyoumkelma;

import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Path;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private  static int etat=0;
    MediaPlayer mp ;
    DataBase db ;
    String pseudo ;
Button  avatar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        pseudo = getIntent().getStringExtra("pseudo");

        toolbar.setBackgroundResource(R.drawable.toolbar);
        toolbar.setLogo(R.drawable.logokolyoumkelmatoolbar);
        toolbar.setTitle(pseudo);
        setSupportActionBar(toolbar);

         avatar = (Button) findViewById(R.id.avatar);



         db = new DataBase(getApplicationContext());

         mp = MediaPlayer.create(getApplicationContext(), R.raw.extraire);
         mp.start();
         mp.setLooping(true);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_dcx) {
            //--
            Intent intent = new Intent () ;
            PendingIntent pIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);
            Notification noti = new Notification.Builder(getApplicationContext())
                    .setTicker("ayya bye bye ")
                    .setContentTitle("<"+pseudo+">")
                    .setContentText("KolYoumKelma t9olek bye bye")
                    .setSmallIcon(R.drawable.logokolyoumkelmatoolbar)
                    .setContentIntent(pIntent)
                    .getNotification();
            noti.flags= Notification.FLAG_AUTO_CANCEL ;
            NotificationManager nm = (NotificationManager) getApplicationContext().getSystemService(getApplication().NOTIFICATION_SERVICE);
            nm.notify(0, noti);
            //---
            Intent versMaine1 = new Intent (getApplicationContext(),MainActivity1.class);
            startActivity(versMaine1);
            return true;
        }

        if (id == R.id.music) {
            if (etat==0){
                item.setIcon(R.drawable.logostopmusic2);
                mp.pause();
                etat=1;
            }else{
                etat=0;
                mp.start();
                item.setIcon(R.drawable.logomusic2);
            }


            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.accueil) {
            FragmentManager fragment=getFragmentManager() ;
            fragment.beginTransaction().replace(R.id.content2, new acceuil(pseudo)).commit();

        } else if (id == R.id.best) {

            FragmentManager fragment=getFragmentManager() ;
            fragment.beginTransaction().replace(R.id.content2, new score(pseudo)).commit();


        } else if (id == R.id.profil) {

            FragmentManager fragment=getFragmentManager() ;
            fragment.beginTransaction().replace(R.id.content2, new profil(pseudo)).commit();

        } else if (id == R.id.delete) {

            db.suprimer(pseudo);
            Intent versMaine1 = new Intent (getApplicationContext(),MainActivity1.class);
            startActivity(versMaine1);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        mp.stop();
    }

}
