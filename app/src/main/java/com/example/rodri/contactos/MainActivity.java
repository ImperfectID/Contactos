package com.example.rodri.contactos;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;




public class MainActivity extends Activity {
    ArrayList<lista_contactos> cont;
    RecyclerView rv;
    TextView tera;







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
        get_contacts();

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
    public void get_contacts(){


        Cursor cursor = null;
        ContentResolver contentResolver = getContentResolver();
        try{
            cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
        }catch (Exception ex){
            Log.e("Error Contact", ex.getMessage());

        }
        if(cursor.getCount()>0){
            while (cursor.moveToNext()){
                lista_contactos lc = new lista_contactos();
                String contact_id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                String Display_name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                lc.nombre = Display_name;

                int number = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));
                if(number>0){
                    Cursor tel = contentResolver.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI
                            ,null
                            ,ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?"
                            ,new String[]{contact_id}
                            ,null);

                    while (tel.moveToNext()){
                        String phone_number = tel.getString(tel.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        lc.Telefono = phone_number;


                    }
                    tel.close();

                }

                cont.add(lc);




            }
            Adapater_contactos ad = new Adapater_contactos(this,cont);
            rv.setAdapter(ad);



        }

    }



}
