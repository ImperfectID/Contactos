package com.example.rodri.contactos;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {
    ArrayList<lista_contactos> cont;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        consRecycler();



    }
    private void listacontactos(){
        cont.add(new lista_contactos("Holi",R.drawable.ic_launcher_background));
        cont.add(new lista_contactos("Holi",R.drawable.ic_launcher_background));
        cont.add(new lista_contactos("Holi",R.drawable.ic_launcher_background));
        cont.add(new lista_contactos("Holi",R.drawable.ic_launcher_background));
        cont.add(new lista_contactos("Holi",R.drawable.ic_launcher_background));
        cont.add(new lista_contactos("Holi",R.drawable.ic_launcher_background));
        cont.add(new lista_contactos("Holi",R.drawable.ic_launcher_background));

    }


    public void onClick(View view){
        Utilidades.visualizacion=Utilidades.GRID;
        consRecycler();
    }



    private void consRecycler(){
        cont=new ArrayList<>();
        rv= findViewById(R.id.rv_contactos);
        rv.setLayoutManager(new GridLayoutManager(this,3));
        listacontactos();

        Adapater_contactos adapter = new Adapater_contactos(cont);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Selección: "+cont.get
                                (rv.getChildAdapterPosition(view))
                                .getNombre(),Toast.LENGTH_SHORT).show();
            }
        });

        rv.setAdapter(adapter);



    }
}
