package tp5.Pruebas;


import helper.*;

import java.util.Random;



public class main {

    public static void main(String[] args) {
        Random rand = new Random();
        SimpleLinkedList<Integer> numeros = new SimpleLinkedList<>();

        int n = Helper.getInteger("Ingrese cantidad de valores de la lista: ");
        while(n < 2 ){
            System.out.println("La lista debe ser mayor a dos valores para poder ejecutar el programa");
            n = Helper.getInteger("Ingrese cantidad de valores de la lista: ");
        }

        //cargar lista
        for(int i=0;i<n;++i){
            int num = rand.nextInt(100);
            numeros.addLast(num);
        }
        System.out.println("Lista original: "+numeros);

        // Metodo que ya muestra por pantalla la lista editada
        numImparesPares(numeros);

        // Suma de valores de un intervalo
        System.out.println("Ingrese valores a sumar del intervalo [x1,x2]");

        int x1 = Helper.getInteger("ingrese valor minimo: ");
        int x2 = Helper.getInteger("Ingrese valor maximo: ");
        while(x1 > x2){
            System.out.println("El valor minimo no puede ser mayor. Intentelo de nuevo");
            x1 = Helper.getInteger("ingrese valor minimo: ");
            x2 = Helper.getInteger("Ingrese valor maximo: ");
        }
        int suma = sumaIntervalo(numeros,x1,x2);
        System.out.println("suma del intervalo propuesto es: "+suma);

        // Nueva lista con los igual a la original
        SimpleLinkedList<Integer> nuevaLista = mismaLista(numeros);
        System.out.println("Nueva lista igual a lista original ingresada: "+nuevaLista);

    }
    public static void numImparesPares(SimpleLinkedList<Integer> numeros){
        SimpleLinkedList<Integer> paresImpares = new SimpleLinkedList<>();

        for(int num:numeros){
            if(num %2 == 0){
                paresImpares.addFirst(num);
            }else{
                paresImpares.addLast(num);
            }
        }
        System.out.println("Lista con numeros pares al principio y Impares al final: "+paresImpares);
    }
    public static int sumaIntervalo(SimpleLinkedList<Integer> numeros,int x1,int x2){
        int suma = 0;
        for(int num: numeros){
            if(num >= x1 && num <= x2){
                suma += num;
            }
        }
        return suma;
    }
    public static SimpleLinkedList<Integer> mismaLista(SimpleLinkedList<Integer> numeros){
        SimpleLinkedList<Integer> nuevaLista = new SimpleLinkedList<>();
        SimpleLinkedList<Integer> aux = new SimpleLinkedList<>();
        for(int num:numeros){
            aux.addLast(num);
        }
        for(int num:aux){
            nuevaLista.addLast(num);
        }
        return nuevaLista;
    }

}
