package com.example.a2dam.actividad1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    private Button btnCancel;
    private Button btnNext;
    private EditText edEdad;
    private TextView Bienvenido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent info = getIntent();
        Bienvenido = (TextView) findViewById(R.id.Bienvenido);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnNext = (Button) findViewById(R.id.btnNext);
        edEdad = (EditText) findViewById(R.id.edEdad);

        Bienvenido.setText("Hola, "+info.getCharSequenceExtra("Nombre")+" "+info.getCharSequenceExtra("Apellido")+".");

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edad = new Intent();
                if (edEdad.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Introduce todos los datos para poder continuar.", Toast.LENGTH_LONG).show();
                } else {
                    edad.putExtra("Edad", edEdad.getText().toString());
                    setResult(RESULT_OK, edad);
                    finish();
                }
            }
        });
    }
}
