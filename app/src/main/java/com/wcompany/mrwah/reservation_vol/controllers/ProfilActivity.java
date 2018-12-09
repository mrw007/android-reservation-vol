package com.wcompany.mrwah.reservation_vol.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wcompany.mrwah.reservation_vol.R;
import com.wcompany.mrwah.reservation_vol.adapters.List_reservation_adapter;
import com.wcompany.mrwah.reservation_vol.adapters.ProfileDetailsListAdapter;
import com.wcompany.mrwah.reservation_vol.models.Client;
import com.wcompany.mrwah.reservation_vol.models.Session;

import java.sql.Time;

public class ProfilActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        recyclerView = findViewById(R.id.liste_profil);
        adapter = new ProfileDetailsListAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.edit:
                // Intent edit = new Intent(this, abonne_profile_edit.class);
                // edit.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //startActivity(edit);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
