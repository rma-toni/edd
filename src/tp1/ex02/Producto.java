package tp1.ex02;

public class Producto {

    private String nombre;
    private float precio;
    private int stock;

    public Producto(){
        this.nombre = "Desconocido";
        this.precio = 0.0f;
        this.stock = 0;
    }

    public Producto(String nombre, float precio, int stock){
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public float vender(int cantidad){
        float total = 0.0f;
        if(cantidad <= stock){
            stock -= cantidad;
            total = cantidad * precio;
        }else{
            //System.out.println("La cantidad a vender excede el stock.");
            System.err.println("La cantidad a vender excede el stock.");
        }
        return total;
    }

    public void reponer(int cantidad){
        stock += cantidad;
        System.out.println("Reposicion de "+cantidad+" unidades completada.");
    }

    public String toString(){
        return("Producto: "+nombre+", Precio: "+precio+", Stock: "+stock+" unidades");
    }
}
