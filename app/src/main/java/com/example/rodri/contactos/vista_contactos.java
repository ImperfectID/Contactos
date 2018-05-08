package com.example.rodri.contactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class vista_contactos extends AppCompatActivity {
    TextView nom;
    ImageView fot;
    TextView tel;
    TextView cor;
    TextView di;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_contactos);


        nom = findViewById(R.id.Nombre_tv);
        fot = findViewById(R.id.idImagen);
        tel = findViewById(R.id.num_tel_tv);
        cor = findViewById(R.id.Correo);
        di = findViewById(R.id.dir);

        Intent callingIntent = getIntent();
        String intentAction = callingIntent.getAction();
        String intentType = callingIntent.getType();

        if (Intent.ACTION_SEND.equals(intentAction) && intentType != null){
            if (intentType.equals("text/plain")){
                handleReceivedText(callingIntent);
            }
        }
    }

    private void handleReceivedText(Intent intent){
        String intentText = intent.getStringExtra(Intent.EXTRA_TEXT);

        if (nom != null){
            nom.setText(intentText);
        }
    }


}
