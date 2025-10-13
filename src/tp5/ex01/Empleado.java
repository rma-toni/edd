package tp5.ex01;

import java.time.LocalDate;

public class Empleado {

    private int legajo;
    private int dni;
    private String nombre;
    private LocalDate fechaNac;
    private String email;

    public Empleado(int legajo, int dni, String nombre, LocalDate fechaNac, String email){
        this.legajo = legajo;
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "legajo=" + legajo +
                ", dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", fechaNac=" + fechaNac +
                ", email='" + email + '\'' +
                '}';
    }
}
