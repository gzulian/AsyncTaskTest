package com.example.root.asynctask.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.root.asynctask.R;
import com.example.root.asynctask.model.Mascota;

import java.util.List;

/**
 * Created by root on 11-01-18.
 */

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {

    private List<Mascota> lista;
    private  int resource;
    private Activity activity;

    public MascotaAdapter(List<Mascota> lista, int resource, Activity activity) {
        this.lista = lista;
        this.resource = resource;
        this.activity = activity;
    }

    public MascotaAdapter() {
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new MascotaViewHolder(view);


    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {
        Mascota m = lista.get(position);
        holder.itemId.setText(String.valueOf(m.getId()));
        holder.itemRaza.setText(m.getRaza());
        holder.itemNombre.setText(m.getNombre());

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class MascotaViewHolder extends RecyclerView.ViewHolder{
        private TextView itemNombre,itemRaza,itemId , itemCircle;
        private ImageView itemDelete;
        public MascotaViewHolder(View itemView){
            super(itemView);
            itemNombre = itemView.findViewById(R.id.itemName);
            itemRaza   = itemView.findViewById(R.id.itemRaza);
            itemId     = itemView.findViewById(R.id.item_id);
            itemDelete = itemView.findViewById(R.id.item_delete);
            itemCircle = itemView.findViewById(R.id.itemCircle);


        }
    }
}
