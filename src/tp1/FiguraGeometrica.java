package tp1;

public class FiguraGeometrica {
    private String color;
    private String nombre;

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
}
