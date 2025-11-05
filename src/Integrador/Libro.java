package Integrador;

public class Libro implements Comparable<Libro>{

    private int codigo;
    private String titulo;
    private String autor;
    private boolean disponible;

    public Libro(int codigo, String titulo, String autor, boolean disponible){
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "codigo=" + codigo +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", disponible=" + disponible +
                '}';
    }

    @Override
    public int compareTo(Libro o) {
        return Integer.compare(this.codigo, o.codigo);
    }
}
