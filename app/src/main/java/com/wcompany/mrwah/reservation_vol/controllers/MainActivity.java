package com.wcompany.mrwah.reservation_vol.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.wcompany.mrwah.reservation_vol.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CardView liste_vols = findViewById(R.id.btn_liste_vols);
        liste_vols.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, recherche_vol.class);
            startActivity(intent);
            }
        });
        final CardView liste_res = findViewById(R.id.liste_res);
        liste_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Liste_reservationActivity.class);
                startActivity(intent);
            }
        });

    }
}
