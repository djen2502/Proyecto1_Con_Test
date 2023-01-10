package com.example.proyecto1_con_test.modelos;

import javafx.beans.property.*;

import java.sql.Blob;

public class Bebida {

    private final IntegerProperty ID;
    private final StringProperty Nombre;
    private final DoubleProperty Precio;
    private final IntegerProperty Cantidad;
    private final StringProperty ProxEncargo;



    public Bebida(Integer ID, String Nombre, Double Precio,
                  Integer Cantidad, String ProxEncargo) {
        this.ID = new SimpleIntegerProperty(ID);
        this.Nombre = new SimpleStringProperty(Nombre);
        this.Precio = new SimpleDoubleProperty(Precio);
        this.Cantidad = new SimpleIntegerProperty(Cantidad);
        this.ProxEncargo = new SimpleStringProperty(ProxEncargo);
    }

    @Override
    public String toString() {
        return "Bebida{" +
                "ID=" + ID +
                ", Nombre=" + Nombre +
                ", Precio=" + Precio +
                ", Cantidad=" + Cantidad +
                ", Proximo encargo =" + ProxEncargo +
                '}';
    }

    public Integer getID() {
        return ID.get();
    }

    public IntegerProperty IDProperty() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID.set(ID);
    }

    public String getNombre() {
        return Nombre.get();
    }

    public StringProperty NombreProperty() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre.set(Nombre);
    }

    public String getProxEncargo() {
        return ProxEncargo.get();
    }

    public StringProperty ProxEncargoProperty() {
        return ProxEncargo;
    }

    public void setProxEncargo(String ProxEncargo) {
        this.ProxEncargo.set(ProxEncargo);
    }

    public Integer getCantidad() {
        return Cantidad.get();
    }

    public IntegerProperty CantidadProperty() {
        return Cantidad;
    }

    public void setCantidad(Integer Cantidad) {
        this.Cantidad.set(Cantidad);
    }

    public Double getPrecio() {
        return Precio.get();
    }

    public DoubleProperty PrecioProperty() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio.set(Precio);
    }


}