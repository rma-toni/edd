package tp5.ex05;

//Crear una clase Estudiante con los atributos lu, nombre, apellido, nota1, nota2 y nota3. Luego, crear una
//lista simple o doble que almacene objetos Estudiante. A continuación, desarrollar métodos para:
//a) Calcular y mostrar la nota promedio de cada estudiante de la lista.
//b) Devolver el estudiante con la nota promedio más alta.
//c) Crear una nueva lista que contenga a los estudiantes que aprobaron con una nota promedio mayor o
//igual a 6.

import helper.SimpleLinkedList;

public class ex05 {

    static void main() {

        SimpleLinkedList<Estudiante> estudiantes = new SimpleLinkedList<>();

        estudiantes.addLast(new Estudiante(1001, "Juan", "Perez", 7,8,3));
        estudiantes.addLast(new Estudiante(1002, "Maria", "Gonzalez", 9, 6, 8));
        estudiantes.addLast(new Estudiante(1003, "Carlos", "Ramirez", 5, 7, 6));
        estudiantes.addLast(new Estudiante(1004, "Lucia", "Torres", 10, 9, 10));
        estudiantes.addLast(new Estudiante(1005, "Andres", "Lopez", 4, 6, 5));

        for (Estudiante estudiante : estudiantes){
            System.out.println(estudiante.getNombre() + " : " + estudiante.promedio());
        }

        System.out.println("------- MEJOR PROMEDIO ---------");
        System.out.println(mejorPromedio(estudiantes).toString());
        System.out.println("------- PROMEDIO MAYOR O IGUAL A 6 ---------");
        helper.SimpleLinkedList<Estudiante> aprobados = mayorIgualSeis(estudiantes);

        for (Estudiante estudiante : aprobados){
            System.out.println(estudiante.toString());
        }

    }

    public static Estudiante mejorPromedio(SimpleLinkedList<Estudiante> estudiantes){
        Estudiante mejorProm = null;

        for (Estudiante estudiante : estudiantes){
            if (mejorProm == null){
                mejorProm = estudiante;
            } else if (mejorProm.promedio() < estudiante.promedio()){
                mejorProm = estudiante;
            }
        }
        return mejorProm;
    }

    public static SimpleLinkedList<Estudiante> mayorIgualSeis(SimpleLinkedList<Estudiante> estudiantes){
        SimpleLinkedList<Estudiante> returnList = new SimpleLinkedList<>();

        for (Estudiante estudiante : estudiantes){

            if (estudiante.promedio() >= 6){
                returnList.addLast(estudiante);
            }

        }

        return returnList;
    }

}
