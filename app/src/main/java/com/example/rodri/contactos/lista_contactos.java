package com.example.rodri.contactos;

public class lista_contactos {

    public String nombre;
    public int foto;
    public String Telefono;
    public String Email;
    public String fecha;


    public lista_contactos() {
    }

    public lista_contactos(String nombre, int foto, String telefono, String email, String fecha) {
        this.nombre = nombre;
        this.foto = foto;
        Telefono = telefono;
        Email = email;
        this.fecha = fecha;
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
    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}