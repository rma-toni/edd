package tp2.ex03;

//3) Crear un programa para la gestión de pedidos. En primer lugar, solicitar la cantidad de pedidos a gestionar.
//Para cada pedido, el usuario debe ingresar un código de pedido y su estado actual, el cual puede ser:
//"Pendiente", "Procesando", "Enviado" o "Entregado". Estos datos deben almacenarse en arreglos paralelos
//(uno para el código y otro para el estado). El programa debe: LISTO
//a) Buscar un código de pedido específico y, si lo encuentra, mostrar su estado actual y su posición en el
//arreglo. LISTO
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

        //region MENU
        int opcionMenu;
        while (true){
            System.out.println("--------------MENU--------------");
            System.out.println("1 - Buscar pedido por código.");
            System.out.println("0 - Salir del programa");
            opcionMenu = Helper.getInteger("Ingrese la opción seleccionada: ");
            switch (opcionMenu){
                case 1:
                    buscarPedido(codigoPedido,estadoPedido);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción invalida.");
            }
        }
        //endregion
    }

    public static void cargarDatos(String[] codigos, String[] estados){
        String codigo;
        String estado;
        int opcionCodigo;
        for(int i = 0; i < codigos.length; i++){
            //region CARGAR CODIGO
            codigo = Helper.getString("Ingrese el codigo del pedido numero "+(i+1)+": ");
            codigos[i] = codigo;
            //endregion

            //region CARGAR ESTADO
            while (true){
                System.out.println("Seleccione el estado del pedido: ");
                System.out.println("1 - Pendiente");
                System.out.println("2 - Procesado");
                System.out.println("3 - Enviado");
                System.out.println("4 - Entregado");
                opcionCodigo = Helper.getInteger("Ingrese la opción correspondiente: ");
                if(opcionCodigo == 1){
                    estado = "Pendiente";
                    break;
                } else if (opcionCodigo == 2) {
                    estado = "Procesado";
                    break;
                } else if (opcionCodigo == 3) {
                    estado = "Enviado";
                    break;
                } else if (opcionCodigo == 4) {
                    estado = "Entregado";
                    break;
                } else {
                    System.out.println("Opción invalida.");
                }
            }
            estados[i] = estado;
            //endregion
        }
    }

    public static void buscarPedido(String[] codigos, String[] estados){
        String codigoBusqueda = Helper.getString("Ingrese el código del pedido: ");
        for (int i = 0; i < codigos.length; i++){
            if(codigos[i].equals(codigoBusqueda)){
                System.out.println("Código de pedido: "+codigos[i]+", Estado: "+estados[i]+", Posición: "+(i+1));
            }
        }
    }
}
