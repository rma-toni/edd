package tp3.ex02;

//Dado un arreglo de números enteros (positivos, negativos y ceros), se desea invertir únicamente los
//números negativos. Para la inversión se debe utilizar una pila y se debe mantener el resto del arreglo sin
//modificaciones.

import helper.Helper;
import helper.Stack;

import java.util.Random;

public class ex02 {

    public static void main(String[] args) {

        Random rand = new Random();
        int cantidad = Helper.getInteger("Ingrese la cantidad de numeros que contendra la pila: ");
        Stack<Integer> pilaNumeros = new Stack<>(cantidad);

        //RELLENAR STACK
        for (int i = 0; i < cantidad; i++) {
            pilaNumeros.push(rand.nextInt(201) - 100);
        }

        System.out.println(pilaNumeros.toString());

        invertirNegativos(pilaNumeros);

        System.out.println(pilaNumeros.toString());
    }

    public static void invertirNegativos(Stack<Integer> original){
        int cantidad = original.size();
        Stack<Integer> copia = new Stack<>(cantidad);
        Stack<Integer> negativos = new Stack<>(cantidad);

        //region SEPARAR NEGATIVOS
        for (int i = 0; i < cantidad; i++) {
            int numero = original.pop();
            if (numero < 0) {
                negativos.push(numero);
            }
            copia.push(numero);
        }
        //endregion

        //region INVERTIR NEGATIVOS
        int cantidadNegativos = negativos.size();
        Stack<Integer> auxiliar = new Stack<>(cantidadNegativos);
        for (int i = 0; i < cantidadNegativos; i++) {
            auxiliar.push(negativos.pop());
        }
        //endregion

        //region RECONSTRUIR ORIGINAL
        for (int i = 0; i < cantidad; i++) {
            int numero = copia.pop();
            if (numero < 0){
                original.push(auxiliar.pop());
            }else{
                original.push(numero);
            }
        }
        //endregion
    }

}
