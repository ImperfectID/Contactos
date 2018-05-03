package com.example.rodri.contactos;

public class lista_contactos {

    public String nombre;
    public int foto;


    public lista_contactos() {
    }

    public lista_contactos(String nombre, int foto) {
        this.nombre = nombre;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}