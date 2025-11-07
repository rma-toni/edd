package Integrador;

import java.time.LocalDate;

public class Operacion {

    public enum Opcion {
        PRESTAMO,
        DEVOLUCION;
    }

    private Opcion tipo;
    private Usuario user;
    private Libro book;
    private LocalDate date;

    public Operacion(Opcion tipo, Usuario user, Libro book, LocalDate date){
        this.tipo = tipo;
        this.user = user;
        this.book = book;
        this.date = date;
    }

}
