package com.wcompany.mrwah.reservation_vol.controllers;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.wcompany.mrwah.reservation_vol.R;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class recherche_vol extends AppCompatActivity {

    Spinner spn_depart, spn_arrivee;
    Button rechercher;
    Calendar Cal_dep;
    EditText date_dep;

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

        date_dep = findViewById(R.id.date_dep);
        init();
    }

    private void init() {

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

                String depart = spn_depart.getSelectedItem().toString();
                String arrivee = spn_arrivee.getSelectedItem().toString();
                //java.util.Date utilStartDate = Cal_dep.getTime();
                //Date date = new java.sql.Date(utilStartDate.getTime());
                String date = date_dep.getText().toString();
                Intent intent = new Intent(recherche_vol.this, List_vols.class);
                intent.putExtra("ville_dep", depart);
                intent.putExtra("ville_arr", arrivee);
                intent.putExtra("date", date);
                startActivity(intent);
            }
        });
        Cal_dep = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // TODO Auto-generated method stub
                Cal_dep.set(Calendar.YEAR, year);
                Cal_dep.set(Calendar.MONTH, monthOfYear);
                Cal_dep.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };
        date_dep.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    new DatePickerDialog(recherche_vol.this, date, 2018, 12, 1).show();
                }
            }
        });
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRENCH);
        date_dep.setText(sdf.format(Cal_dep.getTime()));
    }


}
