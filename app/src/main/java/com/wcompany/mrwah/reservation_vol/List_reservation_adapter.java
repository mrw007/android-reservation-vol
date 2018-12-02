package com.wcompany.mrwah.reservation_vol;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class List_reservation_adapter extends RecyclerView.Adapter<List_reservation_adapter.ViewHolder> {

    private List<List_reservation_item> listReservation;
    private Context context;

    public List_reservation_adapter(List<List_reservation_item> listReservation, Context context) {
        this.listReservation = listReservation;
        this.context = context;
    }

    @Override
    public List_reservation_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_reservation_item,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull List_reservation_adapter.ViewHolder viewHolder, int i) {

        List_reservation_item listres = listReservation.get(i);

        viewHolder.textNum.setText(listres.getNumero());
        viewHolder.textDate.setText(listres.getDate().toString());

    }

    @Override
    public int getItemCount() {
        return listReservation.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textNum;
        public TextView textDate;

        public  ViewHolder(View itemView){
            super(itemView);

            textNum = itemView.findViewById(R.id.numeror);
            textDate=itemView.findViewById(R.id.dater);
        }
    }


}
