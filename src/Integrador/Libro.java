package Integrador;

//AGREGAR PRECIO

public class Libro implements Comparable<Libro> {

    private int codigo;
    private String titulo;
    private String autor;
    private float precio;
    private boolean disponible;

    public Libro(int codigo, String titulo, String autor, float precio, boolean disponible){
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.disponible = disponible;
    }

    public Libro(int codigo){
        this.codigo = codigo;
        titulo = null;
        autor = null;
        precio = 0;
        disponible = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "codigo=" + codigo +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", precio='" + precio + '\'' +
                ", disponible=" + disponible +
                '}';
    }

    @Override
    public int compareTo(Libro o) {
        return Integer.compare(this.codigo, o.codigo);
    }
}
