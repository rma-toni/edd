package tp0;

// Mostrar el calculo de la eficiencia

// Prevenir Errores:
// 1 - No ingreso de numeros o ingreso de negativos
// 2 - Division por cero


import java.util.Scanner;

public class ex03 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de kilometros recorridos: ");
        float km = scan.nextFloat();
        System.out.println("Ingrese la cantidad de litros de combustibles consumidos: ");
        float litros = scan.nextFloat();

        calculos(km, litros);
    }

    public static void calculos(float km, float litros){

        float eficiencia = km/litros;

        if(eficiencia >= 15.00f){
            System.out.println("Eficiencia Excelente");
        } else if (eficiencia < 15.00f && eficiencia >= 10.00f) {
            System.out.println("Eficiencia Buena");
        } else if (eficiencia < 10.00f && eficiencia >= 5.00f) {
            System.out.println("Eficiencia Regular");
        } else if (eficiencia < 5.00f && eficiencia > 0) {
            System.out.println("Eficiencia Regular");
        }
    }

}


