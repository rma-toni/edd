package tp2.ex04;

//region INDICACIONES DEL EJERCICIO
//4) Realizar un programa que, en primer lugar, solicite al usuario una cantidad de caracteres a ingresar y luego
//haga el ingreso de cada caracter en un arreglo. Una vez cargado el arreglo, el programa debe:
//a) Obtener la cantidad de caracteres que solo aparecen una vez en el arreglo, es decir, los que no se
//repiten. Asimismo, estos caracteres deben mostrarse en pantalla.
//b) Buscar y mostrar la posición de la primera y última aparición de un carácter específico ingresado por el
//usuario.
//c) Obtener un nuevo arreglo que contenga únicamente los caracteres del arreglo inicial que son vocales.
//Luego, mostrar el arreglo resultante.
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

public class ex04 {
    public static void main(String[] args) {
        int cantidadCaracteres = Helper.getInteger("Ingrese la cantidad de caracteres a ingresar: ");
        char[] arrayCaracteres = new char[cantidadCaracteres];
    }
}
