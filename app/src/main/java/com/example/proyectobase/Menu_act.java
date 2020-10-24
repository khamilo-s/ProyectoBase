package com.example.proyectobase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Menu_act extends AppCompatActivity {

    private ViewFlipper vf;
    private int[] images ={R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);

        vf = (ViewFlipper)findViewById(R.id.slider);

        for (int i = 0; i<images.length; i++ ){
            flip_image(images[i]);
        }
    }

    public void flip_image(int i){
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        vf.addView(view);
        vf.setAutoStart(true);
        vf.setFlipInterval(3000);

        vf.setInAnimation(this,android.R.anim.slide_in_left);
        vf.setOutAnimation(this,android.R.anim.slide_out_right);
    }

    public void personas(View v) {

        ArrayList<String> clientes = new ArrayList<String>();
        ArrayList<String> juegos = new ArrayList<String>();

        clientes.add("Camilo");
        clientes.add("Sebastian");

        juegos.add("Call of Duty");
        juegos.add("Spartan Total Warrior");

        Intent i = new Intent(this, Clientes_act.class);
        i.putExtra("listaclientes", clientes);
        i.putExtra("listajuegos", juegos);
        startActivity(i);
    }

    public void paginaweb(View v){
        Intent i =new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.pcfactory.cl/gamerzone"));
        startActivity(i);
    }

    public void marcar(View v){
        Intent i =new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+"+56944017646"));
        startActivity(i);
    }

    public void ubicacion(View v){
        Intent i = new Intent(this,Maps_act.class);
        startActivity(i);
    }

    public void basedatos(View v){
        Intent i = new Intent(this, BaseDatos_act.class);
        startActivity(i);
    }

    public void info(View v){
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }
}