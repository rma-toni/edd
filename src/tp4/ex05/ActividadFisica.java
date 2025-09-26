package tp4.ex05;

//Se desea procesar una cola de registros de actividad física de distintos usuarios. Cada registro tiene:
//nombre del usuario, cantidad de pasos, calorías quemadas y tipo de actividad (caminar, correr o bicicleta).
//El programa debe permitir consultar el total de calorías quemadas para un tipo de actividad elegido por el
//usuario, identificar cuál fue el usuario con más pasos acumulados, y contar cuántas actividades registró un
//usuario determinado. Al finalizar el proceso la cola debe permanecer sin alteraciones.

import tp1.ex05.Camion;

public class ActividadFisica{

    private String usuario;
    private int pasos;
    private int calorias;
    private String actividad;

    public ActividadFisica(String usuario, int pasos, int calorias, String actividad){
        this.usuario = usuario;
        this.pasos = pasos;
        this.calorias = calorias;
        this.actividad = actividad;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getPasos() {
        return pasos;
    }

    public int getCalorias() {
        return calorias;
    }

    public String getActividad() {
        return actividad;
    }

    public String toString(){

        return "[Usuario: "+usuario+", Cantidad de pasos: "+ pasos + ", Calorias quemadas: "+ calorias +", Actividad: "+ actividad + "]";

    }

}