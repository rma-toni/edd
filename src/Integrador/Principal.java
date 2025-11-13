package Integrador;

//TODO Reversion de ultima operacion
//TODO Continuar en pendientes

import helper.Helper;

import java.io.Serializable;

public class Principal implements Serializable {
    //region Console App
    static void main() {
        int option;
        GestorBiblioteca gestor = new GestorBiblioteca();
        while (true){
            System.out.println("------- GESTOR BIBLIOTECA -------");
            System.out.println("1 - Mostrar Libros");
            System.out.println("2 - Mostrar Usuarios");
            System.out.println("3 - Agregar libro");
            System.out.println("4 - Crear usuario");
            System.out.println("5 - Prestar libro");
            System.out.println("6 - Devolucion de libro");
            System.out.println("7 - Mostrar Operaciones");
            System.out.println("8 - Mostrar Pendientes");
            System.out.println("9 - Procesar Pendientes");
            System.out.println("------- DEBUG OPTIONS -----------");
            System.out.println("11 - Add debug data");
            option = Helper.getInteger("Ingrese la opción elegida: ");
            switch (option) {
                case 1:
                    gestor.mostrarLibros();
                    break;
                case 2:
                    gestor.mostrarUsuarios();
                    break;
                case 3:
                    gestor.crearLibro();
                    break;
                case 4:
                    gestor.crearUsuario();
                    break;
                case 5:
                    boolean resultPrest = gestor.prestamo();
                    if (resultPrest){
                        System.out.println("Prestamo realizado!");
                    }
                    break;
                case 6:
                    boolean resultDev = gestor.devolucion();
                    if (resultDev){
                        System.out.println("Devolucion realizada!");
                    }
                    break;
                case 7:
                    gestor.mostrarOp();
                    break;
                case 8:
                    gestor.mostrarPendientes();
                    break;
                case 9:
                    gestor.procesarPendientes();
                    break;
                case 11:
                    gestor.addDebugData();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opcion incorrecta.");
            }
        }
    }
    //endregion
}
