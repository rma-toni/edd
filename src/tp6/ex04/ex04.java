package tp6.ex04;

//Realizar un programa que permita guardar información de los productos que venden en una empresa.
//Cada Producto tiene un código, nombre, stock y precio. Los productos deben guardarse en un árbol binario
//de búsqueda ordenados por código. El usuario debe poder decidir cuántos productos guardar. Al terminar
//la carga, el programa debe mostrar el contenido del árbol según el recorrido pre orden y en orden.
//Además, el programa debe permitir al usuario buscar un producto según el código ingresado.

import helper.BinarySearchTree;
import helper.Helper;

public class ex04 {
    static void main() {
        BinarySearchTree<Producto> productos = new BinarySearchTree<>();

        //INGRESO DE ALGUNOS VALORES DE PRUEBA
        productos.add(new Producto(15,"Coca Cola",30,4500));
        productos.add(new Producto(10,"Galletas",15,2000));
        productos.add(new Producto(80,"Pan",13,1800));
        productos.add(new Producto(50,"Agua",22,1500));
        productos.add(new Producto(12,"Cerveza",20,4000));

        int n = Helper.getInteger("Ingrese la cantidad de productos a ingresar: ");
        for (int i = 0; i < n; i++) {
            productos.add(crearProducto());
        }
        System.out.println("-------------- PRE ORDER ---------------");
        productos.PreOrder();
        System.out.println("-------------- IN ORDER ---------------");
        productos.InOrder();

        while (true){
            System.out.println("-------------- MENU ---------------");
            System.out.println("1 - Buscar producto.");
            System.out.println("0 - Salir");
            int opcion = Helper.getInteger("Ingrese la opcion elegida: ");
            switch (opcion){
                case 1:
                    int codigoBusqueda = Helper.getInteger("Ingrese el codigo de producto a buscar: ");
                    Producto resultado = buscarProducto(productos,codigoBusqueda);
                    if (resultado != null){
                        System.out.println(resultado.toString());
                    }else{
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opcion invalida.");
            }
        }
    }

    static Producto crearProducto(){
        System.out.println("-------------- CREAR PRODUCTO ---------------");
        int codigo = Helper.getInteger("Ingrese el codigo del producto: ");
        String nombre = Helper.getString("Ingrese el nombre del producto: ");
        int stock = Helper.getInteger("Ingrese el stock del producto: ");
        float precio = Helper.getFloat("Ingrese el precio del producto: ");
        return new Producto(codigo,nombre,stock,precio);
    }

    static Producto buscarProducto(BinarySearchTree<Producto> productos, int codigo){
        return productos.Buscar(new Producto(codigo));
    }
}
