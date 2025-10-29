package tp6.ex05;

//Implementar la clase Pedido con los atributos: numeroPedido, nombreCliente, nombreProducto y
//cantidad. Se debe crear un programa que permita crear y guardar Pedidos en un árbol binario de búsqueda
//ordenado por nombreCliente. Mostrar el contenido del árbol según el recorrido post orden. Además, se
//debe poder modificar un pedido ingresando el nombre del cliente. Si el cliente pide eliminar el pedido este
//debe quitarse del árbol.

import helper.BinarySearchTree;
import helper.Helper;
import tp6.ex04.Producto;

public class ex05 {

    static void main() {
        BinarySearchTree<Pedido> pedidos = new BinarySearchTree<>();

        //INGRESO DE ALGUNOS VALORES DE PRUEBA
        pedidos.add(new Pedido(15,"Juan","Cigarillos",4500));
        pedidos.add(new Pedido(10,"Carlos","Cerveza",2000));
        pedidos.add(new Pedido(80,"Ana","Vino",1800));
        pedidos.add(new Pedido(50,"Maria","Galletas",1500));
        pedidos.add(new Pedido(12,"Gabriel","Aceite",4000));

        int n = Helper.getInteger("Ingrese la cantidad de pedidos a ingresar: ");
        for (int i = 0; i < n; i++) {
            pedidos.add(crearPedido());
        }

        System.out.println("-------------- POST ORDER ---------------");
        pedidos.PostOrder();

        int opcion;
        String nombreBusqueda;
        while (true){
            System.out.println("-------------- MENU ---------------");
            System.out.println("1 - Modificar Pedido.");
            System.out.println("2 - Eliminar Pedido.");
            System.out.println("3 - Mostrar Pedidos.");
            System.out.println("0 - Salir");
            opcion = Helper.getInteger("Ingrese la opcion elegida: ");
            switch (opcion){
                case 1:
                    System.out.println("-------------- MODIFICAR PEDIDO ---------------");
                    nombreBusqueda = Helper.getString("Ingrese el nombre del cliente: ");
                    modificarPedido(pedidos, nombreBusqueda);
                    break;
                case 2:
                    System.out.println("-------------- ELIMINAR PEDIDO ---------------");
                    nombreBusqueda = Helper.getString("Ingrese el nombre del cliente: ");
                    eliminarPedido(pedidos, nombreBusqueda);
                    break;
                case 3:
                    System.out.println("-------------- PEDIDOS ---------------");
                    pedidos.PostOrder();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opcion invalida.");
            }
        }

    }

    static Pedido crearPedido(){
        System.out.println("-------------- CREAR PEDIDO ---------------");
        int numeroPedido = Helper.getInteger("Ingrese el numero del pedido: ");
        String nombreCliente = Helper.getString("Ingrese el nombre del cliente: ");
        String nombreProducto = Helper.getString("Ingrese el nombre del producto: ");
        int cantidad = Helper.getInteger("Ingrese la cantidad de producto: ");
        return new Pedido(numeroPedido,nombreCliente,nombreProducto,cantidad);
    }

    static void modificarPedido(BinarySearchTree<Pedido> pedidos, String nombreCliente){
        Pedido pedidoNuevo = crearPedido();
        boolean resultado = pedidos.modificar(new Pedido(nombreCliente), pedidoNuevo);
        if (resultado) {
            System.out.println("Pedido modificado con exito.");
        }else {
            System.out.println("No se encontro ningun pedido correspondiente al nombre ingresado.");
        }
    }

    static void eliminarPedido(BinarySearchTree<Pedido> pedidos, String nombreCliente){
        Pedido pedidoEliminado = pedidos.remove(new Pedido(nombreCliente));
        if (pedidoEliminado!=null){
            System.out.println("Pedido eliminado.");
            System.out.println(pedidoEliminado);
        }else {
            System.out.println("No se encontro pedido.");
        }
    }

}
