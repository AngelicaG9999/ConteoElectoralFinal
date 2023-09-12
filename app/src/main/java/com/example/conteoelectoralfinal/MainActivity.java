package com.example.conteoelectoralfinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int Total = 0;
    private TextView tv1,Tv2,Tv3,Tv4;
    private Button Btn1,Btn2,Btn3;
    private EditText etCantidad,etEdad;

    public void Votos (View view){
        Total = candidato1+candidato2+candidato3;
        if(candidato1 == candidato2 || candidato2 == candidato3 || candidato3 == candidato1){
            Tv4.setText(("Ningún candidato ganó, porque hay un  empate"));
        }
            if (candidato1 > candidato2 && candidato1 > candidato3){
            Tv4.setText(("El candidato 1 ganó las elecciones."));
            }

            if (candidato2>candidato3 && candidato2 > candidato1){
                Tv4.setText(("El candidato 2 ganó las elecciones."));
            }
            if (candidato3 > candidato2 && candidato3 > candidato1){
                Tv4.setText(("El candidato 3 ganó las elecciones."));
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etCantidad = (EditText) findViewById(R.id.etCantidad);
        etEdad = (EditText) findViewById(R.id.etEdad);
        tv1 = (TextView) findViewById(R.id.tv1);
        Tv2 = (TextView) findViewById(R.id.Tv2);
        Tv3 = (TextView) findViewById(R.id.Tv3);
        Tv4 = (TextView) findViewById(R.id.Tv4);
        Btn1 = (Button) findViewById(R.id.Btn1);
        Btn2 = (Button) findViewById(R.id.Btn2);
        Btn3 = (Button) findViewById(R.id.Btn3);
    }


    private int candidato1 = 0, candidato2 = 0, candidato3 = 0;

    public void Candidato1(View view){
        int Tope = Integer.parseInt(etCantidad.getText().toString());
        ValidarEdad();
        if ( ValidarEdad() == true & candidato1+candidato2+candidato3<Tope){
            candidato1 += 1;
            tv1.setText(String.valueOf(candidato1));
        }
    }

    public void Candidato2(View view){
        int Tope = Integer.parseInt(etCantidad.getText().toString());
        ValidarEdad();
        if ( ValidarEdad() == true & candidato1+candidato2+candidato3<Tope){
            candidato2 += 1;
            Tv2.setText(String.valueOf(candidato2));
        }
    }

    public void Candidato3(View view){
        int Tope = Integer.parseInt(etCantidad.getText().toString());
        ValidarEdad();
        if ( ValidarEdad() == true & candidato1+candidato2+candidato3<Tope){
            candidato3 += 1;
            Tv3.setText(String.valueOf(candidato3));
        }
    }
    private boolean ValidarEdad() {
        boolean Votacion = false;
        int años = Integer.parseInt(etEdad.getText().toString());
        if (años >= 18) {
            Votacion = true;
            return Votacion;
        } else {
            AlertDialog.Builder message = new AlertDialog.Builder(this);
            message.setMessage("No puedes votar, no eres mayor de edad");
            message.setTitle("Valida tu edad");
            message.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface mensaje, int which) {
                    mensaje.cancel();
                }
            });
            AlertDialog dialog = message.create();
            dialog.show();
            Votacion = false;
            return Votacion;
        }
    }




}