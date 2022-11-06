package com.example.app_relojes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.app_relojes.adaptadores.ListaRelojesAdapter;
import com.example.app_relojes.db.DbHelper;
import com.example.app_relojes.db.DbMecanicos;
import com.example.app_relojes.entidades.Relojes;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

RecyclerView listaRelojes;
ArrayList<Relojes> relojesArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaRelojes = findViewById(R.id.listaRelojes);

        listaRelojes.setLayoutManager(new LinearLayoutManager(this));

        relojesArrayList = new ArrayList<>();


        ListaRelojesAdapter adapter = new ListaRelojesAdapter;

        /*
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if(db != null){
                    Toast.makeText(MainActivity.this,"BASE DE DATOS CREADA", Toast.LENGTH_LONG).show();

                }else {
                    Toast.makeText(MainActivity.this,"ERROR AL CREAR BASE DE DATOS", Toast.LENGTH_LONG).show();

                }
            }//Fin de funcion button1
        });*/

    }//fin de onCreate

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.menuNuevo:

                nuevoDato();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void nuevoDato(){

        Intent intent = new Intent(this, NuevoActivity.class);
        startActivity(intent);    }



}//fin de clase principal