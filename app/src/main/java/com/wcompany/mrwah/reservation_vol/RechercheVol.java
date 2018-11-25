package com.wcompany.mrwah.reservation_vol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class RechercheVol extends AppCompatActivity {

    Spinner spn_depart, spn_arrivee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_vol);
        //Spinner_depart
        spn_depart = findViewById(R.id.spnn_depart);

        //Spinner_arrivée
        spn_arrivee = findViewById(R.id.spnn_arrivee);
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
    }

}
