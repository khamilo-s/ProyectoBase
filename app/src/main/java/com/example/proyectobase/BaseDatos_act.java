package com.example.proyectobase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Clases.AdminSQLiteOpenHelper;

public class BaseDatos_act extends AppCompatActivity {

    private EditText edcodigo, ednombre, edprecio, edstock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_datos_act);

        edcodigo = (EditText)findViewById(R.id.et_codigo);
        ednombre = (EditText)findViewById(R.id.et_nombre);
        edprecio = (EditText)findViewById(R.id.et_precio);
        edstock  = (EditText)findViewById(R.id.et_stock);
    }

    public void Añadir(View v){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"fichero", null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();
        String nombre = ednombre.getText().toString();
        String precio = edprecio.getText().toString();
        String stock = edstock.getText().toString();

        if (!edcodigo.getText().toString().isEmpty()){

            ContentValues cont = new ContentValues();

            cont.put("codigo", edcodigo.getText().toString());
            cont.put("nombre", ednombre.getText().toString());
            cont.put("precio", edprecio.getText().toString());
            cont.put("stock", edstock.getText().toString());

            db.insert("inventario", null, cont);
            db.close();

            Toast.makeText(this,"Producto ingresado", Toast.LENGTH_LONG).show();

            edcodigo.setText("");
            ednombre.setText("");
            edprecio.setText("");
            edstock.setText("");

        }
        else{
            Toast.makeText(this, "Debe ingresar el codigo del juego", Toast.LENGTH_LONG).show();
        }
    }

    public void Mostrar(View v){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();

        if (!codigo.isEmpty()){

            Cursor fila = db.rawQuery("SELECT nombre, precio, stock FROM inventario WHERE codigo=" + codigo,null);

            if (fila.moveToFirst()){
                ednombre.setText(fila.getString(0));
                edprecio.setText(fila.getString(1));
                edstock.setText(fila.getString(2));
            }
            else{
                Toast.makeText(this, "No hay campos en la tabla inventario", Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(this,"No hay producto que mostrar", Toast.LENGTH_LONG).show();
        }
    }

    public void Eliminar(View v){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();

        db.delete("inventario", "codigo=" + codigo, null);
        db.close();

        Toast.makeText(this, "Juego eliminado", Toast.LENGTH_LONG).show();
    }

    public void Actulizar(View v){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "fichero", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = edcodigo.getText().toString();

        ContentValues cont = new ContentValues();

        cont.put("codigo", edcodigo.getText().toString());
        cont.put("nombre", ednombre.getText().toString());
        cont.put("precio", edprecio.getText().toString());
        cont.put("stock", edstock.getText().toString());

        if (!codigo.isEmpty()){
            db.update("inventario", cont, "codigo=" + codigo, null);
            db.close();

            Toast.makeText(this,"Has actualizado un juego", Toast.LENGTH_LONG).show();
        }

    }
}