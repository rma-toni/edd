package tp0;


import java.util.Scanner;

public class ex01 {

    public static void main(String[] args) {

        ingresoDatos();

    }

    public static void ingresoDatos(){
        int option = -1;
        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.println("Opcion 1 = Convertir Longitudes.");
            System.out.println("Opcion 2 = Convertir Temperaturas.");
            System.out.println("Opcion 3 = Salir.");
            System.out.print("Ingrese la opcion elegida: ");
            boolean control = true;
            while(control){
                try{
                    option = scan.nextInt();
                    control = false;
                } catch (Exception e) {
                    System.err.print("Valor invalido, por favor ingrese un valor valido: ");
                    scan.nextLine();
                }
            }

            switch (option){
                case 1:
                    convertirLongitud();
                    break;
                case 2:
                    convertirTemperatura();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opcion Incorrecta");
            }
        }
    }

    public static void convertirLongitud(){
        System.out.println("Se ingreso al conversor de Longitud");
    }

    public static void convertirTemperatura(){
        System.out.println("Se ingreso al conversor de Temperatura");
    }

}
