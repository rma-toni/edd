package tp5.ex07;

//Codificar una implementación de la clase Queue<ELEMENT> (Cola genérica) utilizando en la estructura
//interna una lista genérica. Usando dicha implementación, solicitar al usuario el ingreso de N números
//aleatorios entre 0 y 10 para luego agregarlos a la cola. Cada número representa un valor leído por un
//sensor. Cuando el valor 0 aparece, significa que el sensor se reinició. Se pide eliminar todos los 0 que
//aparecen en la cola y los valores anteriores a dicho 0. También se debe calcular el promedio de las lecturas
//válidas.
//Para la implementación de la clase, tener en cuenta los diagramas presentados. En el primer diagrama se
//muestra el campo interno “list” de la clase Queue<ELEMENT> y en el segundo se presenta los detalles de la
//clase SimpleLinkedList<ELEMENT>.

import helper.Helper;
import tp5.ex08.Stack;

import java.util.Random;

public class ex07 {
    static void main() {
        int n = Helper.getInteger("Ingrese la cantidad de numeros enteros a ingresar: ");
        Queue<Integer> queueList = new Queue<>();
        int value;
        for (int i = 0; i < n; i++) {
            value = Helper.getInteger("Ingrese un valor entre 0 y 10: ");
            while (true){
                if (value <= 10 && value >= 0){
                    break;
                }else{
                    value = Helper.getInteger("Por favor ingrese un valor entre 0 y 10:");
                }
            }

            try {
                    queueList.add(value);
            } catch (Exception e) {
                    System.err.println(e.getMessage());
            }
        }
        System.out.println(queueList.toString());

        if (!queueList.isEmpty()){
            sensorReset(queueList);
        }else {
            System.out.println("No hay valores para procesar"); //TODO Todo dentro de un while?
        }

        System.out.println(queueList.toString());
    }

    public static void sensorReset(Queue<Integer> queue){
        int count = queue.size();
        boolean cero = false;
        for (int i = 0; i < count; i++) {
            int num;
            try {
                num = queue.remove();
                if (num == 0){
                    cero = true;
                }
                queue.add(num);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        if (cero){
            System.out.println("------ REINICIANDO ------");
            try {
                int num;
                for (int i = 0; i < count; i++) {
                    num = queue.remove();
                    if (num == 0){
                        break;
                    }
                }

                count = queue.size();
                for (int i = 0; i < count; i++) {
                    num = queue.remove();
                    if (num != 0){
                        queue.add(num);
                    }
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }else{
            System.out.println("------ SIN REINICIAR ------");
        }
    }
}
