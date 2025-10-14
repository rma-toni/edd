package tp5.ex03;

import java.time.LocalDate;

public class Reserva {
    private int codigo;
    private String recurso;
    private LocalDate fechaReserva;
    private String solicitante;

    public Reserva(int codigo, String recurso, LocalDate fechaReserva, String solicitante){
        this.codigo = codigo;
        this.recurso = recurso;
        this.fechaReserva = fechaReserva;
        this.solicitante = solicitante;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "codigo=" + codigo +
                ", recurso='" + recurso + '\'' +
                ", fechaReserva=" + fechaReserva +
                ", solicitante='" + solicitante + '\'' +
                '}';
    }
}
