package com.example.a2dam.actividad1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Activity1 extends AppCompatActivity {

    private EditText edNom;
    private EditText edApe;
    private Button botonMI;
    private TextView msg;
    private RadioButton hombre;
    private RadioButton mujer;
    private final String TAG = "prueba";
    final int SUBACT_1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        botonMI = (Button) findViewById(R.id.botonMI);
        edNom = (EditText) findViewById(R.id.edNom);
        edApe = (EditText) findViewById(R.id.edApe);
        hombre = (RadioButton) findViewById(R.id.hombre);
        mujer = (RadioButton) findViewById(R.id.mujer);
        msg = (TextView) findViewById(R.id.msg);

        botonMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Nombre: " + edNom.getText() + "\nApellidos: " + edApe.getText());
                Intent i = new Intent(getApplicationContext(), Activity2.class);
                i.putExtra("Nombre", edNom.getText());
                i.putExtra("Apellido", edApe.getText());
                if (hombre.isSelected()) {
                    i.putExtra("Sexo", hombre.getText());
                }
                if (mujer.isSelected()) {
                    i.putExtra("Sexo", mujer.getText());
                }

                if (edNom == null) {
                    if (edApe == null) {
                        Toast.makeText(getApplicationContext(), "Introduce todos los datos para poder continuar.", Toast.LENGTH_LONG).show();
                    }
                }

                startActivityForResult(i, SUBACT_1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SUBACT_1) {
            if (resultCode == RESULT_OK) {
                botonMI.setEnabled(false);
                hombre.setEnabled(false);
                mujer.setEnabled(false);
                edApe.setEnabled(false);
                edNom.setEnabled(false);

                int edad = Integer.parseInt(String.valueOf(data.getCharSequenceExtra("Edad")));
                if (edad < 0) {
                    msg.setText("La edad no es válida");
                    if (edad > 0 && edad < 18) {
                        msg.setText("Eres menor de edad");
                        if (edad > 18 && edad < 35) {
                            msg.setText("Ya eres mayor de edad");
                            if (edad >= 35) {
                                msg.setText("Ay, ay, ay...");
                            }
                        }
                    }
                    //msg.setText("Tienes " + data.getCharSequenceExtra("Edad") + " años");
                    Toast.makeText(this, "¡COMPLETADO!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "CANCELADO", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
