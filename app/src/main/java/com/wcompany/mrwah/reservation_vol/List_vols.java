package com.wcompany.mrwah.reservation_vol;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class List_vols extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<List_vol_item> listVols;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_vols);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();
    }

    private void init()
    {
        recyclerView=findViewById(R.id.liste_de_vol);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listVols = new ArrayList<>();

        for (int i=0; i<=10;i++) {
            List_vol_item l = new List_vol_item(
                    "400",
                    "8:30",
                    "11:30"
            );
            listVols.add(l);
        }
        adapter = new List_vol_adapter(listVols,this);
        recyclerView.setAdapter(adapter);
    }
}
