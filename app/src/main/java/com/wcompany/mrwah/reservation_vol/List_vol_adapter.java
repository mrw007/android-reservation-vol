package com.wcompany.mrwah.reservation_vol;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class List_vol_adapter extends RecyclerView.Adapter<List_vol_adapter.ViewHolder> {

    private List<List_vol_item> listVols;
    private Context context;

    public List_vol_adapter(List<List_vol_item> listVol, Context context) {
        this.listVols = listVol;
        this.context = context;
    }

    @Override
    public List_vol_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_vol_item,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull List_vol_adapter.ViewHolder viewHolder, int i) {

        List_vol_item listvol = listVols.get(i);

        viewHolder.textPrice.setText(listvol.getPrice());
        viewHolder.textHeure_dep.setText(listvol.getHeure_dep());
        viewHolder.textHeure_arr.setText(listvol.getHeure_arr());

    }

    @Override
    public int getItemCount() {
        return listVols.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textPrice;
        public TextView textHeure_dep;
        public TextView textHeure_arr;

        public  ViewHolder(View itemView){
            super(itemView);

            textPrice = itemView.findViewById(R.id.price);
            textHeure_dep=itemView.findViewById(R.id.heur_start);
            textHeure_arr=itemView.findViewById(R.id.heure_dest);
        }
    }


}
