package tp2.ex01;

//region INDICACIONES DEL EJERCICIO


//Ejercicios propuestos
//1) Un negocio desea almacenar los precios de los productos que tiene a la venta. Para lograrlo, primero se
//debe solicitar la cantidad de precios a ingresar, y luego, realizar la carga. A través de un menú de opciones,
//el programa debe presentar las siguientes operaciones:
//a) Calcular y mostrar la suma de todos los precios de los productos existentes. LISTO
//b) Devolver otro arreglo en el que se aplique un descuento del 15% a los precios de los productos cuyo
//valor supere un monto ingresado por el usuario. LISTO
//c) Devolver el promedio de los precios haciendo uso de un método cuyo parámetro es el arreglo original. LISTO
//d) Obtener la cantidad de productos que tienen un precio inferior a un valor ingresado por el usuario. LISTO
//Indicaciones:
//Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
//código controle los problemas que normalmente ocurren al operar con la consola o teclado.
//Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
//respecto del código que hace lo que se solicita en el ejercicio.

//endregion

import tp2.Helper;

public class ex01 {
    public static void main(String[] args) {

        //region INGRESO DE DATOS
        int cantidadPrecios = Helper.getInteger("Ingrese la cantidad de precios que desea ingresar: ");
        float[] precios = new float[cantidadPrecios];
        float[] preciosDesc;
        for(int i = 0; i < precios.length; i++){
            precios[i] = Helper.getFloat("Ingrese el precio numero "+(i+1)+": ");
        }
        //endregion

        //region MENU DE OPCIONES
        int option;
        while (true){
            System.out.println("---------- MENU ----------");
            System.out.println("1 - Calcular la suma de todos los precios.");
            System.out.println("2 - Aplicar descuento (%15) a partir de un precio ingresado.");
            System.out.println("3 - Promedio de los precios.");
            System.out.println("4 - Obtener la cantidad de productos con un precio inferior al indicado.");
            System.out.println("0 - Salir del programa");
            option = Helper.getInteger("Ingrese la opción elegida: ");
            switch (option){
                case 1:
                    System.out.println(sumaPrecios(precios));
                    break;
                case 2:
                    preciosDesc = descuento(precios);
                    break;
                case 3:
                    System.out.println("El promedio de los precios es: "+promedio(precios));
                    break;
                case 4:
                    System.out.println("La cantidad de productos que tienen un precio menor es de: "+precioInferior(precios));
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción incorrecta.");
            }
        }
        //endregion
    }

    public static float sumaPrecios(float[] precios){
        float suma = 0;
        for (float precio : precios) {
            suma += precio;
        }
        return suma;
    }

    //TODO Imprimir el nuevo array
    public static float[] descuento(float[] precios){
        float precioMinimo = Helper.getFloat("Ingrese el precio a partir del cual se aplicara el descuento (15%): ");
        float[] preciosDesc = new float[precios.length];
        float porcentajeDesc = 0.15f;
        for(int i = 0; i < precios.length; i++){
            if(precios[i] > precioMinimo){
                preciosDesc[i] = precios[i]*(1-porcentajeDesc);
            }else{
                preciosDesc[i] = precios[i];
            }
        }
        System.out.println("Descuento aplicado a los precios correspondientes!");
        return preciosDesc;
    }

    public static float promedio(float[] precios){
        float promedio = 0;
        for(float precio : precios){
            promedio+=precio;
        }
        return  promedio / precios.length;
    }

    //d) Obtener la cantidad de productos que tienen un precio inferior a un valor ingresado por el usuario.
    //Indicaciones:

    public static int precioInferior(float[] precios){
        int contador = 0;
        float precioComparar = Helper.getFloat("Ingrese el precio de consulta: ");
        for(float precio : precios){
            if(precio < precioComparar){
                contador++;
            }
        }
        return contador;
    }
}
