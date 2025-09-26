package tp4.ex03;

//Una emisora radial está procesando una secuencia de palabras recibidas desde distintos mensajes de
//oyentes. Las palabras se reciben en orden y se almacenan en una cola de tipo String. Se desea realizar un
//procesamiento del mensaje en función de la longitud de las palabras.
//A través de un programa se debe:
//Procesar la cola de entrada para dividir las palabras en tres nuevas colas:
//o Una cola de palabras cortas, aquellas que tengan de uno a tres letras.
//o Una cola de palabras medianas, aquellas que tengan de cuatro a seis letras.
//o Una cola de palabras largas, aquellas que tengan siete o más letras.
//Para cada una de estas colas, se debe:
//a) Calcular la cantidad de palabras que contiene.
//b) Determinar la palabra más larga (en cantidad de letras) de esa categoría.
//c) Reconstruir y mostrar la frase original de cada categoría, respetando el orden de llegada. PREGUNTAR

//TODO reconstruir original

import helper.Helper;
import helper.Queue;

public class ex03 {

    public static void main(String[] args) {

        int control;
        String frase;

        while (true){

            System.out.println("1 - PROCESAR UNA NUEVA FRASE");
            System.out.println("0 - SALIR");
            control = Helper.getInteger("Ingrese la opcion elegida: ");
            if (control == 1){

                frase = Helper.getString("Ingrese la frase: ");
                Queue<String> fraseQueue = cargarQueue(frase);
                System.out.println(fraseQueue.toString());

                //Procesar cola
                Queue<String> palabrasCortas = new Queue<>(fraseQueue.size());
                Queue<String> palabrasMedianas = new Queue<>(fraseQueue.size());
                Queue<String> palabrasLargas = new Queue<>(fraseQueue.size());

                procesarPalabras(fraseQueue, palabrasCortas,palabrasMedianas,palabrasLargas);

                System.out.println(palabrasCortas.toString());
                System.out.println(palabrasMedianas.toString());
                System.out.println(palabrasLargas.toString());

            }else if(control == 0){
                return;
            }else{
                System.out.println("Valor invalido.");
            }

        }
    }

    public static Queue<String> cargarQueue(String frase){
        String[] stringArray = frase.split(" ");
        Queue<String> fraseQueue = new Queue<>(stringArray.length);
        for (int i = 0; i < stringArray.length; i++) {
            try{
                fraseQueue.add(stringArray[i]);
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
        return fraseQueue;
    }

    public static void procesarPalabras(Queue<String> frase,Queue<String> cortas,Queue<String> medianas,Queue<String> largas){
        int cantidad = frase.size();

        for (int i = 0; i < cantidad; i++) {
            try {
                String palabra = frase.remove();
                if (palabra.length() <= 3){
                    cortas.add(palabra);
                } else if (palabra.length() <= 6) {
                    medianas.add(palabra);
                } else {
                    largas.add(palabra);
                }
                frase.add(palabra);
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
    }

}
