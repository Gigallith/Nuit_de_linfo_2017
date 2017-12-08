package fr.unice.polytech.nuit_de_linfo_2017;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import fr.unice.polytech.nuit_de_linfo_2017.chatbot.ChatBot;
import fr.unice.polytech.nuit_de_linfo_2017.easterEggs.EasterEggsFragment;
import fr.unice.polytech.nuit_de_linfo_2017.bonus.BonusFragment;
import fr.unice.polytech.nuit_de_linfo_2017.home.ViewPagerHomeFragment;
import fr.unice.polytech.nuit_de_linfo_2017.questions.LeSaviezVousFragment;
import fr.unice.polytech.nuit_de_linfo_2017.twitter.TwitterFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = ViewPagerHomeFragment.newInstance();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else if(getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        android.app.FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (id == R.id.nav_share)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContent, new ChatBot())
                    .commit();
        } else if (id == R.id.nav_view) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContent, new ViewPagerHomeFragment())
                    .commit();

        } else if (id == R.id.nav_bonus) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContent, new BonusFragment())
                    .commit();
        } else if (id == R.id.nav_easter_eggs) {

            fragmentTransaction.replace(R.id.flContent, EasterEggsFragment.newInstance());
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }else if(id== R.id.nav_leSaviezVous){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContent, new LeSaviezVousFragment())
                    .commit();
        }
        else if(id == R.id.twitter){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContent, new TwitterFragment())
                    .commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
