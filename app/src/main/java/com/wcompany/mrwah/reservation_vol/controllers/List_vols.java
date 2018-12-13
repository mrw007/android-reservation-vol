package com.wcompany.mrwah.reservation_vol.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wcompany.mrwah.reservation_vol.R;
import com.wcompany.mrwah.reservation_vol.TimeDeserializer;
import com.wcompany.mrwah.reservation_vol.adapters.List_vol_adapter;
import com.wcompany.mrwah.reservation_vol.models.Vol;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class List_vols extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List_vol_adapter adapter;
    private List<Vol> listVols;
    RequestQueue requestQueue;
    String baseUrl;
    TextView vill_s,vill_dest,dat;
    private JsonArrayRequest get_vols_request;
    Gson json = new GsonBuilder().registerTypeAdapter(Time.class, new TimeDeserializer()).setDateFormat("yyyy-MM-dd").create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_vols);
        baseUrl = getString(R.string.server_link);
        listVols = new ArrayList<Vol>();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        vill_s= findViewById(R.id.vill_s);
        vill_dest=findViewById(R.id.vill_dest);
        dat=findViewById(R.id.dats);

        init();
    }

    private void init() {
        String ville_dep = getIntent().getStringExtra("ville_dep");
        String ville_arr = getIntent().getStringExtra("ville_arr");
        String date_dep = getIntent().getStringExtra("date");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH);

        vill_s.setText(ville_dep);
        vill_dest.setText(ville_arr);
        dat.setText(date_dep);

        Date date = null;
        java.sql.Date sqlDate = null;
        try {
            date = dateFormat.parse(date_dep);
            sqlDate = new java.sql.Date(date.getTime());

           // Log.i("res_r",ville_dep+" "+ville_arr+" "+sqlDate.toString());
            Vol vv= new Vol(sqlDate,ville_dep,ville_arr);
            jsonRequest(json.toJson(vv));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private void jsonRequest(String vv) {
        get_vols_request = new JsonArrayRequest(Request.Method.POST, baseUrl + "/vols/searchVols/", vv,new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        Log.i("v_obj",jsonObject.toString());
                        Vol vol = json.fromJson(jsonObject.toString(), Vol.class);
                        listVols.add(vol);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                setupListAccountRecyclerView(listVols);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("errrr", error.toString());

            }
        });
        requestQueue = Volley.newRequestQueue(List_vols.this);
        requestQueue.add(get_vols_request);
    }

    private void setupListAccountRecyclerView(List<Vol> listRes) {
        recyclerView = findViewById(R.id.liste_de_vol);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new List_vol_adapter(listVols, this);
        adapter.setOnButtonClickLitener(new List_vol_adapter.OnButtonClickListener() {
            @Override
            public void onButtonClickListener(int position) {
                Intent new_res = new Intent(List_vols.this, new_resActivity.class);
                new_res.putExtra("reservation_selected", json.toJson(listVols.get(position)));
                startActivity(new_res);
            }
        });
        recyclerView.setAdapter(adapter);
    }

}
