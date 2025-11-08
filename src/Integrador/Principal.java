package Integrador;

//TODO guardar en arrayList los codigos por que se puede usar contains

import helper.Helper;
import org.w3c.dom.html.HTMLBRElement;

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
            System.out.println("------- DEBUG OPTIONS -----------");
            System.out.println("11 - Add books for debug");
            System.out.println("12 - Add users for debug");
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
                    gestor.prestamo();
                    break;
                case 6:
                    gestor.devolucion();
                    break;
                case 11:
                    gestor.addDebugDataBooks();
                    break;
                case 12:
                    gestor.addDebugDataUsers();
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
