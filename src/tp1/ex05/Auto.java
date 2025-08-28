package tp1.ex05;

import java.util.Objects;

public class Auto extends Vehiculo{

    //TODO Controlar que no se ingresen valores negativos
    //TODO Verificar que solo se ingresen valores correctos de combustible (no se si se necesario)
    //TODO toString

    private int numeroPuertas;
    private String tipoCombustible;
    private int capacidadBaulLitros;

    public Auto(){
        super();
        numeroPuertas = 0;
        tipoCombustible = "Sin especificar";
        capacidadBaulLitros = 0;
    }

    public Auto(String marca, String modelo, int anio, int precio, int numeroPuertas, String tipoCombustible, int capacidadBaulLitros){
        super(marca,modelo,anio,precio);
        this.numeroPuertas = numeroPuertas;
        this.tipoCombustible = tipoCombustible;
        this.capacidadBaulLitros = capacidadBaulLitros;
    }

    public boolean esFamiliar(){
        return numeroPuertas == 4 || numeroPuertas == 5;
    }

    public boolean esEcoAmigable(){
        return Objects.equals(tipoCombustible, "Eléctrico") || Objects.equals(tipoCombustible, "Híbrido");
    }

    //region Setters and Getters

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public void setCapacidadBaulLitros(int capacidadBaulLitros) {
        this.capacidadBaulLitros = capacidadBaulLitros;
    }

    public int getCapacidadBaulLitros() {
        return capacidadBaulLitros;
    }
    //endregion
}
