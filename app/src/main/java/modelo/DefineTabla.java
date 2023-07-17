package modelo;

public class DefineTabla {
    public DefineTabla() {}
    public static abstract class Ventas {
        public static final String TABLE_NAME = "ventas";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_NUM_BOMBA = "numBomba";
        public static final String COLUMN_NAME_TIPO_GASOLINA = "tipoGasolina";
        public static final String COLUMN_NAME_PRECIO_GASOLINA = "precioGasolina";
        public static final String COLUMN_NAME_CAPACIDAD_BOMBA = "capacidadBomba";
        public static final String COLUMN_NAME_ACUMULADOR_LITROS_BOMBA = "acumuladorLitrosBomba";
        public static final String COLUMN_NAME_CANTIDAD = "cantidad";

        public static String[] REGISTRO = new String[]{
                Ventas.COLUMN_NAME_ID,
                Ventas.COLUMN_NAME_NUM_BOMBA,
                Ventas.COLUMN_NAME_TIPO_GASOLINA,
                Ventas.COLUMN_NAME_PRECIO_GASOLINA,
                Ventas.COLUMN_NAME_CAPACIDAD_BOMBA,
                Ventas.COLUMN_NAME_ACUMULADOR_LITROS_BOMBA,
                Ventas.COLUMN_NAME_CANTIDAD
        };
    }
}
