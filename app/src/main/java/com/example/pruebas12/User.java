package com.example.pruebas12;

public class User {
    private String id;
    private String usuario;
    private String telefono ;
    private String nombre ;

    public User() {
    }

    public User( String usuario) {
        this.id = id;
        this.usuario = usuario;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
