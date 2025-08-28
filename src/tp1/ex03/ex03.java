//TODO Completar!
package tp1.ex03;

import tp1.Helper;

import java.time.LocalDate;
import java.util.Scanner;

public class ex03 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("------- Crear primera licencia -------");
        Licencia licencia1 = crearLicencia();
        System.out.println(licencia1.toString());
        System.out.println("------- Crear primera licencia -------");
        Licencia licencia2 = crearLicencia();
        System.out.println(licencia2.toString());
        System.out.println("------- Fecha de consulta -------");
        LocalDate consulta = Helper.getLocalDate("Ingrese la facha que desea consultar (DD/MM/AAAA): ","/");
        //Licencia 1
        {
            //TODO Validar que no se ingrese una fecha anterior a la emision
            System.out.println("------- Resultado consulta Licencia 1 -------");
            if (licencia1.verificarVigencia(consulta)){
                System.out.println("Licencia1 se encuentra vigente");
            }else{
                System.out.println("Licencia1 NO se encuentra vigente");
            }
            if (licencia1.diasRestantes(consulta) > 0){
                System.out.println("Dias restantes hasta el vencimiento: " + licencia1.diasRestantes(consulta));
            } else if (licencia1.diasRestantes(consulta) < 0) {
                System.out.println("Dias desde el vencimiento: " + licencia1.diasRestantes(consulta));
            } else {
                System.out.println("Hoy es el ultimo dia de validez");
            }
        }
        //Licencia 2
        {
            //TODO Validar que no se ingrese una fecha anterior a la emision
            System.out.println("------- Resultado consulta Licencia 2 -------");
            if (licencia2.verificarVigencia(consulta)){
                System.out.println("Licencia2 se encuentra vigente");
            }else{
                System.out.println("Licencia2 NO se encuentra vigente");
            }
            if (licencia2.diasRestantes(consulta) > 0){
                System.out.println("Dias restantes hasta el vencimiento: " + licencia2.diasRestantes(consulta));
            } else if (licencia2.diasRestantes(consulta) < 0) {
                System.out.println("Dias desde el vencimiento: " + licencia2.diasRestantes(consulta));
            } else {
                System.out.println("Hoy es el ultimo dia de validez");
            }
        }
        //SIMULAR RENOVACION
        {
            System.out.println("------- Simular Renovaciones -------");
            int sim = Helper.getInteger("SIMULAR RENOVACION: Ingrese la cantidad de años: ");
            System.out.print("Licencia1: ");
            licencia1.simularRenovacion(sim);
            System.out.print("Licencia2: ");
            licencia2.simularRenovacion(sim);
        }
    }

    //Agrege a la clase Helper dos metodos para ayudar con el input de String y LocalDate
    static Licencia crearLicencia(){
        int numeroLicencia = Helper.getInteger("Ingrese el numero de licencia : ");
        String tipoLicencia = Helper.getString("Ingrese el tipo de licencia : ");
        LocalDate emision = Helper.getLocalDate("Ingrese la fecha de emision (DD/MM/AAAA): ","/");
        LocalDate vencimiento = Helper.getLocalDate("Ingrese la fecha de vencimiento (DD/MM/AAAA): ","/");
        return new Licencia(numeroLicencia,tipoLicencia,emision,vencimiento);
    }
}



//---------- MAIN ---------

//En el programa principal (main) se debe:
//LISTO i) Solicitar al usuario los datos para crear al menos dos objetos Licencia diferentes, por ejemplo: una
//licencia vigente y una licencia vencida.
//LISTO i) Se debe realizar las validaciones correspondientes.
//LISTO j) Después de crear las licencias, el programa debe solicitar al usuario una "fecha de consulta" (día, mes,
//año) para verificar el estado de las licencias. Esta fecha también debe ser validada.
//Para cada objeto Licencia creado, el programa debe:
//LISTO k) Mostrar sus detalles utilizando el método toString().
//LISTO l) Llamar al método estaVigente() pasándole la "fecha de consulta" y mostrar el resultado.
//LISTO m) Llamar al método calcularDiasRestantesOVencidos() pasándole la misma "fecha de consulta" y mostrar
//la cantidad de días restantes o vencidos.
//LISTO n) Solicitar al usuario una cantidad de años para simular una renovación, llamar al método
//simularRenovacion() y mostrar la nueva fecha de vencimiento calculada (sumar fechas).