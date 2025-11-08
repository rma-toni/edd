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
    private int diasPres;

    public Operacion(int id_operacion, Opcion tipo, Usuario user, Libro book, LocalDate date, int diasPres){
        this.id_operacion = id_operacion;
        this.tipo = tipo;
        this.user = user;
        this.book = book;
        this.date = date;
        this.diasPres = diasPres;
    }

    @Override
    public String toString() {
        return "Operacion{" +
                "id_operacion=" + id_operacion +
                ", tipo=" + tipo +
                ", user=" + user.getNombre() +
                ", book=" + book.getTitulo() +
                ", date=" + date +
                '}';
    }
}
