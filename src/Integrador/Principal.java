package Integrador;

import helper.Helper;
import org.w3c.dom.html.HTMLBRElement;

public class Principal {
    //region Console App
    static void main() {
        int option;
        GestorBiblioteca gestor = new GestorBiblioteca();
        while (true){
            System.out.println("1 - Mostrar Libros");
            System.out.println("2 - Mostrar Usuarios");
            System.out.println("3 - Agregar libro");
            System.out.println("4 - Crear usuario");
            System.out.println("5 - Prestar libro");
            option = Helper.getInteger("Ingrese la opción elegida: ");
            switch (option){
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
