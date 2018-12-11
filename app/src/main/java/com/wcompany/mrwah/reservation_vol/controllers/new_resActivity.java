package com.wcompany.mrwah.reservation_vol.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wcompany.mrwah.reservation_vol.R;
import com.wcompany.mrwah.reservation_vol.TimeDeserializer;
import com.wcompany.mrwah.reservation_vol.TimeSerializer;
import com.wcompany.mrwah.reservation_vol.models.Client;
import com.wcompany.mrwah.reservation_vol.models.Reservation;
import com.wcompany.mrwah.reservation_vol.models.Session;
import com.wcompany.mrwah.reservation_vol.models.Vol;

import org.json.JSONObject;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

public class new_resActivity extends AppCompatActivity {
    Gson gson;
    Session session;
    RequestQueue requestQueue;
    String baseUrl;
    Button conf_btn;
    Vol selected_vol;
    Client client;
    TextView nbr_places;
    Date currentTime;
    int nbr_p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_res);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        conf_btn = findViewById(R.id.conf_btn);
        nbr_places = findViewById(R.id.nbr_pass);
        session = new Session(getApplicationContext());
        requestQueue = Volley.newRequestQueue(this);
        init();
    }

    private void init() {
        gson = new GsonBuilder().registerTypeAdapter(Time.class, new TimeDeserializer()).registerTypeAdapter(Time.class, new TimeSerializer()).setDateFormat("yyyy-MM-dd").create();
        baseUrl = getString(R.string.server_link);
        String v = getIntent().getStringExtra("reservation_selected");
        selected_vol = gson.fromJson(v, Vol.class);
        String sess = session.getAccount();
        client = gson.fromJson(sess, Client.class);
        java.util.Date utilStartDate = Calendar.getInstance().getTime();
        currentTime = new java.sql.Date(utilStartDate.getTime());
        nbr_p = 1;
        nbr_places.setText(String.valueOf(nbr_p));
        Log.i("dddd", currentTime.toString());
        conf_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!nbr_places.getText().toString().equals("")) {
                    nbr_p = Integer.parseInt(nbr_places.getText().toString());
                    if (nbr_p != 0) {
                        Reservation res = new Reservation(currentTime, selected_vol, client, nbr_p);
                        Log.i("ddddf", gson.toJson(res));
                        res_req(gson.toJson(res), v);
                    } else {
                        Toast toast3 = Toast.makeText(getApplicationContext(), "Veuillez vérifier le nombre de passagers", Toast.LENGTH_SHORT);
                        toast3.show();
                    }
                } else {
                    Toast toast2 = Toast.makeText(getApplicationContext(), "Veuillez vérifier le nombre de passagers", Toast.LENGTH_SHORT);
                    toast2.show();
                }

            }
        });
    }

    private void res_req(String cnx, final View view) {

        final JsonObjectRequest arrReq = new JsonObjectRequest(Request.Method.POST, baseUrl + "/res/create", cnx, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Réservation confirmé avec succès", Toast.LENGTH_SHORT);
                    toast1.show();
                    Intent home = new Intent(view.getContext(), MainActivity.class);
                    startActivity(home);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast toast = Toast.makeText(getApplicationContext(), "Problèmo", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        requestQueue.add(arrReq);
    }
}
