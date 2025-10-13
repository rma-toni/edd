package tp5.ex01;

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

import java.time.LocalDate;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ex01 {

    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    static void main() {

        SimpleLinkedList<Empleado> debugList = new SimpleLinkedList<>();
        Random rand = new Random();


        debugList.addLast(new Empleado(1001,1,"Juan", LocalDate.of(1999,11,13), "juan@gmail.com"));
        debugList.addLast(new Empleado(1002,2,"Ana", LocalDate.of(1989,10,13), "juan@gmail.com"));
        debugList.addLast(new Empleado(1003,3,"Gabriel", LocalDate.of(2002,3,13), "juan@gmail.com"));
        debugList.addLast(new Empleado(1004,4,"Marco", LocalDate.of(2005,2,13), "juan@gmail.com"));
        debugList.addLast(new Empleado(1005,5,"Maria", LocalDate.of(1994,7,13), "juan@gmail.com"));

        while (true){
            System.out.println("------------ MENU ------------");
            System.out.println(debugList.toString());
            System.out.println("1 - Agregar elemento en una posicion especifica.");
            System.out.println("2 - Eliminar elemento en una posicion especifica.");
            System.out.println("0 - Salir.");

            int option = Helper.getInteger("Ingrese la opcion elegida: ");
            int index;
            switch (option){
                case 1:
                    Empleado item = crearEmpleado();
                    index = Helper.getInteger("Ingrese la posicion en la que desea agregarlo: ");
                    try {
                        debugList.addAt(index,item);
                    }catch (Exception e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    index = Helper.getInteger("Ingrese la posicion a eliminar: ");
                    debugList.removeAt(index);
                    break;
                case 0:

                    return;
            }
        }
    }

    public static Empleado crearEmpleado(){
        int legajo  = Helper.getInteger("Ingrese el legajo: ");
        int dni = Helper.getInteger("Ingrese el dni: ");
        String nombre = Helper.getString("Ingrese el nombre: ");
        LocalDate fechaNac = Helper.getLocalDate("Ingrese la fecha (DD/MM/AAAA)","/");
        String email = Helper.getString("Ingrese el email: ");
        while(!esEmailValido(email)){
            email = Helper.getString("Ingrese un email valido: ");
        }
        return new Empleado(legajo,dni,nombre,fechaNac,"");
    }


    public static boolean esEmailValido(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
