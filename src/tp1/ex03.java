//TODO Completar!
package tp1;

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
    }

    //Agrege a la clase Helper dos metodos para ayudar con el input de String y LocalDate
    //TODO Completar local date, de momento solo devuelve LocalDate.now()
    static Licencia crearLicencia(){
        int numeroLicencia = Helper.getInteger("Ingrese el numero de licencia: ");
        String tipoLicencia = Helper.getString("Ingrese el tipo de licencia: ");
        LocalDate emision = Helper.getLocalDate("Ingrese la fecha de emision: ","/");
        LocalDate vencimiento = Helper.getLocalDate("Ingrese la fecha de vencimiento: ","/");
        return new Licencia(numeroLicencia,tipoLicencia,emision,vencimiento);
    }
}



//---------- MAIN ---------

//En el programa principal (main) se debe:
//LISTO i) Solicitar al usuario los datos para crear al menos dos objetos Licencia diferentes, por ejemplo: una
//licencia vigente y una licencia vencida.
//TODO i) Se debe realizar las validaciones correspondientes.
//TODO j) Después de crear las licencias, el programa debe solicitar al usuario una "fecha de consulta" (día, mes,
//año) para verificar el estado de las licencias. Esta fecha también debe ser validada.
//Para cada objeto Licencia creado, el programa debe:
//TODO k) Mostrar sus detalles utilizando el método toString().
//TODO l) Llamar al método estaVigente() pasándole la "fecha de consulta" y mostrar el resultado.
//TODO m) Llamar al método calcularDiasRestantesOVencidos() pasándole la misma "fecha de consulta" y mostrar
//la cantidad de días restantes o vencidos.
//TODO n) Solicitar al usuario una cantidad de años para simular una renovación, llamar al método
//simularRenovacion() y mostrar la nueva fecha de vencimiento calculada (sumar fechas).