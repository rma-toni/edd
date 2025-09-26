package tp4.ex06;

import java.time.LocalTime;

//En teoria el ingreso tiene que ser inmutable por eso uso Record y no creo una clase
public class Ingreso{

    private int dni;
    private String motivo;
    private LocalTime hora;
    private boolean autorizado;

    public Ingreso(int dni, String motivo, LocalTime hora, boolean autorizado){

        this.dni = dni;
        this.motivo = motivo;
        this.hora = hora;
        this.autorizado = autorizado;

    }

    public int getDni() {
        return dni;
    }

    public String getMotivo() {
        return motivo;
    }

    public LocalTime getHora() {
        return hora;
    }

    public boolean getAutorizado(){
        return autorizado;
    }

    public String toString(){
        return "[DNI: "+dni+", Motivo: "+ motivo + ", Hora: "+hora+", Autorizado: "+ autorizado + "]";
    }
}
