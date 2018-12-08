package com.wcompany.mrwah.reservation_vol.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

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
import com.wcompany.mrwah.reservation_vol.TimeSerializer;
import com.wcompany.mrwah.reservation_vol.adapters.List_reservation_adapter;
import com.wcompany.mrwah.reservation_vol.models.Client;
import com.wcompany.mrwah.reservation_vol.models.Reservation;
import com.wcompany.mrwah.reservation_vol.models.Session;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Liste_reservationActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    RequestQueue requestQueue;
    String baseUrl;
    private List<Reservation> listRes;
    private JsonArrayRequest get_reservaztions_request;
    Gson json = new GsonBuilder().registerTypeAdapter(Time.class, new TimeDeserializer()).registerTypeAdapter(Time.class, new TimeSerializer()).setDateFormat("yyyy-MM-dd").create();
    Session session;
    Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_reservation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        baseUrl = getString(R.string.server_link);
        listRes = new ArrayList<Reservation>();
        session = new Session(getApplicationContext());
        String sess = session.getAccount();
        client = json.fromJson(sess, Client.class);
        String id = String.valueOf(client.getIdClt());
        init(id);
    }

    private void init(String id)
    {
        jsonRequest(id);
    }

    private void jsonRequest(String id) {
        get_reservaztions_request = new JsonArrayRequest(Request.Method.GET, baseUrl + "/res/listClient/"+id, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        Reservation res = json.fromJson(jsonObject.toString(), Reservation.class);
                        listRes.add(res);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                setupListAccountRecyclerView(listRes);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue = Volley.newRequestQueue(Liste_reservationActivity.this);
        requestQueue.add(get_reservaztions_request);
    }

    private void setupListAccountRecyclerView(List<Reservation> listRes) {
        recyclerView=findViewById(R.id.liste_de_reservations);
        adapter = new List_reservation_adapter(listRes,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

}
