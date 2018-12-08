package com.wcompany.mrwah.reservation_vol.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wcompany.mrwah.reservation_vol.R;
import com.wcompany.mrwah.reservation_vol.models.Reservation;
import com.wcompany.mrwah.reservation_vol.models.Vol;

import java.util.List;

public class List_reservation_adapter extends RecyclerView.Adapter<List_reservation_adapter.ViewHolder> {

    private List<Reservation> listReservation;
    private Context context;

    public List_reservation_adapter(List<Reservation> listReservation, Context context) {
        this.listReservation = listReservation;
        this.context = context;
    }

    @Override
    public List_reservation_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_reservation_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull List_reservation_adapter.ViewHolder viewHolder, int i) {

        Reservation listres = listReservation.get(i);
        viewHolder.r_date.setText(listres.getDateRes().toString());
        viewHolder.n_p_r.setText(String.valueOf(listres.getNbrePlace()));
        Vol vol = listres.getVol();
        viewHolder.V_s_r.setText(vol.getVilleDepart());
        viewHolder.V_d_r.setText(vol.getVilleArrive());
        viewHolder.heure_start.setText(vol.getHeureDepart().toString());
        viewHolder.heur_dest.setText(vol.getHeureArrive().toString());
        viewHolder.d_start.setText(vol.getDateDepart().toString());
        viewHolder.d_dest.setText(vol.getDateArrive().toString());
        viewHolder.f_num.setText(String.valueOf(vol.getNumVol()));
    }

    @Override
    public int getItemCount() {
        return listReservation.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView f_num;
        public TextView V_s_r;
        public TextView heure_start;
        public TextView d_start;
        public TextView V_d_r;
        public TextView heur_dest;
        public TextView d_dest;
        public TextView r_date;
        public TextView n_p_r;


        public ViewHolder(View itemView) {
            super(itemView);
            f_num = itemView.findViewById(R.id.f_num);
            V_s_r = itemView.findViewById(R.id.V_s_r);
            heure_start = itemView.findViewById(R.id.heure_start);
            d_start = itemView.findViewById(R.id.d_start);
            V_d_r = itemView.findViewById(R.id.V_d_r);
            heur_dest = itemView.findViewById(R.id.heur_dest);
            d_dest = itemView.findViewById(R.id.d_dest);
            r_date = itemView.findViewById(R.id.r_date);
            n_p_r = itemView.findViewById(R.id.n_p_r);


        }
    }


}
