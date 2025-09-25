package tp4;

//1) Realizar el ingreso de N enteros en una cola. Además, pedir al usuario el ingreso de un número que será
//considerado como máximo. Los elementos de la cola que excedan el valor máximo deberán ser retirados y
//reubicados al final de la misma. Mostrar los elementos de la cola después de realizada la reubicación.
//Contar y mostrar la cantidad de números de la cola que no superen al máximo ingresado por el usuario.
//Finalmente, crear una nueva cola que solo contenga aquellos números que no superen al máximo
//ingresado.

import helper.Helper;
import helper.Queue;

public class ex01 {

    public static void main(String[] args) {

        //region CARGA DE DATOS
        int cantidad = 0;
        int numero;
        while (cantidad <= 0){
            cantidad = Helper.getInteger("Ingrese la cantidad de numeros que desea ingresar: ");
            if (cantidad <= 0){
                System.out.println("Ingrese un numero mayor a 0.");
            }
        }
        Queue<Integer> queue = new Queue<>(cantidad);
        for (int i = 0; i < cantidad; i++) {
            numero = Helper.getInteger("Ingrese el valor numero "+(i+1)+": ");
            try {
                queue.add(numero);
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
        int maximo = Helper.getInteger("Ingrese el valor maximo: ");
        //endregion

        //region ORDENAR
        System.out.println("---------- ANTES DE ORDENAR ----------");
        System.out.println(queue.toString()); //Queue antes de ordenar
        ordenarMaximo(queue, maximo);
        System.out.println("---------- DESPUES DE ORDENAR ----------");
        System.out.println(queue.toString()); //Queue despues de ordenar
        System.out.println("La cantidad de numeros que nos superan al maximo es igual a "+contarMenoresIguales(queue,maximo));
        System.out.println("---------- NUEVA QUEUE MENORES/IGUALES ----------");
        Queue<Integer> queueMenoresIguales = crearColaMenoresIguales(queue, maximo);
        System.out.println(queueMenoresIguales.toString()); //Queue despues de ordenar
        //endregion
    }

    public static void ordenarMaximo(Queue<Integer> queue, int maximo){
        //NOTA: se va a usar un estructura auxiliar
        //NOTA: si no usamos una estructura auxiliar tendriamos que usar algun ordenamiento pero con varios recorridos
        //sobre la cola, no es optimo
        int cantidad = queue.size();
        int numero;
        Queue<Integer> auxiliar = new Queue<>(cantidad);

        for (int i = 0; i < cantidad; i++) {
            try{
                numero = queue.remove();
                if (numero < maximo) {
                    queue.add(numero);
                }else {
                    auxiliar.add(numero);
                }
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }

        int cantidadMayores = auxiliar.size();
        for (int i = 0; i < cantidadMayores; i++) {
            try {
                queue.add(auxiliar.remove());
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
    }

    public static int contarMenoresIguales(Queue<Integer> queue, int maximo){
        int cantidad = queue.size();
        int numero;
        int contador = 0;

        for (int i = 0; i < cantidad; i++) {
            try{
                numero = queue.remove();
                if (numero <= maximo){
                    contador++;
                }
                queue.add(numero);
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }

        return contador;
    }

    public static Queue<Integer> crearColaMenoresIguales(Queue<Integer> queue, int maximo){
        int cantidad = queue.size();
        int numero;
        Queue<Integer> queueMenores = new Queue<>(cantidad);

        for (int i = 0; i < cantidad; i++) {
            try{
                numero = queue.remove();
                if (numero <= maximo){
                    queueMenores.add(numero);
                }
                queue.add(numero);
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }

        return queueMenores;
    }
}
