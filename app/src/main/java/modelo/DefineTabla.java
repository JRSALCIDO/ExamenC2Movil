package modelo;

public class DefineTabla {
    public DefineTabla() {}

    public static abstract class Ventas {
        public static final String TABLE_NAME = "ventas";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_NUM_BOMBA = "numBomba";
        public static final String COLUMN_NAME_CANTIDAD_LITROS = "cantidadLitros";
        public static final String COLUMN_NAME_PRECIO_GASOLINA = "precioGasolina";
        public static final String COLUMN_NAME_TOTAL_VENTA = "totalVenta";

        public static String[] REGISTRO = new String[]{
                Ventas.COLUMN_NAME_ID,
                Ventas.COLUMN_NAME_NUM_BOMBA,
                Ventas.COLUMN_NAME_CANTIDAD_LITROS,
                Ventas.COLUMN_NAME_PRECIO_GASOLINA,
                Ventas.COLUMN_NAME_TOTAL_VENTA
        };
    }
}
