package com.wcompany.mrwah.reservation_vol.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.wcompany.mrwah.reservation_vol.R;
import com.wcompany.mrwah.reservation_vol.models.Vol;

import java.util.List;

public class List_vol_adapter extends RecyclerView.Adapter<List_vol_adapter.ViewHolder> {

    private List<Vol> listVols;
    private Context context;
    private OnButtonClickListener mListener;

    public interface OnButtonClickListener{
        void onButtonClickListener (int position);
    }

    public void setOnButtonClickLitener (OnButtonClickListener listener){
        mListener = listener;
    }

    public List_vol_adapter(List<Vol> listVol, Context context) {
        this.listVols = listVol;
        this.context = context;
    }

    @Override
    public List_vol_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_vol_item,viewGroup,false);
        return new ViewHolder(v,mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull List_vol_adapter.ViewHolder viewHolder, int i) {

        Vol listvol = listVols.get(i);

        viewHolder.textPrice.setText(String.valueOf(listvol.getPrix())+" TND");
        viewHolder.textHeure_dep.setText(listvol.getHeureDepart().toString());
        viewHolder.textHeure_arr.setText(listvol.getHeureArrive().toString());

    }

    @Override
    public int getItemCount() {
        return listVols.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textPrice;
        public TextView textHeure_dep;
        public TextView textHeure_arr;
        public Button resBtn;


        public  ViewHolder(View itemView, final OnButtonClickListener listener){
            super(itemView);

            textPrice = itemView.findViewById(R.id.price);
            textHeure_dep=itemView.findViewById(R.id.heur_start);
            textHeure_arr=itemView.findViewById(R.id.heure_dest);
            resBtn=itemView.findViewById(R.id.reserver_btn);

            resBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onButtonClickListener(position);
                        }
                    }
                }
            });
        }
    }


}
