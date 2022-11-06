package com.example.app_relojes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app_relojes.db.DbHelper;
import com.example.app_relojes.db.DbMecanicos;

public class NuevoActivity extends AppCompatActivity {

    EditText txtNombre, txtContraseña;

    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        txtNombre = findViewById(R.id.txtNombre);
        txtContraseña = findViewById(R.id.txtContraseña);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbMecanicos dbMecanicos = new DbMecanicos(NuevoActivity.this);
                long id = dbMecanicos.insertarRelojes(txtNombre.getText().toString(), txtContraseña.getText().toString());

                if(id > 0) {
                    Toast.makeText(NuevoActivity.this, "Datos Guardados", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(NuevoActivity.this, "ERROR AL GUARDAR LOS DATOS", Toast.LENGTH_LONG).show();


                }
            }

        });


    }

    private void clean (){
        txtNombre.setText("");
        txtContraseña.setText("");

    }

}