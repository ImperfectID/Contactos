package com.example.rodri.contactos;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapater_contactos extends RecyclerView.Adapter<Adapater_contactos.ViewHolderContactos> implements View.OnClickListener{
    ArrayList<lista_contactos> Lista_c;
    private View.OnClickListener listener;

    public Adapater_contactos(ArrayList<lista_contactos> Lista_c) {
        this.Lista_c = Lista_c;
    }

    @NonNull
    @Override
    public Adapater_contactos.ViewHolderContactos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layout = 0;
        layout=R.layout.lista;
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.lista,null,false);
        view.setOnClickListener(this);
        return new ViewHolderContactos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapater_contactos.ViewHolderContactos holder, int position) {

        holder.txv.setText(Lista_c.get(position).getNombre());
        holder.Iv.setImageResource(Lista_c.get(position).getFoto());

    }

    @Override
    public int getItemCount() {
        return Lista_c.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }
    }

    public class ViewHolderContactos extends RecyclerView.ViewHolder {
        TextView txv;
        ImageView Iv;


        public ViewHolderContactos(View itemView) {
            super(itemView);

            txv =itemView.findViewById(R.id.idNombre);
            Iv = itemView.findViewById(R.id.idImagen);

        }
    }
}
