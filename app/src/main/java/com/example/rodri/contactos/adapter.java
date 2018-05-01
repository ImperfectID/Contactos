package com.example.rodri.contactos;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.ViewHolderDatos> {
    ArrayList<String> lista_contactos;

    public adapter(ArrayList<String> lista_contactos){
        this.lista_contactos = lista_contactos;
    }


    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
            holder.asignardatos(lista_contactos.get(position));
    }

    @Override
    public int getItemCount() {
        return lista_contactos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView dato;
        public ViewHolderDatos(View itemView) {
            super(itemView);
            dato = itemView.findViewById(R.id.lista);
        }

        public void asignardatos(String s) {
            dato.setText(s);
        }
    }
}
