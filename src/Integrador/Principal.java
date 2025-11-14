package Integrador;

//TODO Verificar Listas enlazadas vacias

import helper.DoubleLinkedList;
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
            System.out.println("6 - Devolución de libro");
            System.out.println("7 - Mostrar Operaciones");
            System.out.println("8 - Mostrar Pendientes");
            System.out.println("9 - Procesar Pendientes");
            System.out.println("10 - Revertir ultima operacion");
            System.out.println("11 - Mostrar total de libros prestados");
            System.out.println("12 - Ver libros de un autor");
            System.out.println("13 - Buscar usuarios que igualen o superen cierta cantidad de libros prestados");
            System.out.println("------- DEBUG OPTIONS -----------");
            System.out.println("99 - Agregar datos de prueba");
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
                case 10:
                    gestor.revertir();
                    break;
                case 11:
                    System.out.println("El total de libros prestados es de "+gestor.getTotalPrestados());
                    break;
                case 12:
                    DoubleLinkedList<Libro> librosAutor = gestor.listaLibrosAutor();
                    System.out.println("-------- LIBROS DEL AUTOR ---------");
                    if (librosAutor.size() <= 0){
                        System.out.println("No se encontraron libros pertenecientes al autor");
                    }else {
                        for (Libro libro : librosAutor){
                            System.out.println(libro.toString());
                        }
                    }
                    System.out.println("-------- FIN ---------");
                    break;
                case 13:
                    DoubleLinkedList<Usuario> usuariosEncontrados = gestor.usuariosCantidadLibrosPrestados();
                    System.out.println("-------- USUARIOS ENCONTRADOS ---------");
                    if (usuariosEncontrados.size()<=0){
                        System.out.println("No se encontraron usuarios");
                    }else{
                        for (Usuario user : usuariosEncontrados){
                            System.out.println(user.toString());
                        }
                    }
                    System.out.println("-------- FIN ---------");
                    break;
                case 99:
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
