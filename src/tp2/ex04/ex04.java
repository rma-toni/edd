package tp2.ex04;

//region INDICACIONES DEL EJERCICIO
//4) Realizar un programa que, en primer lugar, solicite al usuario una cantidad de caracteres a ingresar y luego
//haga el ingreso de cada caracter en un arreglo. Una vez cargado el arreglo, el programa debe:
//a) Obtener la cantidad de caracteres que solo aparecen una vez en el arreglo, es decir, los que no se
//repiten. Asimismo, estos caracteres deben mostrarse en pantalla. LISTO
//b) Buscar y mostrar la posición de la primera y última aparición de un carácter específico ingresado por el
//usuario. LISTO
//c) Obtener un nuevo arreglo que contenga únicamente los caracteres del arreglo inicial que son vocales.
//Luego, mostrar el arreglo resultante. LISTO
//d) Intercambiar la posición de la primera vocal encontrada con la posición de la última consonante
//encontrada en el arreglo. Luego, mostrar el arreglo modificado. Si el arreglo no tiene vocales o
//consonantes, se debe generar un número aleatorio (entre 0 y la longitud del arreglo) y usar el caracter
//que se encuentra en esa posición para el intercambio.
//Indicaciones:Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
//código controle los problemas que normalmente ocurren al operar con la consola o teclado.
//Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
//respecto del código que hace lo que se solicita en el ejercicio.
//endregion

import tp2.Helper;

import java.util.ArrayList;
import java.util.Random;

public class ex04 {
    public static void main(String[] args) {
        int cantidadCaracteres = Helper.getInteger("Ingrese la cantidad de caracteres a ingresar: ");
        char[] arrayCaracteres = new char[cantidadCaracteres];
        for(int i = 0; i < arrayCaracteres.length; i++){
            arrayCaracteres[i] = Helper.getCharacter("Ingrese el caracter n°"+(i+1)+": ");
        }
        int cantidadUnicos = caracteresUnicos(arrayCaracteres);
        System.out.println(cantidadUnicos + " no se repiten.");
        busquedaCaracteres(arrayCaracteres);
        System.out.println();
        char[] vocales = obtenerVocales(arrayCaracteres);
        for (int i = 0; i < vocales.length; i++) {
            System.out.print(vocales[i]+" ");
        }
        System.out.println();
        char[] posicionesCambiadas = cambiarPosiciones(arrayCaracteres);
        for (char car : posicionesCambiadas) {
            System.out.print(car + " ");
        }
    }
    public static int caracteresUnicos(char[] chars){
        ArrayList<Character> unicos = new ArrayList<>();
        int contadorUnicos = 0;
        int contadorRep = 0;
        for(int i = 0; i < chars.length; i++){
            contadorRep = 0;
            for (int j = 0; j < chars.length; j++) {
                if(chars[i] == chars[j]){
                    contadorRep++;
                }
            }
            if(contadorRep == 1){
                unicos.add(chars[i]);
                contadorUnicos++;
            }
        }
        System.out.println("------ SOLO SE REPITEN UNA VEZ ------");
        for(char caracter : unicos){
            System.out.print(caracter + "  ");
        }
        System.out.println();
        return  contadorUnicos;
    }

    public static void busquedaCaracteres(char[] chars){
        System.out.println("------ BUSCAR UN CARACTER ------");
        char caracterBuscar = Helper.getCharacter("Ingrese el caracter que desea buscar: ");
        int contadorApariciones = 0;
        int primeraPosicion = 0;
        int ultimaPosicion = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == caracterBuscar){
                contadorApariciones++;
                if (contadorApariciones == 1){
                    primeraPosicion = i+1;
                }
                ultimaPosicion=i+1;
            }
        }
        if (primeraPosicion == 0){
            System.out.println("El caracter no aparece en el Array");
        } else if (primeraPosicion == ultimaPosicion){
            System.out.println("El caracter solo aparece una vez en la posicion "+ultimaPosicion);
        } else {
            System.out.println("La primera aparicion del caracter es en la posicion "+primeraPosicion);
            System.out.println("La ultima aparicion del caracter es en la posicion "+ultimaPosicion);
        }
    }

    public static char[] obtenerVocales(char[] chars){
          System.out.println("------ ARRAY DE VOCALES ------");
          char[] vocales = {'a','e','i','o','u'};
          ArrayList<Character> vocalesAL = new ArrayList<>();
          for(char caracter : chars){
              for(char vocal : vocales){
                if(caracter == vocal){
                    vocalesAL.add(caracter);
                }
              }
          }

        char[] arregloChar = new char[vocalesAL.size()];
        for (int i = 0; i < vocalesAL.size(); i++) {
            arregloChar[i] = vocalesAL.get(i);
        }

        return arregloChar;
    }

    public static char[] cambiarPosiciones(char[] chars) {
        System.out.println("------ CAMBIAR POSICIONES ------");
        System.out.println();
        char[] returnArray = new char[chars.length];
        char[] vocales = {'a', 'e', 'i', 'o', 'u'};
        int indicePrimerVocal = -1;
        int indiceUltimaConsonante = -1;
        for (int i = 0; i < chars.length; i++) {
            boolean esVocal = false;
            for (char vocal : vocales) {
                if (vocal == chars[i]) {
                    esVocal = true;
                    if (indicePrimerVocal == -1) indicePrimerVocal = i;
                    break;
                }
            }

            if (!esVocal) {
                indiceUltimaConsonante = i;
            }
        }

        if(indicePrimerVocal == -1 && indiceUltimaConsonante == -1){
            System.out.println("El array esta vació");
        }else if(indicePrimerVocal == -1){
            Random random = new Random();
            int numero = random.nextInt(chars.length);
            System.out.println("El numero random es: "+numero);
            char ultimaConsonante = chars[indiceUltimaConsonante];
            char primerVocal = chars[numero];
            for (int i = 0; i < chars.length; i++) {
                if(i == numero){
                    returnArray[i] = ultimaConsonante;
                }else if(i == indiceUltimaConsonante){
                    returnArray[i] = primerVocal;
                }else{
                    returnArray[i] = chars[i];
                }
            }
        } else if (indiceUltimaConsonante == -1) {
            Random random = new Random();
            int numero = random.nextInt(chars.length);
            System.out.println("El numero random es: "+numero);
            char ultimaConsonante = chars[numero];
            char primerVocal = chars[indicePrimerVocal];
            for (int i = 0; i < chars.length; i++) {
                if(i == indicePrimerVocal){
                    returnArray[i] = ultimaConsonante;
                }else if(i == numero){
                    returnArray[i] = primerVocal;
                }else{
                    returnArray[i] = chars[i];
                }
            }
        } else{
            char primerVocal = chars[indicePrimerVocal];
            char ultimaConsonante = chars[indiceUltimaConsonante];
            for (int i = 0; i < chars.length; i++) {
                if(i == indicePrimerVocal){
                    returnArray[i] = ultimaConsonante;
                }else if(i == indiceUltimaConsonante){
                    returnArray[i] = primerVocal;
                }else{
                    returnArray[i] = chars[i];
                }
            }
        }
        return returnArray;
    }
}
