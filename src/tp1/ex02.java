package tp1;

//TODO realizar comprobaciones de tipos con try and catch al momento del input

import java.util.Scanner;

public class ex02 {
    public static void main(String[] args) {

        Producto producto1 = new Producto("Notebook",1500.0f,20);
        Scanner scan = new Scanner(System.in);
        menu(producto1, scan);

    }

    public static void menu(Producto producto, Scanner scan){
        boolean control = true;
        int option = -1;
        while(control){
            System.out.println("1 - VENDER");
            System.out.println("2 - REPONER");
            System.out.println("3 - SALIR");
            System.out.print("Ingrese el numero de la opcion elegida: ");
            option = scan.nextInt();
            int unidades;
            float venta = 0;
            switch (option){
                case 1:
                    unidades = Helper.getInteger("¿Cuantas unidades desea vender?: ");
                    venta = producto.vender(unidades);
                    if(venta == 0.0f){
                        System.out.println("No se pudo realizar la venta.");
                        System.out.println(producto.toString());
                    }else{
                        System.out.println("El total es $"+venta);
                        System.out.println(producto.toString());
                    }
                    break;
                case 2:
                    System.out.print("¿Cuantas unidades desea reponer?: ");
                    unidades = scan.nextInt();
                    producto.reponer(unidades);
                    System.out.println(producto.toString());
                    break;
                case 3:
                    System.out.println("¡Muchas Gracias!");
                    control = false;
                    break;
                default:
                    System.out.println("¡Opcion invalida!");
            }
        }
    }
}

/*
2) Crear una clase llamada Producto que modele un artículo de inventario. Esta clase debe contener los
siguientes atributos: nombre, precio y stock. La clase Producto debe implementar: LISTO
a) Constructor predeterminado que inicializa el nombre con “Desconocido”, precio y stock en 0. LISTO
b) Constructor con argumentos que permite establecer el nombre, precio y stock del producto mediante
argumentos. LISTO
c) Un método vender que simule la venta de una cierta cantidad del producto. Debe disminuir el stock y
retornar el monto total de la venta. Si la cantidad solicitada excede el stock disponible, no debe realizar LISTO
la venta y debe retornar el valor 0, además debe mostrar un mensaje de error. LISTO
d) Un método reponer que simule la reposición de stock, aumentando la cantidad disponible. LISTO
e) El método toString() que imprima en consola el nombre, precio y stock actual del producto. LISTO
En el programa principal (main) se debe:
f) Crear una instancia de Producto. LISTO
g) Inicializar el producto con algunos valores (ej. "Notebook", 1500.0, 20). LISTO
h) Permitir al usuario, a través de un menú sencillo, realizar operaciones de venta o reposición para este
producto, mostrando los detalles actualizados después de cada operación. El menú debe repetirse
hasta que el usuario decida salir.
 */
