package com.example.app_relojes.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_relojes.R;
import com.example.app_relojes.entidades.Relojes;

import java.util.ArrayList;

public class ListaRelojesAdapter extends RecyclerView.Adapter<ListaRelojesAdapter.RelojViewHolder> {


    ArrayList<Relojes> listaRelojes;

    public ListaRelojesAdapter(ArrayList<Relojes> listaRelojes){

        this.listaRelojes = listaRelojes;

    }



    @NonNull
    @Override
    public RelojViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_usuario, null, false);
        return new RelojViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RelojViewHolder holder, int position) {

        holder.viewNombre.setText(listaRelojes.get(position).getNombre());
        holder.viewContraseña.setText(listaRelojes.get(position).getContraseña());

    }

    @Override
    public int getItemCount() {

        return listaRelojes.size();
    }

    public class RelojViewHolder extends RecyclerView.ViewHolder {
        TextView viewNombre, viewContraseña;

        public RelojViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewContraseña = itemView.findViewById(R.id.viewContraseña);

        }
    }
}
