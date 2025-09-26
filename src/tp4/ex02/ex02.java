package tp4.ex02;

//2) Implementar una clase “ColaCircular” que utilice un arreglo para gestionar una cola de tamaño fijo de
//manera circular que priorice velocidad.
//Usando la cola anterior, simule que la misma está cargada con códigos de tareas pendientes a realizar. LISTO
//Varios robots atienden las tareas, para ello toman la primera tarea disponible y la procesan (sacar de la
//cola). Si la tarea tiene un código impar no puede ser procesada y debe ser enviada a otra cola para ser
//procesada por otro tipo de robot.
//Procesar la segunda cola cuando esté disponible.
//Contar cuántas tareas tienen un código impar y se encuentran en la segunda cola.

import helper.Helper;

import java.util.Random;

public class ex02 {

    public static void main(String[] args) {

        int cantidad = Helper.getInteger("Ingrese la cantidad de tareas que desea generar: ");
        ColaCircular<Integer> tareasPendientes = new ColaCircular<>(cantidad);
        ColaCircular<Integer> tareasImpares = new ColaCircular<>(cantidad);
        Random random = new Random();

        //LLENAR tareasPendientes
        for (int i = 0; i < cantidad; i++) {
            tareasPendientes.add(random.nextInt(100)+1);
        }

        System.out.println(tareasPendientes.toString());

        procesarTareasPares(tareasPendientes,tareasImpares);

        System.out.println("TAREAS PARES PROCESADAS!");

        System.out.println(tareasImpares);

        int cantidadImpares = tareasImpares.size();

        procesarTareas(tareasImpares);

        System.out.println("TAREAS IMPARES PROCESADAS!");

        System.out.println("Cantidad de tareas impares: "+cantidadImpares);
    }

    public static void procesarTareasPares(ColaCircular<Integer> original, ColaCircular<Integer> impares){
        int cantidad = original.size();
        int tareasParesProcesadas = 0;
        int numero;
        for (int i = 0; i < cantidad; i++) {
            numero = original.remove();
            if (numero % 2 != 0){
                impares.add(numero);
            }
        }
    }

    public static void procesarTareas(ColaCircular<Integer> impares){
        int cantidad = impares.size();

        for (int i = 0; i < cantidad; i++) {
            impares.remove();
        }
    }

}
