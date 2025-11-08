package Integrador;

import tp5.ex02.Libro;

public class Pendiente {
    private Usuario usuario;
    private Libro libro;

    public Pendiente(Usuario usuario, Libro libro){
        this.usuario = usuario;
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public Libro getLibro() {
        return libro;
    }
}
