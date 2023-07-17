package com.example.examenc2movil;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.preexamen.R;

import modelo.VentasDb;
import modelo.VentasDbHelper;

public class MainActivity extends AppCompatActivity {

    private EditText etNumBomba;
    private EditText etCantidad;
    private Button btnIniciarBomba;
    private Button btnHacerVenta;
    private Button btnRegistrarVenta;
    private Button btnLimpiar;
    private Button btnSalir;

    private VentasDb ventasDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar componentes de la interfaz
        etNumBomba = findViewById(R.id.numBomba);
        etCantidad = findViewById(R.id.cantidad);
        btnIniciarBomba = findViewById(R.id.btnIniciarBomba);
        btnHacerVenta = findViewById(R.id.btnHacerVenta);
        btnRegistrarVenta = findViewById(R.id.btnRegistrarVenta);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnSalir = findViewById(R.id.btnSalir);

        // Inicializar base de datos
        VentasDbHelper dbHelper = new VentasDbHelper(this);
        ventasDb = new VentasDb(this, dbHelper);

        // Configurar listeners para los botones
        btnIniciarBomba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarVenta();
            }
        });

        btnHacerVenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hacerVenta();
            }
        });

        btnRegistrarVenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registroVenta();
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cerrar();
            }
        });
    }

    private void iniciarVenta() {
        // Implementa tu lógica para iniciar la venta aquí
        // Puedes acceder a los valores ingresados en los EditText utilizando etNumBomba.getText().toString()
        Toast.makeText(this, "Iniciar venta", Toast.LENGTH_SHORT).show();
    }

    private void hacerVenta() {
        // Implementa tu lógica para hacer la venta aquí
        // Puedes acceder a los valores ingresados en los EditText utilizando etCantidad.getText().toString()
        Toast.makeText(this, "Hacer venta", Toast.LENGTH_SHORT).show();
    }

    private void registroVenta() {
        // Implementa tu lógica para registrar la venta aquí
        Toast.makeText(this, "Registrar venta", Toast.LENGTH_SHORT).show();
    }

    private void limpiar() {
        // Implementa tu lógica para limpiar los campos aquí
        etNumBomba.setText("");
        etCantidad.setText("");
        Toast.makeText(this, "Limpiar campos", Toast.LENGTH_SHORT).show();
    }

    private void cerrar() {
        // Implementa tu lógica para cerrar la aplicación aquí
        Toast.makeText(this, "Cerrar aplicación", Toast.LENGTH_SHORT).show();
        finish();
    }
}
