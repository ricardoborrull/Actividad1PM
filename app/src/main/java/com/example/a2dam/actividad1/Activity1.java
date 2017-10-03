package com.example.a2dam.actividad1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity1 extends AppCompatActivity {

    private EditText edNom;
    private EditText edApe;
    private Button botonMI;
    private final String TAG = "prueba";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        botonMI = (Button) findViewById(R.id.botonMI);
        edNom = (EditText) findViewById(R.id.edNom);
        edApe = (EditText) findViewById(R.id.edApe);

        botonMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Nombre: "+edNom.getText()+"\nApellidos: "+edApe.getText());
                Intent i = new Intent(getApplicationContext(), Activity2.class);
                startActivity(i);
            }
        });
    }
}
