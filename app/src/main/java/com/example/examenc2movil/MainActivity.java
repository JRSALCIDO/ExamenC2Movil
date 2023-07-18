package com.example.examenc2movil;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.preexamen.R;

import modelo.VentasDb;
import modelo.VentasDbHelper;

public class MainActivity extends AppCompatActivity {
    public float totalf;
    private EditText etNumBomba;
    private EditText etCantidad;
    private EditText etPrecioGasolina;
    private EditText etCapacidadBomba;
    private EditText etAcumuladorLitrosBomba;

    private TextView tvLitros;
    private TextView tvPrecio;
    private TextView tvTotalAPagar;


    private Button btnIniciarBomba;
    private Button btnHacerVenta;
    private Button btnConsultarRegistro;
    private Button btnRegistrarVenta;
    private Button btnLimpiar;
    private Button btnSalir;

    private VentasDb ventasDb;

    private void abrirListaVentas() {
        // Aquí debes abrir la actividad de la lista de ventas
        Intent intent = new Intent(MainActivity.this, ListaActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar componentes de la interfaz
        etNumBomba = findViewById(R.id.numBomba);
        tvLitros = findViewById(R.id.tvLitros);
        tvPrecio = findViewById(R.id.tvPrecio);
        tvTotalAPagar = findViewById(R.id.tvTotalAPagar);
        etCantidad = findViewById(R.id.cantidad);
        etPrecioGasolina = findViewById(R.id.precioGasolina);
        etCapacidadBomba = findViewById(R.id.capacidadBomba);
        etAcumuladorLitrosBomba = findViewById(R.id.acumuladorLitrosBomba);
        btnIniciarBomba = findViewById(R.id.btnIniciarBomba);
        btnHacerVenta = findViewById(R.id.btnHacerVenta);
        btnRegistrarVenta = findViewById(R.id.btnRegistrarVenta);
        btnConsultarRegistro = findViewById(R.id.btnConsultarRegistro);
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
        btnConsultarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirListaVentas();
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
        // Asignar valores iniciales a la bomba de gasolina
        String numBomba = etNumBomba.getText().toString().trim();
        String tipoGasolina = ""; // Obtén el tipo de gasolina seleccionado
        int contadorVentas = 0;
        int capacidadBomba = 200;

        // Realiza las operaciones necesarias después de iniciar la bomba de gasolina
        // ...

        Toast.makeText(this, "Bomba iniciada", Toast.LENGTH_SHORT).show();
    }


    private void hacerVenta() {
        String cantidad = etCantidad.getText().toString().trim();

        if (cantidad.isEmpty()) {
            Toast.makeText(this, "Ingrese una cantidad válida", Toast.LENGTH_SHORT).show();
            return;
        }

        int cantidadGasolina = Integer.parseInt(cantidad);
        int inventario = 200; // Capacidad de la bomba de gasolina

        if (cantidadGasolina > inventario) {
            Toast.makeText(this, "No hay suficiente gasolina en inventario", Toast.LENGTH_SHORT).show();
            return;
        }

        // Realiza las operaciones necesarias para la venta de gasolina
        int contadorLitros = Integer.parseInt(etAcumuladorLitrosBomba.getText().toString().trim());
        int nuevoContadorLitros = contadorLitros + cantidadGasolina;
        etAcumuladorLitrosBomba.setText(String.valueOf(nuevoContadorLitros));

        // Muestra la cantidad, costo y total a pagar
        double precioGasolina = Double.parseDouble(etPrecioGasolina.getText().toString().trim());
        double costo = cantidadGasolina * precioGasolina;
        double totalPagar = costo * 1.16; // Aplica un impuesto del 16%
        Toast.makeText(this, "Cantidad: " + cantidadGasolina + "\nCosto: $" + costo + "\nTotal a pagar: $" + totalPagar, Toast.LENGTH_SHORT).show();
        tvLitros.setText(String.valueOf(cantidadGasolina));
        tvPrecio.setText(String.valueOf((int) precioGasolina));
        tvTotalAPagar.setText(String.valueOf((int) costo));
    }



    private void registroVenta() {
        // Obtén los valores necesarios para registrar la venta
        String numBomba = etNumBomba.getText().toString();
        String cantidad = etCantidad.getText().toString();
        String precio = etPrecioGasolina.getText().toString();
        String totalVenta = String.valueOf(totalf);

        // Crea el objeto de la venta y guárdalo en la tabla de ventas
        Integer cantidadLitros = Integer.parseInt(cantidad); // Convertir la cantidad a Integer
        Venta venta = new Venta(numBomba, cantidadLitros, precio, totalVenta); // Utiliza cantidadLitros aquí
        ventasDb.insertVenta(venta);

        Toast.makeText(this, "Venta registrada", Toast.LENGTH_SHORT).show();
    }




    private void limpiar() {
        // Limpiar los campos
        etNumBomba.setText("");
        etCantidad.setText("");
        etPrecioGasolina.setText("");
        etCapacidadBomba.setText("");
        etAcumuladorLitrosBomba.setText("");

        Toast.makeText(this, "Campos limpiados", Toast.LENGTH_SHORT).show();
    }

    private void cerrar() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Confirmación");
        builder.setMessage("¿Estás seguro de que quieres cerrar la aplicación?");
        builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        builder.setNegativeButton("No", null);
        builder.show();
    }
}

