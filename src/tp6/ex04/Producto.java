package tp6.ex04;

public class Producto implements Comparable<Producto>{
    //Cada Producto tiene un código, nombre, stock y precio.
    private int codigo;
    private String nombre;
    private int stock;
    private float precio;

    public Producto(int codigo){
        this.codigo = codigo;
        nombre = "Sin nombre";
        stock = 0;
        precio = 0;
    }

    public Producto(int codigo, String nombre, int stock, float precio){
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    @Override
    public int compareTo(Producto other) {
        return Integer.compare(this.codigo, other.codigo);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", stock=" + stock +
                ", precio=" + precio +
                "}\n";
    }
}
