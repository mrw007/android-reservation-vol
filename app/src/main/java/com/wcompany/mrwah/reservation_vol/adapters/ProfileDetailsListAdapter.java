package com.wcompany.mrwah.reservation_vol.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wcompany.mrwah.reservation_vol.R;
import com.wcompany.mrwah.reservation_vol.TimeDeserializer;
import com.wcompany.mrwah.reservation_vol.TimeSerializer;
import com.wcompany.mrwah.reservation_vol.models.Client;
import com.wcompany.mrwah.reservation_vol.models.Session;


import java.sql.Time;
import java.util.List;

public class ProfileDetailsListAdapter extends RecyclerView.Adapter<ProfileDetailsListAdapter.ViewHolder> {

    private Context context;
    Gson json = new GsonBuilder().registerTypeAdapter(Time.class, new TimeDeserializer()).registerTypeAdapter(Time.class, new TimeSerializer()).setDateFormat("yyyy-MM-dd").create();
    Session session;
    public ProfileDetailsListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ProfileDetailsListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.profile_details_list_item, viewGroup, false);
        session = new Session(context.getApplicationContext());
        return new ProfileDetailsListAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileDetailsListAdapter.ViewHolder viewHolder, int i) {
        Client client = json.fromJson(session.getAccount(), Client.class);
        viewHolder.username_title.setText(client.getloginClt());
        viewHolder.age_t.setText(String.valueOf(client.getAge_clt()));
        viewHolder.email.setText(client.getMail_clt());
        viewHolder.phone.setText(client.getNum_tel_clt());
        viewHolder.adress.setText(client.getAdresse_clt());


    }

    @Override
    public int getItemCount() {

        return 1;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView username_title;
        public TextView age_t;
        public TextView email;
        public TextView phone;
        public TextView adress;
        private LinearLayout logout;



        public ViewHolder(@NonNull View itemView)  {
            super(itemView);
            username_title = itemView.findViewById(R.id.username);
            age_t = itemView.findViewById(R.id.age_t);
            email = itemView.findViewById(R.id.email);
            phone = itemView.findViewById(R.id.phone);
            adress = itemView.findViewById(R.id.adress);
            logout = itemView.findViewById(R.id.logout);
            logout.setOnClickListener(this);

        }
        @Override
        public void onClick(View view) {
            if (view == logout) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage("Etes-vous sûr de vouloir se déconnecter?")
                        .setPositiveButton("Se déconnecter", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                session.deleteAccount();
                                Intent login = new Intent(context, com.wcompany.mrwah.reservation_vol.controllers.login_activity.class);
                                login.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                Toast.makeText(context, "Vous êtes maintenant déconnecté", Toast.LENGTH_LONG).show();
                                context.startActivity(login);
                            }
                        })
                        .setNegativeButton("Non", null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        }
    }
}
