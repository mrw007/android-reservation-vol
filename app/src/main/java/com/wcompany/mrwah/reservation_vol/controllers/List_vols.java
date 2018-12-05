package com.wcompany.mrwah.reservation_vol.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wcompany.mrwah.reservation_vol.List_vol_item;
import com.wcompany.mrwah.reservation_vol.R;
import com.wcompany.mrwah.reservation_vol.TimeDeserializer;
import com.wcompany.mrwah.reservation_vol.adapters.List_vol_adapter;
import com.wcompany.mrwah.reservation_vol.models.Vol;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class List_vols extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Vol> listVols;
    RequestQueue requestQueue;
    String baseUrl;
    private JsonArrayRequest get_vols_request;
    Gson json = new GsonBuilder().registerTypeAdapter(Time .class, new TimeDeserializer()).setDateFormat("yyyy-MM-dd"). create();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_vols);
        baseUrl = getString(R.string.server_link);
        listVols = new ArrayList<Vol>();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        init();
    }

    private void init() {
        jsonRequest();
    }

    private void jsonRequest() {
        get_vols_request = new JsonArrayRequest(Request.Method.GET, baseUrl + "/vols/list", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
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
        recyclerView.setAdapter(adapter);
    }

}
