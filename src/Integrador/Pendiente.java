package Integrador;


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

    @Override
    public String toString() {
        return "Pendiente{" +
                "usuario=" + usuario.getNombre() +
                ", libro=" + libro.getTitulo() +
                '}';
    }
}