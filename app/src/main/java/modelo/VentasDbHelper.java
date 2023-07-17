package modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class VentasDbHelper extends SQLiteOpenHelper {

    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = " ,";
    private static final String SQL_CREATE_VENTA = "CREATE TABLE " +
            DefineTabla.Ventas.TABLE_NAME + " (" +
            DefineTabla.Ventas.COLUMN_NAME_ID + INTEGER_TYPE + " PRIMARY KEY" + COMMA_SEP +
            DefineTabla.Ventas.COLUMN_NAME_NUM_BOMBA + TEXT_TYPE + COMMA_SEP +
            DefineTabla.Ventas.COLUMN_NAME_CANTIDAD_LITROS + INTEGER_TYPE + COMMA_SEP +
            DefineTabla.Ventas.COLUMN_NAME_PRECIO_GASOLINA + TEXT_TYPE + COMMA_SEP +
            DefineTabla.Ventas.COLUMN_NAME_TOTAL_VENTA + TEXT_TYPE + ")";

    private static final String SQL_DELETE_VENTA = "DROP TABLE IF EXISTS " +
            DefineTabla.Ventas.TABLE_NAME;

    private static final String DATABASE_NAME = "db1";
    private static final int DATABASE_VERSION = 1;

    public VentasDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_VENTA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_VENTA);
        onCreate(sqLiteDatabase);
    }
}
