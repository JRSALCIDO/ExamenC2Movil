package modelo;

import com.example.examenc2movil.Venta;

public interface Persistencia {
    void openDataBase();
    void closeDataBase();
    long insertVenta(Venta venta);
}

