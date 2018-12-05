package com.wcompany.mrwah.reservation_vol.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wcompany.mrwah.reservation_vol.R;
import com.wcompany.mrwah.reservation_vol.models.Client;
import com.wcompany.mrwah.reservation_vol.models.Session;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class login_activity extends AppCompatActivity {
    RequestQueue requestQueue;
    String baseUrl;
    Button login_btn;
    EditText username, password;
    AwesomeValidation username_R;
    Gson json = new GsonBuilder().create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        requestQueue = Volley.newRequestQueue(this);
        baseUrl = getString(R.string.server_link);
        login_btn = findViewById(R.id.login_btn);
        username = findViewById(R.id.username);
        password = findViewById(R.id.pass);
        login_btn.setOnClickListener(login_action);
        // Step 1: designate a style
        username_R = new AwesomeValidation(ValidationStyle.COLORATION);
        username_R.setColor(R.color.colorAccent);  // optional, default color is RED if not set
        // Step 2: add validations
        //  username_R.addValidation(username, "[a-zA-Z0-9._-]{4,}", "Nom d'utilisateur est requis");
    }

    View.OnClickListener login_action = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            if (username_R.validate()) {
                Client cnx = new Client(username.getText().toString(), password.getText().toString());
                login_req(json.toJson(cnx), view);
            }
        }
    };

    private void login_req(String cnx, final View view) {

        final JsonObjectRequest arrReq = new JsonObjectRequest(Request.Method.POST, baseUrl + "/clts/login", cnx, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    Session session;
                    session = new Session(getApplicationContext());
                    session.setAccount(response.toString(), "client");
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
                Toast toast = Toast.makeText(getApplicationContext(), "Nom d'utilisateur ou mot de passe est incorrect", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        requestQueue.add(arrReq);
    }
}
