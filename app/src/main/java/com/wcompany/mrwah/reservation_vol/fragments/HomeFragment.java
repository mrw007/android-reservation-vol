package com.wcompany.mrwah.reservation_vol.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wcompany.mrwah.reservation_vol.R;
import com.wcompany.mrwah.reservation_vol.TimeDeserializer;
import com.wcompany.mrwah.reservation_vol.TimeSerializer;
import com.wcompany.mrwah.reservation_vol.controllers.Liste_reservationActivity;
import com.wcompany.mrwah.reservation_vol.controllers.MainActivity;
import com.wcompany.mrwah.reservation_vol.controllers.recherche_vol;
import com.wcompany.mrwah.reservation_vol.models.Client;
import com.wcompany.mrwah.reservation_vol.models.Session;

import java.sql.Time;


public class HomeFragment extends Fragment {

    Session session;
    Gson gson;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        final CardView liste_vols = rootView.findViewById(R.id.btn_liste_vols);
        liste_vols.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), recherche_vol.class);
                startActivity(intent);
            }
        });
        final CardView liste_res = rootView.findViewById(R.id.liste_res);
        liste_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Liste_reservationActivity.class);
                startActivity(intent);
            }
        });
        session = new Session(getActivity().getApplicationContext());
        gson = new GsonBuilder().registerTypeAdapter(Time.class, new TimeDeserializer()).registerTypeAdapter(Time.class, new TimeSerializer()).setDateFormat("yyyy-MM-dd").create();
        Client c = gson.fromJson(session.getAccount(), Client.class);
        TextView nom_prenom = rootView.findViewById(R.id.nom_pren);
        String st = c.getPrenom_clt() + " " + c.getNom_clt();
        nom_prenom.setText(st);
        return rootView;
    }

}
