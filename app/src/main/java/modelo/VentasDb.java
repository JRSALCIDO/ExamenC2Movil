package modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.examenc2movil.Venta;

import java.util.ArrayList;

public class VentasDb implements Persistencia, Proyeccion {

    private Context context;
    private VentasDbHelper helper;
    private SQLiteDatabase db;

    public VentasDb(Context context, VentasDbHelper helper) {
        this.context = context;
        this.helper = helper;
    }

    public VentasDb(Context context) {
        this.context = context;
        this.helper = new VentasDbHelper(this.context);
    }


    @Override
    public void openDataBase() {
        db = helper.getWritableDatabase();
    }

    @Override
    public void closeDataBase() {
        db.close();
    }

    @Override
    public long insertVenta(Venta venta) {
        ContentValues values = new ContentValues();
        values.put(DefineTabla.Ventas.COLUMN_NAME_NUM_BOMBA, venta.getNumBomba());
        values.put(DefineTabla.Ventas.COLUMN_NAME_TIPO_GASOLINA, venta.getTipoGasolina());
        values.put(DefineTabla.Ventas.COLUMN_NAME_PRECIO_GASOLINA, venta.getPrecioGasolina());
        values.put(DefineTabla.Ventas.COLUMN_NAME_CAPACIDAD_BOMBA, venta.getCapacidadBomba());
        values.put(DefineTabla.Ventas.COLUMN_NAME_ACUMULADOR_LITROS_BOMBA, venta.getAcumuladorLitrosBomba());
        values.put(DefineTabla.Ventas.COLUMN_NAME_CANTIDAD, venta.getCantidad());

        this.openDataBase();
        long num = db.insert(DefineTabla.Ventas.TABLE_NAME, null, values);
        this.closeDataBase();
        Log.d("agregar", "insertVenta: " + num);

        return num;
    }

    @Override
    public Venta getVenta(String numBomba) {
        db = helper.getWritableDatabase();

        Cursor cursor = db.query(
                DefineTabla.Ventas.TABLE_NAME,
                DefineTabla.Ventas.REGISTRO,
                DefineTabla.Ventas.COLUMN_NAME_NUM_BOMBA + " = ?",
                new String[]{numBomba},
                null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            Venta venta = readVenta(cursor);
            cursor.close();
            return venta;
        }
        cursor.close();
        return null;
    }




    @Override
    public ArrayList<Venta> allVentas() {
        this.openDataBase(); // Abre la base de datos

        Cursor cursor = db.query(
                DefineTabla.Ventas.TABLE_NAME,
                DefineTabla.Ventas.REGISTRO,
                null, null, null, null, null);
        ArrayList<Venta> ventas = new ArrayList<>();
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Venta venta = readVenta(cursor);
            ventas.add(venta);
            cursor.moveToNext();
        }

        cursor.close();

        this.closeDataBase();
        return ventas;
    }

    @Override
    public Venta readVenta(Cursor cursor) {
        Venta venta = new Venta();
        venta.setId(cursor.getInt(cursor.getColumnIndex(DefineTabla.Ventas.COLUMN_NAME_ID)));
        venta.setNumBomba(cursor.getString(cursor.getColumnIndex(DefineTabla.Ventas.COLUMN_NAME_NUM_BOMBA)));
        venta.setTipoGasolina(cursor.getString(cursor.getColumnIndex(DefineTabla.Ventas.COLUMN_NAME_TIPO_GASOLINA)));
        venta.setPrecioGasolina(cursor.getString(cursor.getColumnIndex(DefineTabla.Ventas.COLUMN_NAME_PRECIO_GASOLINA)));
        venta.setCapacidadBomba(cursor.getString(cursor.getColumnIndex(DefineTabla.Ventas.COLUMN_NAME_CAPACIDAD_BOMBA)));
        venta.setAcumuladorLitrosBomba(cursor.getString(cursor.getColumnIndex(DefineTabla.Ventas.COLUMN_NAME_ACUMULADOR_LITROS_BOMBA)));
        venta.setCantidad(cursor.getString(cursor.getColumnIndex(DefineTabla.Ventas.COLUMN_NAME_CANTIDAD)));
        return venta;
    }
}

