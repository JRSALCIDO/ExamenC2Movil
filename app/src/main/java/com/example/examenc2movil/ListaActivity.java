package com.example.examenc2movil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.preexamen.R;

import java.util.ArrayList;

import modelo.VentasDb;
import modelo.VentasDbHelper;

public class ListaActivity extends AppCompatActivity {

    private VentasDb ventasDb;
    private ArrayList<Venta> listaVentas;
    private ListView listView;
    private Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        btnRegresar = findViewById(R.id.btnRegresar);
        listView = findViewById(R.id.lst);

        VentasDbHelper dbHelper = new VentasDbHelper(this);
        ventasDb = new VentasDb(this, dbHelper);


        listaVentas = ventasDb.allVentas();

        // Crea un adaptador para la lista de ventas
        ArrayAdapter<Venta> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaVentas);
        listView.setAdapter(adapter);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresar();
            }
        });





    }

    private void regresar() {
        // Crea un intent para volver a la actividad principal (MainActivity)
        Intent intent = new Intent(ListaActivity.this, MainActivity.class);
        startActivity(intent);
        finish(); // Cierra la actividad actual (ListaActivity)
    }
}
