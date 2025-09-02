package tp2.ex03;

//3) Crear un programa para la gestión de pedidos. En primer lugar, solicitar la cantidad de pedidos a gestionar.
//Para cada pedido, el usuario debe ingresar un código de pedido y su estado actual, el cual puede ser:
//"Pendiente", "Procesando", "Enviado" o "Entregado". Estos datos deben almacenarse en arreglos paralelos
//(uno para el código y otro para el estado). El programa debe:
//a) Buscar un código de pedido específico y, si lo encuentra, mostrar su estado actual y su posición en el
//arreglo.
//b) Obtener la cantidad de pedidos que se encuentran en un estado particular (ej. "Pendiente"), ingresado
//por el usuario.
//c) Solicitar al usuario el ingreso de un estado y devolver un arreglo que contenga los códigos de pedidos
//que corresponden a ese estado.
//d) Reorganizar el arreglo (intercambiando elementos) de manera que todos los pedidos "Pendientes" se
//muevan al inicio del arreglo, manteniendo su orden relativo. Mostrar el arreglo de códigos de pedidos y
//sus estados después de esta operación.
//Indicaciones:
//Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
//código controle los problemas que normalmente ocurren al operar con la consola o teclado.
//Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
//respecto del código que hace lo que se solicita en el ejercicio.

import tp2.Helper;

public class ex03 {
    public static void main(String[] args) {
        int cantidadPedidos = Helper.getInteger("Ingrese la cantidad de pedidos a ingresar: ");
        String[] codigoPedido = new String[cantidadPedidos];
        String[] estadoPedido = new String[cantidadPedidos];
        cargarDatos(codigoPedido,estadoPedido);
    }

    public static void cargarDatos(String[] codigos, String[] estados){
        
    }
}
