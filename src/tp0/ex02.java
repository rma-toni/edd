package tp0;

import java.util.Scanner;

public class ex02 {

    public static void main(String[] args) {
        System.out.println("--LANZAMIENTO DE DADOS--");
        int lanzamientos = ingresoDatos();

        //int randomNumber = ((int) (Math.random() * 6)) + 1;

        while(lanzamientos > 0){
            lanzamientos = lanzamientos - 1;
        }
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
}
