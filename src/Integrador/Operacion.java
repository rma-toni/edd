package Integrador;

import java.time.LocalDate;

public class Operacion {

    public enum Opcion {
        PRESTAMO,
        DEVOLUCION;
    }

    private int id_operacion;
    private Opcion tipo;
    private Usuario user;
    private Libro book;
    private LocalDate date;
    private LocalDate returnDate;
    private int diasPres;
    private boolean completada;

    public Operacion(int id_operacion, Opcion tipo, Usuario user, Libro book, LocalDate date, int diasPres){
        this.id_operacion = id_operacion;
        this.tipo = tipo;
        this.user = user;
        this.book = book;
        this.date = date;
        this.diasPres = diasPres;
        this.returnDate = date.plusDays(diasPres);
        if (this.tipo == Opcion.PRESTAMO){
            this.completada = false;
        }else{
            this.completada = true;
        }
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    public Libro getBook() {
        return book;
    }

    public Usuario getUser() {
        return user;
    }

    public Opcion getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Operacion{" +
                "id_operacion=" + id_operacion +
                ", tipo=" + tipo +
                ", user=" + user.getNumeroUsuario() +
                ", book=" + book.getTitulo() +
                ", fecha=" + date +
                ", fecha devolucion=" + returnDate +
                ", completada=" + completada +
                '}';
    }
}
