package tp2.ex02;

//region INDICACIONES DEL EJERCICIO
//2) Desarrollar un programa que solicite al usuario un valor entero N. Generar N – 1 números aleatorios y
//cargarlos en un arreglo. Luego el programa debe implementar lo siguiente: LISTO
//a) Un método que reciba como parámetro el arreglo inicial y devuelva otro arreglo que contenga los
//elementos iniciales pero ubicados una posición hacia la derecha. LISTO
//b) Un método que muestre la cantidad de números pares e impares que contiene el arreglo inicial. LISTO
//c) Un método para revertir los elementos del arreglo (el primer elemento pasa a la última posición y el
//último a la primera, el segundo elemento a la penúltima posición y viceversa, etc.). LISTO
//Indicaciones:
//Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
//código controle los problemas que normalmente ocurren al operar con la consola o teclado.
//Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
//respecto del código que hace lo que se solicita en el ejercicio. También necesita del objeto random para
//generar valores de manera aleatoria.
//endregion

import tp2.Helper;

public class ex02 {
    public static void main(String[] args) {
        int N = Helper.getInteger("Ingrese un valor entero: ");
        int[] numerosAleatorios = new int[N-1];
        for(int i = 0; i < numerosAleatorios.length; i++){
            numerosAleatorios[i] = (int) (Math.random() * 100) + 1; //Numeros aleatorios de 1 a 100
        }
        mostrarArray(numerosAleatorios);
        mostrarArray(cambioPosicionDerecha(numerosAleatorios));
        numerosPares(numerosAleatorios);
        revertirElementos(numerosAleatorios);
        mostrarArray(numerosAleatorios);
    }

    public static int[] cambioPosicionDerecha(int[] original){
        int[] nuevo = new int[original.length];
        for (int i = 0; i < nuevo.length; i++){
            if(i == (nuevo.length-1)){
                nuevo[0] = original[i];
            }else{
                nuevo[i+1] = original[i];
            }
        }
        return nuevo;
    }

    public static void numerosPares(int[] arr){
        int pares = 0;
        int impares = 0;
        for (int num : arr){
            if((num % 2) == 0){
                pares++;
            }else{
                impares++;
            }
        }
        System.out.println("Numeros pares: "+pares+", Numeros impares: "+impares);
    }

    public static void revertirElementos(int[] arr){
        int aux;
        int n = arr.length;
        for(int i = 0; i < n/2; i++){
            aux = arr[i];
            arr[i] = arr[n-1-i];
            arr[n-1-i] = aux;
        }
    }

    public static void mostrarArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(i == arr.length-1){
                System.out.print(arr[i]+".");
            }else{
                System.out.print(arr[i]+", ");
            }
        }
        System.out.println();
    } //imprime un array (int) en consola
}
