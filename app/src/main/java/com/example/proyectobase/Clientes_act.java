package com.example.proyectobase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Clases.Juegos;

public class Clientes_act extends AppCompatActivity {

    private Spinner spin1, spin2;
    private EditText edit;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        spin1 = (Spinner)findViewById(R.id.spn1);
        spin2 = (Spinner)findViewById(R.id.spn2);

        ArrayList<String> listaClientes = (ArrayList<String>)getIntent().getSerializableExtra("listaclientes");
        ArrayList<String> listaJuegos = (ArrayList<String>)getIntent().getSerializableExtra("listajuegos");

        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);
        ArrayAdapter<String> adapts = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaJuegos);

        spin1.setAdapter(adapt);
        spin2.setAdapter(adapts);

        edit = (EditText)findViewById(R.id.edit1);

        tv = (TextView)findViewById(R.id.tv1);
    }

    public void Calcular(View v){

        String cliente = spin1.getSelectedItem().toString();
        String juego = spin2.getSelectedItem().toString();

        Juegos listajuegos = new Juegos();

        int monto = Integer.parseInt(edit.getText().toString());
        int resultadoCallofDuty = listajuegos.getCall_of_Duty() - monto;
        int resultadoSpartanTotalWarrior = listajuegos.getSpartan_Total_Warrior() - monto;


        if (cliente.equals("Camilo") || cliente.equals("Sebastian") && juego.equals("Call of Duty")){

            tv.setText("El precio final del juego es: " + resultadoCallofDuty);

            if (resultadoCallofDuty == 0){
                tv.setText("El juego estaria pagado");
            }
            else if(resultadoCallofDuty < 0){
                tv.setText("Sobrepasaste el pago del juego");
            }
        }

        if (cliente.equals("Camilo") || cliente.equals("Sebastian") && juego.equals("Spartan Total Warrior")){

            tv.setText("El precio final del juego es: " + resultadoSpartanTotalWarrior);

            if (resultadoSpartanTotalWarrior == 0){
                tv.setText("El juego estaria pagado");
            }
            else if (resultadoSpartanTotalWarrior < 0){
                tv.setText("Sobrepasaste el pago del juego");
            }
        }
    }
}

