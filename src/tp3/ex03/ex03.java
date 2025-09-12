package tp3.ex03;

//Dada una pila cargada con N números enteros generados de manera aleatoria, implementar lo siguiente:
//a) Un método que reciba como parámetro una pila de enteros y dos números. El método debe eliminar
//los elementos menores al primer parámetro y los mayores al segundo parámetro. Los demás
//elementos deben mantenerse en la pila en el mismo orden.
//b) Un método que duplique los números pares que se encuentren en la pila manteniéndose los demás sin
//alteraciones.
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
            pilaNumeros.push(rand.nextInt(201) - 100); //-100 a 100
        }
    }
}
