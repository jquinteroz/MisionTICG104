package com.example.tiendamtic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.tiendamtic.Adaptadores.ProductoAdapter;
import com.example.tiendamtic.DB.DBFirebase;
import com.example.tiendamtic.Entidades.Producto;
import com.google.common.collect.Maps;

import java.util.ArrayList;

public class Catalogo extends AppCompatActivity {
    private DBFirebase dbFirebase;
    private ListView listViewProducts;
    private ArrayList<Producto> arrayProductos;
    private ProductoAdapter productoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);


        listViewProducts=(ListView) findViewById(R.id.listViewProducts);
        arrayProductos=new ArrayList<>();
        dbFirebase=new DBFirebase();

        /* Productos

        Producto producto1=new Producto("PokeBall","Tipica Pokeball",1000,"","","");
        Producto producto2=new Producto("PokeBall2","Tipica Pokeball2",2000,"","","");

        arrayProductos.add(producto1);
        arrayProductos.add(producto2);
        */

        productoAdapter=new ProductoAdapter(this, arrayProductos);
        listViewProducts.setAdapter(productoAdapter);
        dbFirebase.getData(productoAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.itemAdd:
                intent = new Intent(getApplicationContext(), Form.class);
                startActivity(intent);
                return true;
            case R.id.itemMap:
                intent = new Intent(getApplicationContext(), Maps.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }
}