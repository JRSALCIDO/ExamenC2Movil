package com.example.examenc2movil;

import java.io.Serializable;

public class Venta implements Serializable {
    private int id;
    private String numBomba;
    private String cantidadLitros;
    private String precioGasolina;
    private String totalVenta;

    public Venta() {
        this.numBomba = "";
        this.cantidadLitros = "";
        this.precioGasolina = "";
        this.totalVenta = "";
    }

    public Venta(String numBomba, String cantidadLitros, String precioGasolina, String totalVenta) {
        this.numBomba = numBomba;
        this.cantidadLitros = cantidadLitros;
        this.precioGasolina = precioGasolina;
        this.totalVenta = totalVenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumBomba() {
        return numBomba;
    }

    public void setNumBomba(String numBomba) {
        this.numBomba = numBomba;
    }

    public String getCantidadLitros() {
        return cantidadLitros;
    }

    public void setCantidadLitros(String cantidadLitros) {
        this.cantidadLitros = cantidadLitros;
    }

    public String getPrecioGasolina() {
        return precioGasolina;
    }

    public void setPrecioGasolina(String precioGasolina) {
        this.precioGasolina = precioGasolina;
    }

    public String getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(String totalVenta) {
        this.totalVenta = totalVenta;
    }

    @Override
    public String toString() {
        return
                cantidadLitros +
                " X " + precioGasolina +
                " = " + totalVenta + '\'';
    }
}
