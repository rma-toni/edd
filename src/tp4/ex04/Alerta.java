package tp4.ex04;

//Escribir un programa para gestionar una cola de alertas meteorológicas. Cada alerta debe representarse
//mediante un objeto con los campos: ciudad, tipo (como “tormenta”, “viento”, “granizo”), y nivel de
//severidad (entre 1 y 5).

//TODO Tipos especificos

public class Alerta {

    private String ciudad;
    private String tipo;
    private int nivelSeveridad;

    public Alerta(String ciudad, String tipo, int nivelSeveridad){
        this.ciudad = ciudad;
        this.tipo = tipo;
        this.nivelSeveridad = nivelSeveridad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getTipo() {
        return tipo;
    }
    public int getNivelSeveridad() {
        return nivelSeveridad;
    }
}
