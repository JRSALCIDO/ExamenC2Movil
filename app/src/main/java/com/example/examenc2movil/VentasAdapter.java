package com.example.examenc2movil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.examenc2movil.Venta;
import com.example.preexamen.R;

import java.util.List;

public class VentasAdapter extends ArrayAdapter<Venta> {

    private Context context;
    private List<Venta> ventasList;

    public VentasAdapter(Context context, List<Venta> ventasList) {
        super(context, 0, ventasList);
        this.context = context;
        this.ventasList = ventasList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;

        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.activity_lista, parent, false);
        }

        Venta venta = ventasList.get(position);

        TextView textViewNumBomba = itemView.findViewById(R.id.numBomba);
        TextView textViewCantidadLitros = itemView.findViewById(R.id.cantidad);
        TextView textViewPrecioGasolina = itemView.findViewById(R.id.precioGasolina);
        TextView textViewTotalVenta = itemView.findViewById(R.id.tvTotalAPagar);

        textViewNumBomba.setText(venta.getNumBomba());
        textViewCantidadLitros.setText(venta.getCantidadLitros());
        textViewPrecioGasolina.setText(venta.getPrecioGasolina());
        textViewTotalVenta.setText(venta.getTotalVenta());

        return itemView;
    }
}
