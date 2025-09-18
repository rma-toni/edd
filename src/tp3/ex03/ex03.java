package tp3.ex03;

//Dada una pila cargada con N números enteros generados de manera aleatoria, implementar lo siguiente:
//TODO Cantidad orignial puede user un atributo de clase

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

        System.out.println("-------- ELIMINAR ELEMENTOS --------");
        int menor = Helper.getInteger("Ingrese el primer numero: ");
        int mayor = Helper.getInteger("Ingrese el segundo numero: ");
        eliminarElementos(pilaNumeros, menor, mayor);
        System.out.println(pilaNumeros.toString());
        System.out.println("-------- DUPLICAR PARES --------");
        duplicarPares(pilaNumeros);
        Stack<Integer> pilaNumeros2 = duplicarPares(pilaNumeros);
        System.out.println(pilaNumeros.toString());
        System.out.println(pilaNumeros2.toString());
        System.out.println("-------- INTERCAMBIAR PRIMERO Y ULTMO --------");
        intercambiarPrimeroUltimo(pilaNumeros);
        System.out.println(pilaNumeros.toString());
        System.out.println("-------- COMPARAR MITADES --------");
        System.out.println(compararMitades(pilaNumeros));
        System.out.println(pilaNumeros.toString());
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
    //alteraciones. COMPLETADO
    //TODO: Optimizar
    public static Stack<Integer> duplicarPares(Stack<Integer> original){
        int cantidadOriginal = original.size();
        Stack<Integer> auxiliar = new Stack<>(cantidadOriginal*2);
        Stack<Integer> copia = new Stack<>(cantidadOriginal);
        for (int i = 0; i < cantidadOriginal; i++) {
            int numero = original.pop();
            if (numero % 2 == 0){
                auxiliar.push(numero);
                auxiliar.push(numero);
                copia.push(numero);
            }else{
                auxiliar.push(numero);
                copia.push(numero);
            }
        }
        int copiaCantidad = auxiliar.size();
        Stack<Integer> stackFinal = new Stack<>(copiaCantidad);
        for (int i = 0; i < copiaCantidad; i++) {
            stackFinal.push(auxiliar.pop());
        }

        for (int i = 0; i < cantidadOriginal; i++) {
            original.push(copia.pop());
        }
        return stackFinal;
    }


    //c) Un método que intercambie el primer elemento (el de la base) con el último elemento de la pila (el de
    //la cima).
    public static void intercambiarPrimeroUltimo(Stack<Integer> original){
        int capacidadOriginal = original.size();
        if (capacidadOriginal == 1 ){
            System.out.println("Solo hay un elemento.");
            return;
        }
        Stack<Integer> copia = new Stack<>(capacidadOriginal);
        int primerNumero = 0;
        int ultimoNumero = 0;
        int numero;
        for (int i = 0; i < capacidadOriginal; i++) {
            numero = original.pop();
            if(i == 0){
                ultimoNumero = numero;
            }else if(i == capacidadOriginal-1){
                primerNumero = numero;
            }
            copia.push(numero);
        }

        for (int i = 0; i < capacidadOriginal; i++) {
            numero = copia.pop();
            if(i == 0){
                original.push(ultimoNumero);
            }else if(i == capacidadOriginal-1){
                original.push(primerNumero);
            }else{
                original.push(numero);
            }
        }
    }


    //d) Un método que compare la suma de la mitad inferior y la mitad superior de la pila devolviendo cual
    //mitad es la mayor. La pila no debe modificarse.

    //NOTA: Al dividir stacks de tamaño impar, el elemento sobrante correspende a la primer mitad.
    //      [ 30 , 5 , 22 , 65 , 95 ]
    //      [(30 , 5 , 22),(65 , 95)]
    //      PRIMERA MITAD(3) , SEGUNDA MITAD(2)
    public static String compararMitades(Stack<Integer> original){
        String returnValue;
        int cantidadOriginal = original.size();
        if (cantidadOriginal == 1){
            returnValue = "No se puede comparar mitades, solo hay un elemento";
        }else{
            Stack<Integer> copia = new Stack<>(cantidadOriginal);
            int mitad = cantidadOriginal / 2;
            int sumaPrimeraMitad = 0;
            int sumaSegundaMitad = 0;
            int numero = 0;
            for (int i = 0; i < cantidadOriginal; i++) {
                numero = original.pop();
                if (i < mitad){
                    sumaSegundaMitad+=numero;
                }else{
                    sumaPrimeraMitad+=numero;
                }
                copia.push(numero);
            }

            //REARMAR ORIGINAL
            for (int i = 0; i < cantidadOriginal; i++) {
                original.push(copia.pop());
            }

            if (sumaPrimeraMitad > sumaSegundaMitad){
                returnValue = "La suma de la PRIMERA MITAD es mayor";
            } else if (sumaPrimeraMitad < sumaSegundaMitad) {
                returnValue = "La suma de la SEGUNDA MITAD es mayor";
            } else{
                returnValue = "Iguales";
            }
        }
        return returnValue;
    }
}
