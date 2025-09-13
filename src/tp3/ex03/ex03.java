package tp3.ex03;

//Dada una pila cargada con N números enteros generados de manera aleatoria, implementar lo siguiente:
//c) Un método que intercambie el primer elemento (el de la base) con el último elemento de la pila (el de
//la cima).
//d) Un método que compare la suma de la mitad inferior y la mitad superior de la pila devolviendo cual
//mitad es la mayor. La pila no debe modificarse.

import helper.Helper;
import helper.Stack;

import java.util.Random;

public class ex03 {
    public static void main(String[] args) {
        Random rand = new Random();
        int cantidad = Helper.getInteger("Ingrese la cantidad de numeros que contendra la pila: ");
        Stack<Integer> pilaNumeros = new Stack<>(cantidad);

        //RELLENAR STACK
        for (int i = 0; i < cantidad; i++) {
            pilaNumeros.push(rand.nextInt(101)); // 0 a 100
        }
        System.out.println(pilaNumeros.toString());

        //region ELIMINAR ELEMENTOS
        int menor = Helper.getInteger("Ingrese el primer numero: ");
        int mayor = Helper.getInteger("Ingrese el segundo numero: ");
        eliminarElementos(pilaNumeros, menor, mayor);
        System.out.println(pilaNumeros.toString());
        //endregion
    }

    //a) Un método que reciba como parámetro una pila de enteros y dos números. El método debe eliminar
    //los elementos menores al primer parámetro y los mayores al segundo parámetro. Los demás
    //elementos deben mantenerse en la pila en el mismo orden. COMPLETADO
    public static void eliminarElementos(Stack<Integer> original, int menor, int mayor){
        int cantidad = original.size();
        Stack<Integer> copia = new Stack<>(cantidad);
        //COPIAR STACK
        for (int i = 0; i < cantidad; i++) {
            copia.push(original.pop());
        }
        //ELIMINAR Y COMPLETAR ORIGINAL
        for (int i = 0; i < cantidad; i++) {
            int numero = copia.pop();
            if(numero > menor && numero < mayor){
                original.push(numero);
            }
        }
    }


    //b) Un método que duplique los números pares que se encuentren en la pila manteniéndose los demás sin
    //alteraciones.
    public static void duplicarPares(Stack<Integer> original){
        int contadorPares = 0;
        int cantidadOriginal = original.size();
        for (int i = 0; i < ; i++) {

        }
        Stack<Integer> nuevo =
    }
}
