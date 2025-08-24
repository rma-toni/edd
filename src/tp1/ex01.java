package tp1;

import java.util.Scanner;

public class ex01 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        float ancho = getFloat("Ingrese el ancho del Rectangulo: ");
        float alto = getFloat("Ingrese el ancho del Rectangulo: ");

        Rectangulo rect = new Rectangulo(ancho, alto);
        System.out.println("El area del rectangulo es de: " + rect.getArea());
        System.out.println("El perimetro del rectangulo es de: " + rect.getPerimetro());
    }

    static float getFloat(String inputMsg){
        float returnValue = -1.0f;
        while(returnValue < 0.0f){
            returnValue = Helper.getFloat(inputMsg);
            if(returnValue < 0.0f){
                System.out.println("Ingrese un valor positivo");
            }
        }
        return returnValue;
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
