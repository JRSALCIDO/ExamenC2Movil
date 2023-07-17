package modelo;

import android.database.Cursor;

import com.example.examenc2movil.Venta;

import java.util.ArrayList;

public interface Proyeccion {
    Venta getVenta(String correo);
    ArrayList<Venta> allVentas();
    Venta readVenta(Cursor cursor);
}


