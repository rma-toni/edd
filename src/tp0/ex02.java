package tp0;

import java.util.Scanner;

//NOTA: funciona, completar la parte en cual se calcula cuantas veces la suma fue par o impar

public class ex02 {

    public static void main(String[] args) {
        System.out.println("--LANZAMIENTO DE DADOS--");
        int lanzamientos = ingresoDatos();
        lanzarDados(lanzamientos);
    }

    public static int ingresoDatos(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de veces que quiere lanzar los dados: ");
        boolean control = true;
        int lanzamientos = 0;
        while(control){
            try {
                lanzamientos = scan.nextInt();
                control = false;
            } catch (Exception e) {
                System.err.print("Por favor ingrese un valor entero: ");
                scan.nextLine();
            }
        }
        return lanzamientos;
    }

    public static void lanzarDados(int lanzamientos){
        int suma = 0;
        float promedios = 0;
        float aux = lanzamientos;
        while(lanzamientos > 0){
            int lanzamiento = 1;
            int dado1 = ((int) (Math.random() * 6)) + 1;
            suma += dado1;
            int dado2 = ((int) (Math.random() * 6)) + 1;
            suma += dado2;
            System.out.print("Lanzamiento numero " + lanzamiento+": ");
            System.out.print("Dado 1: "+dado1+" y Dado 2: "+dado2+"\n");

            //PROMEDIOS
            promedios = suma / aux;

            lanzamientos = lanzamientos - 1;
        }
        System.out.println("La suma de los lanzamientos es igual a : "+suma);
        System.out.println("La suma promedio de cada lanzamiento es igual a : "+promedios);
    }
}
