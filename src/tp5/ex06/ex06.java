package tp5.ex06;

//TODO Hacer este

//Crear una lista que almacene N números enteros generados de manera aleatoria y desarrollar métodos que
//realicen lo siguiente:
//a) Crear una nueva lista en donde los números pares estén al principio y los números impares al final.
//b) Solicitar al usuario el ingreso de dos valores y devolver la suma de todos los elementos de la lista que
//estén entre esos dos valores.
//c) Crear una lista que almacene los números de la lista inicial de manera ordenada.+
import helper.Helper;
import helper.SimpleLinkedList;

import java.util.Random;

public class ex06 {

    static void main() {

        Random rand = new Random();
        SimpleLinkedList<Integer> randomNumbers = new SimpleLinkedList<>();
        int n = Helper.getInteger("Ingrese la cantidad de numeros enteros: ");
        for (int i = 0; i < n; i++) {
            randomNumbers.addFirst(rand.nextInt(101));
        }

        System.out.println(randomNumbers.toString());

        System.out.println("------------- LISTA ORDENADA (PARIDAD) -------------");
        SimpleLinkedList<Integer> ordParidad = ordenarParidad(randomNumbers);
        System.out.println(ordParidad.toString());

        System.out.println("------------- SUMA VALORES INTERMEDIOS -------------");
        int inf = Helper.getInteger("Ingrese el limite inferior: ");
        int sup = Helper.getInteger("Ingrese el limite superior: ");
        int sumaIntermedios = sumaValoresIntermedios(randomNumbers, inf, sup);
        System.out.println("La suma de los valores intermedios es: "+sumaIntermedios);

        System.out.println("------------- LISTA ORDENADA -------------");
        SimpleLinkedList<Integer> ordList = ordenarLista(randomNumbers);
        System.out.println(ordList.toString());
    }

    public static SimpleLinkedList<Integer> ordenarParidad(SimpleLinkedList<Integer> original){

        SimpleLinkedList<Integer> returnList = new SimpleLinkedList<>();

        for(int num : original){
            if (num % 2 == 0){
                returnList.addLast(num);
            }
        }

        for(int num : original){
            if (num % 2 != 0){
                returnList.addLast(num);
            }
        }

        return returnList;
    }

    public static int sumaValoresIntermedios(SimpleLinkedList<Integer> original, int inf, int sup){
        int returnValue = 0;

        for (int num : original){
            if (num > inf && num < sup){
                returnValue+=num;
            }
        }
        return returnValue;
    }

    public static SimpleLinkedList<Integer> ordenarLista(SimpleLinkedList<Integer> original){
        SimpleLinkedList<Integer> returnList = new SimpleLinkedList<>();
        SimpleLinkedList<Integer> copia = new SimpleLinkedList<>();

        for (int num : original) {
            copia.addLast(num);
        }

        while (copia.size() != 0){
            // Buscar el valor mínimo en la lista
            int min;
            try {
                min = copia.removeFirst();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            boolean isLesser = true;
            for (int num : copia) {
                if (num < min) {
                    isLesser = false;
                    break;
                }
            }

            if (!isLesser){
                copia.addLast(min);
            }else{
                returnList.addLast(min);
            }
        }
        return returnList;
    }
}
