package tp1.ex06;

public class FiguraGeometrica {
    private String color;
    private String nombre;

    public FiguraGeometrica(String color, String nombre){
        this.color = color;
        this.nombre = nombre;
    }

    //region Getters, Setters, toString
    @Override
    public String toString() {
        return "color: "+color+", nombre: "+nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //endregion

    public double calcularArea(){
        return 0;
    }

    public double calcularPerimetro(){
        return 0;
    }
}
