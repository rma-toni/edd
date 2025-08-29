package tp1.ex05;

//TODO toString

public class Vehiculo {
    private String marca;
    private String modelo;
    private int anio;
    private int precio;

    public Vehiculo(){
        this.marca = "Sin Marca";
        this.modelo = "Sin Modelo";
        this.anio = 0;
        this.precio = 0;
    }

    public Vehiculo(String marca, String modelo, int anio, int precio){
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precio = precio;
    }

    public int getAntiguedad(int anioActual){
        return anioActual - anio;
    }

    public String obtenerDescripcionBasica(){
        return "Marca: "+marca+", Modelo: "+modelo+", Año: "+anio+", Precio: "+precio+". ";
    }
}
