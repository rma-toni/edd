package tp5.Pruebas;

// Crear una lista que almacene N números enteros generados de manera aleatoria y desarrollar métodos que
// realicen lo siguiente:
// a) Crear una nueva lista en donde los números pares estén al principio y los números impares al final.
// b) Solicitar al usuario el ingreso de dos valores y devolver la suma de todos los elementos de la lista que
//    estén entre esos dos valores.
// c) Crear una lista que almacene los números de la lista inicial de manera ordenada.

import helper.Helper;
import helper.SimpleLinkedList;

import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class main2{

    public static void main(String[] args) {
        Random rand = new Random();

        int n = Helper.getInteger("Ingrese la cantidad de números enteros: ");
        int minRand = 0;          // rango mínimo por defecto
        int maxRand = 100;        // rango máximo por defecto
        // Si querés que el usuario defina el rango, podés pedirlo con Helper.getInteger(...)

        SimpleLinkedList<Integer> randomNumbers = generarListaAleatoria(n, minRand, maxRand, rand);

        System.out.println("Lista original: " + listaToString(randomNumbers));

        System.out.println("------------- LISTA (PARES AL PRINCIPIO) -------------");
        SimpleLinkedList<Integer> ordParidad = ordenarParidad(randomNumbers);
        System.out.println(listaToString(ordParidad));

        System.out.println("------------- SUMA VALORES INTERMEDIOS -------------");
        int inf = Helper.getInteger("Ingrese el límite inferior: ");
        int sup = Helper.getInteger("Ingrese el límite superior: ");
        while (inf > sup) {
            System.out.println("El valor mínimo no puede ser mayor que el máximo. Inténtelo de nuevo.");
            inf = Helper.getInteger("Ingrese el límite inferior: ");
            sup = Helper.getInteger("Ingrese el límite superior: ");
        }
        int sumaIntermedios = sumaValoresIntermedios(randomNumbers, inf, sup);
        System.out.println("La suma de los valores intermedios es: " + sumaIntermedios);

        System.out.println("------------- LISTA ORDENADA (ASCENDENTE) -------------");
        SimpleLinkedList<Integer> ordList = ordenarLista(randomNumbers);
        System.out.println(listaToString(ordList));
    }

    /**
     * Genera una lista con n enteros aleatorios en [min, max], usando addLast para preservar orden.
     */
    public static SimpleLinkedList<Integer> generarListaAleatoria(int n, int min, int max, Random rnd) {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        if (max < min) { int t = min; min = max; max = t; }
        for (int i = 0; i < n; i++) {
            int val = rnd.nextInt(max - min + 1) + min;
            list.addLast(val); // mantengo orden de generación
        }
        return list;
    }

    /**
     * a) Crea y devuelve una nueva lista donde los pares están al principio y los impares al final.
     *    Mantiene el orden relativo dentro de pares y dentro de impares.
     */
    public static SimpleLinkedList<Integer> ordenarParidad(SimpleLinkedList<Integer> original) {
        SimpleLinkedList<Integer> resultado = new SimpleLinkedList<>();
        // Primero pares
        for (int num : original) {
            if (num % 2 == 0) resultado.addLast(num);
        }
        // Luego impares
        for (int num : original) {
            if (num % 2 != 0) resultado.addLast(num);
        }
        return resultado;
    }

    /**
     * b) Suma los elementos cuyo valor está entre inf y sup.
     *    Actualmente usa condición estricta: inf < x < sup (tal como tu ejemplo).
     *    Si querés que sea inclusiva cambialo a: if (num >= inf && num <= sup)
     */
    public static int sumaValoresIntermedios(SimpleLinkedList<Integer> original, int inf, int sup) {
        int suma = 0;
        for (int num : original) {
            if (num > inf && num < sup) {
                suma += num;
            }
        }
        return suma;
    }

    /*c) Devuelve una lista ordenada ascendentemente. Implementación práctica:
     *    vuelco a ArrayList, uso Collections.sort() y vuelvo a SimpleLinkedList.
     */
    public static SimpleLinkedList<Integer> ordenarLista(SimpleLinkedList<Integer> original) {
        ArrayList<Integer> aux = new ArrayList<>();
        for (int num : original) aux.add(num);
        Collections.sort(aux);
        SimpleLinkedList<Integer> sorted = new SimpleLinkedList<>();
        for (int num : aux) sorted.addLast(num);
        return sorted;
    }

    /*Forma segura de imprimir la lista (por si SimpleLinkedList no sobrescribe toString()).
     */
    public static String listaToString(SimpleLinkedList<Integer> lista) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Integer> it = lista.iterator();
        boolean first = true;
        while (it.hasNext()) {
            if (!first) sb.append(", ");
            sb.append(it.next());
            first = false;
        }
        sb.append("]");
        return sb.toString();
    }
}