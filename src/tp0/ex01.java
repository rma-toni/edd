package tp0;

//NOTA MUY IMPORTANTE
//NO FUE PROBADO TODAVIA JEJE SALU2

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
            float valorConvertido = 0;
            switch (option){
                case 1:
                    valorConvertido = convertirLongitud(scan);
                    System.out.println("El resultado es : "+valorConvertido);
                    break;
                case 2:
                    valorConvertido = convertirTemperatura(scan);
                    System.out.println("El resultado es : "+valorConvertido);
                    break;
                case 3:
                    System.out.println("Gracias por usar este software! :D");
                    return;
                default:
                    System.out.println("Opcion Incorrecta");
            }
        }
    }

    public static float convertirLongitud(Scanner scan){
        System.out.println("Se ingreso al conversor de Longitud: ");
        System.out.println("Opcion 1 = Convertir de Centimetros a Pulgadas.");
        System.out.println("Opcion 2 = Convertir de Pulgadas a Centimetros.");
        int option = 0;
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

        float valorConvertir;
        float valorConvertido = 0.0f;

        switch (option) {
            case 1:
                System.out.print("Ingrese el valor en Centimetros a convertir: ");
                valorConvertir = scan.nextFloat();
                valorConvertido = valorConvertir * (1.0f/2.54f);
                break;
            case 2:
                System.out.print("Ingrese el valor en Pulgadas a convertir: ");
                valorConvertir = scan.nextFloat();
                valorConvertido = valorConvertir * (1.0f/2.54f);
                break;
            default:
                System.out.println("Opcion invalida");
        }

        return valorConvertido;
    }

    public static float convertirTemperatura(Scanner scan){
        System.out.println("Se ingreso al conversor de Temperaturas: ");
        System.out.println("Opcion 1 = Convertir de C° a F°.");
        System.out.println("Opcion 2 = Convertir de F° a C°.");
        int option = 0;
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

        float valorConvertir;
        float valorConvertido = 0.0f;

        switch (option) {
            case 1:
                System.out.print("Ingrese el valor en C° a convertir: ");
                valorConvertir = scan.nextFloat();
                valorConvertido = (valorConvertir*1.8f)+32;
                break;
            case 2:
                System.out.print("Ingrese el valor en F° a convertir: ");
                valorConvertir = scan.nextFloat();
                valorConvertido = (valorConvertir-32.0f) / 1.8f;
                break;
            default:
                System.out.println("Opcion invalida");
        }

        return valorConvertido;
    }

}
