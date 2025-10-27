package tp6.ex05;

public class Pedido  implements  Comparable<Pedido>{
    private int numeroPedido;
    private String nombreCliente;
    private String nombreProducto;
    private int cantidad;

    public Pedido(String nombreCliente){
        this.nombreCliente = nombreCliente;
    }

    public Pedido(int numeroPedido, String nombreCliente, String nombreProducto, int cantidad){
        this.numeroPedido = numeroPedido;
        this.nombreCliente = nombreCliente;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
    }

    @Override
    public int compareTo(Pedido other) {
        return this.nombreCliente.compareTo(other.nombreCliente);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "numeroPedido=" + numeroPedido +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", cantidad=" + cantidad +
                "}\n";
    }
}
