package tp1;

//TO-DO
//1 - Try and Catch en input
//1 - Modularizar el ingreso de datos

import java.util.Scanner;

public class ex01 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        float ancho = -1.0f;
        float alto = -1.0f;

        while(ancho < 0.0f){
            System.out.print("Ingrese el ancho del Rectangulo: ");
            ancho = scan.nextFloat();
            if(ancho < 0.0f){
                System.out.println("Por favor ingrese un valor positivo.");
            }
        }
        while(alto < 0.0f){
            System.out.print("Ingrese el alto del Rectangulo: ");
            alto = scan.nextFloat();
            if(alto < 0.0f){
                System.out.println("Por favor ingrese un valor positivo.");
            }
        }

        Rectangulo rect = new Rectangulo(ancho, alto);
        System.out.println("El area del rectangulo es de: " + rect.getArea());
        System.out.println("El perimetro del rectangulo es de: " + rect.getPerimetro());
    }
}


/*
1) Diseñar una clase llamada Rectangulo que represente una figura geométrica. Esta clase debe tener los
atributos ancho y alto. La clase Rectangulo debe incluir: LISTO
a) Constructor predeterminado que inicializa ambos valores en cero. LISTO
b) Un constructor con argumentos para establecer las dimensiones (ancho y alto) del rectángulo. LISTO
c) Un método que devuelva el área del rectángulo. LISTO
d) Un método que devuelva el perímetro del rectángulo. LISTO
En el programa principal (main) se debe:
e) Crear una única instancia de la clase Rectangulo. LISTO
f) Solicitar al usuario que ingrese el ancho y el alto del rectángulo verificando que los valores sean
positivos. LISTO
g) Utilizar los métodos de la clase Rectangulo para establecer estas dimensiones. LISTO
h) Calcular y mostrar el área y el perímetro del rectángulo creado. LISTO
Indicaciones:
Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
código controle los problemas que normalmente ocurren al operar con la consola o teclado.
Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
respecto del código que hace lo que se solicita en el ejercicio.
 */
