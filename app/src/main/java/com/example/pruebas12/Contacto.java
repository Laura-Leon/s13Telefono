package com.example.pruebas12;

public class Contacto {

    private String telefono ;
    private String nombre ;

    public Contacto() {
    }

    public Contacto( String nombre, String telefono) {


        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
