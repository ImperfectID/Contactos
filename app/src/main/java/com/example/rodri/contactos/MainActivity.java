package com.example.rodri.contactos;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    ArrayList<String> lista_contactos;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv_contactos);
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        lista_contactos=new ArrayList<String>();

        for(int i=0;i<=50;i++){
            lista_contactos.add("Dato:"+i+"");

        }
        adapter ad = new adapter(lista_contactos);
        rv.setAdapter(ad);

    }
}
