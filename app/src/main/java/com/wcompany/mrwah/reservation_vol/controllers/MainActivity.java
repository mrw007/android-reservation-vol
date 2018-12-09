package com.wcompany.mrwah.reservation_vol.controllers;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.wcompany.mrwah.reservation_vol.fragments.HomeFragment;
import com.wcompany.mrwah.reservation_vol.R;
import com.wcompany.mrwah.reservation_vol.models.Session;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        session = new Session(getApplicationContext());
        loadFragment(new HomeFragment());
        if (session.getAccount().equals("")) {
            Intent login = new Intent(getBaseContext(), com.wcompany.mrwah.reservation_vol.controllers.login_activity.class);
            login.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(login);
        }
        BottomNavigationViewEx navigation = findViewById(R.id.navigation_h);
        navigation.setOnNavigationItemSelectedListener(this);
        navigation.enableAnimation(true);
        navigation.enableShiftingMode(false);
        navigation.enableItemShiftingMode(true);
        navigation.setTextVisibility(true);
        navigation.setIconsMarginTop(50);
        navigation.setIconSize(20, 20);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                    .replace(R.id.fragmentContainer_abn, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            // TODO: 3/25/2018 edit with our pages later
            case R.id.abonne_profile:
                Intent profil = new Intent(this, ProfilActivity.class);
                startActivity(profil);
                break;
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;
            case R.id.navigation_rechercher:
                Intent rechercher = new Intent(this, recherche_vol.class);
                startActivity(rechercher);
                break;
            case R.id.navigation_reservations:
                Intent reserv = new Intent(this, Liste_reservationActivity.class);
                startActivity(reserv);
                break;
        }
        return loadFragment(fragment);
    }
}

