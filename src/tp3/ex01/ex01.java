package tp3.ex01;

import helper.Stack_;

import java.util.Random;

//Escribir un programa que genere 20 números aleatorios y los guarde en una pila. Luego, quitar los
//elementos de la pila y guardar los números pares en una nueva pila y los impares en otra. Calcular y
//mostrar el promedio y la suma total de los números que poseen cada una de las pilas creadas. Al finalizar el
//proceso, la pila original debe mantenerse sin modificaciones.
//Indicaciones:
//Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
//código controle los problemas que normalmente ocurren al operar con la consola o teclado.
//Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
//respecto del código que hace lo que se solicita en el ejercicio. También necesita del objeto random para
//generar valores de manera aleatoria.

public class ex01 {
    public static void main(String[] args) {
        Random rand = new Random();
        int capacidad = 20;
        Stack_<Integer> numerosAleatorios = new Stack_<>(capacidad);
        Stack_<Integer> numerosPares = new Stack_<>(capacidad);
        Stack_<Integer> numerosImpares = new Stack_<>(capacidad);

        //region RELLENAR STACK
        for (int i = 0; i < capacidad; i++) {
            try {
                numerosAleatorios.push((rand.nextInt(100)));
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
        //endregion
        System.out.println("---------- PILA ORIGINAL (ANTES)------------");
        numerosAleatorios.print();

        //region SEPARAR PARES E IMPARES
        separarParesImpares(numerosAleatorios,numerosPares,numerosImpares);
        //endregion

        //region PRINTS
        System.out.println("---------- PILA ORIGINAL (DESPUES)------------");
        numerosAleatorios.print();
        System.out.println("---------- PILA PARES------------");
        numerosPares.print();
        System.out.println("---------- PILA IMPARES------------");
        numerosImpares.print();
        //endregion
    }

    public static void separarParesImpares(Stack_<Integer> original, Stack_<Integer> pares, Stack_<Integer> impares){
        Stack_<Integer> copia = new Stack_<>(original.length());
        int capacidad = original.length();
        int numero;
        //SEPARAR NUMEROS
        for (int i = 0; i < capacidad; i++) {
            try {
                numero = original.pop();
                copia.push(numero);
                if (numero % 2 == 0){
                    pares.push(numero);
                }else{
                    impares.push(numero);
                }
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
        //RECONSTRUIR ORIGINAL
        for (int i = 0; i < capacidad; i++) {
            try {
                original.push(copia.pop());
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
    }
}
