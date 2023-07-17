package com.example.examenc2movil;

import java.io.Serializable;

public class Venta implements Serializable {
    private int id;
    private String numBomba;
    private String tipoGasolina;
    private String precioGasolina;
    private String capacidadBomba;
    private String acumuladorLitrosBomba;
    private String cantidad;

    public Venta(){
        this.numBomba = "";
        this.tipoGasolina = "";
        this.precioGasolina = "";
        this.capacidadBomba = "";
        this.acumuladorLitrosBomba = "";
        this.cantidad = "";
    }

    public Venta(String numBomba, String tipoGasolina, String precioGasolina, String capacidadBomba, String acumuladorLitrosBomba, String cantidad){
        this.numBomba = numBomba;
        this.tipoGasolina = tipoGasolina;
        this.precioGasolina = precioGasolina;
        this.capacidadBomba = capacidadBomba;
        this.acumuladorLitrosBomba = acumuladorLitrosBomba;
        this.cantidad = cantidad;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNumBomba() { return numBomba; }
    public void setNumBomba(String numBomba) { this.numBomba = numBomba; }
    public String getTipoGasolina() { return tipoGasolina; }
    public void setTipoGasolina(String tipoGasolina) { this.tipoGasolina = tipoGasolina; }
    public String getPrecioGasolina() { return precioGasolina; }
    public void setPrecioGasolina(String precioGasolina) { this.precioGasolina = precioGasolina; }
    public String getCapacidadBomba() { return capacidadBomba; }
    public void setCapacidadBomba(String capacidadBomba) { this.capacidadBomba = capacidadBomba; }
    public String getAcumuladorLitrosBomba() { return acumuladorLitrosBomba; }
    public void setAcumuladorLitrosBomba(String acumuladorLitrosBomba) { this.acumuladorLitrosBomba = acumuladorLitrosBomba; }
    public String getCantidad() { return cantidad; }
    public void setCantidad(String cantidad) { this.cantidad = cantidad; }
}

