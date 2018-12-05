package com.wcompany.mrwah.reservation_vol.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.wcompany.mrwah.reservation_vol.R;

public class recherche_vol extends AppCompatActivity {

    Spinner spn_depart, spn_arrivee;
    Button rechercher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_vol);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Spinner_depart
        spn_depart = findViewById(R.id.spnn_depart);

        //Spinner_arrivée
        spn_arrivee = findViewById(R.id.spnn_arrivee);

        rechercher = findViewById(R.id.rech);
        init();
    }
    private void init(){

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.pays_array,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_depart.setAdapter(adapter);


        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.pays_array,
                android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_arrivee.setAdapter(adapter);

        rechercher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(recherche_vol.this, List_vols.class);
                startActivity(intent);
            }
        });
    }


}
