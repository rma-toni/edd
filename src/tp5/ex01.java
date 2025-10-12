package tp5;

//1) Dada la implementación de Lista Enlazada Simple estudiada en clases, agregarle métodos genéricos que
//permitan:
//a) Agregar un elemento en una posición ingresada por el usuario.
//b) Eliminar un elemento ubicado en una posición ingresada por el usuario.
//De manera que, estos dos nuevos métodos deberán quedar incluidos en la clase SimpleLinkedList.
//Controlar los casos en donde la lista está vacía o el valor ingresado está fuera de los límites de la misma.
//Comprobar el correcto funcionamiento de los métodos propuestos creando una lista que contenga objetos
//de la clase Empleado, la cual posee un legajo, dni, nombre, fecha de nacimiento y correo electrónico.
//Cargar la lista con varios empleados y mediante un menú, mostrar al usuario las opciones para agregar o
//eliminar un empleado de la misma.

import helper.SimpleLinkedList;
import helper.Helper;

import java.util.Random;

public class ex01 {

    static void main() {

        SimpleLinkedList<Integer> debugList = new SimpleLinkedList<>();
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            debugList.addLast(rand.nextInt(101));
        }

        while (true){
            System.out.println("------------ MENU ------------");
            System.out.println(debugList.toString());
            System.out.println("1 - Agregar elemento en una posicion especifica.");
            System.out.println("0 - Salir.");

            int option = Helper.getInteger("Ingrese la opcion elegida: ");

            switch (option){
                case 1:
                    System.out.println("En desarrollo.");
                    break;
                case 0:
                    return;
            }
        }
    }

}
