package tp1.ex05;

//TODO Validar que el usuario no ingrese un tipo de carroceria incorrecto

import java.util.Objects;

public class Camion extends Vehiculo {



    private int capacidadCarga;
    private int numeroEjes;
    private String tipoCarroceria;

    public Camion(){
        super();
        capacidadCarga = 0;
        numeroEjes = 0;
        tipoCarroceria = "Sin especificar";
    }

    public Camion(String marca, String modelo, int anio, int precio, int capacidadCarga, int numeroEjes, String tipoCarroceria){
        super(marca,modelo,anio,precio);
        this.capacidadCarga = capacidadCarga;
        this.numeroEjes = numeroEjes;
        this.tipoCarroceria = tipoCarroceria;
    }
    // Método describirCapacidadesEspeciales() que devuelve un String diferente según el
//valor de tipoCarroceria, si es "Volquete", devuelve "Ideal para movimiento de tierras y materiales a
//granel"; si es "Caja Seca", devuelve "Apto para transporte de mercancías protegidas", en cualquier otro
//casos devuelve “Útil para todo tipo de carga”.

    public boolean requiereLicenciaEspecial(){
        return numeroEjes>2;
    }

    String describirCapacidadesEspeciales(){
        String returnValue;
        if(Objects.equals(tipoCarroceria,"Volquete")){
            returnValue = "Ideal para movimiento de tierras y materiales a granel";
        } else if (Objects.equals(tipoCarroceria,"Caja Seca")) {
            returnValue = "Apto para transporte de mercancías protegidas";
        } else {
            returnValue = "Útil para todo tipo de carga";
        }
        return returnValue;
    }
    //region GETTERS AND SETTERS

    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public void setNumeroEjes(int numeroEjes) {
        this.numeroEjes = numeroEjes;
    }

    public void setTipoCarroceria(String tipoCarroceria) {
        this.tipoCarroceria = tipoCarroceria;
    }

    public int getCapacidadCarga() {
        return capacidadCarga;
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }

    public String getTipoCarroceria() {
        return tipoCarroceria;
    }

    //endregion

}
