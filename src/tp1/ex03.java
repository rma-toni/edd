//TODO Completar!
package tp1;

import java.time.LocalDate;
import java.util.Scanner;

public class ex03 {
    //TODO Agregar logica secuencial para lo solicitado
    public static void main(String[] args) {

        //TODO Instanciar al menos dos licencias (datos ingresados pos Scanner)
        int day, month, year;
        String[] splitFechaE;
        String[] splitFechaV;
        String[] splitFechaC;
        LocalDate fechaE;
        LocalDate fechaV;
        LocalDate fechaC;

        int numeroLicencia;
        String tipoLicencia;
        String fechaEString = "";
        String fechaVString = "";
        String fechaConsultaString = "";

        Scanner scan = new Scanner(System.in);

        //TODO En este bloque se instancian las licencias
        //TODO Evidentemente hay mucho que simplificar, queda pendiente
        {
            System.out.println("-------- CREAR LICENCIA N° 1 --------");

            System.out.print("Ingrese el numero de Licencia: ");
            numeroLicencia = scan.nextInt();
            System.out.print("Ingrese el tipo de Licencia: ");
            tipoLicencia = scan.nextLine();

            boolean control = true;
            System.out.print("Ingrese la fecha de emisión (formato DD/MM/AAAA):");
            while (control) {
                fechaEString = scan.nextLine();
                if (validar(fechaEString)) {
                    control = false;
                } else {
                    System.out.print("Fecha incorrecta, por favor ingrese una fecha valida (formato DD/MM/AAAA):");
                }
            }

            splitFechaE = fechaEString.split("/");

            day = Integer.parseInt(splitFechaE[0]);
            month = Integer.parseInt(splitFechaE[1]);
            year = Integer.parseInt(splitFechaE[2]);

            fechaE = LocalDate.of(year, month, day);

            control = true;
            System.out.print("Ingrese la fecha de vencimiento (formato DD/MM/AAAA):");
            while (control) {
                fechaVString = scan.nextLine();
                if (validar(fechaVString)) {
                    control = false;
                } else {
                    System.out.print("Fecha incorrecta, por favor ingrese una fecha valida (formato DD/MM/AAAA):");
                }
            }

            splitFechaV = fechaVString.split("/");

            day = Integer.parseInt(splitFechaE[0]);
            month = Integer.parseInt(splitFechaE[1]);
            year = Integer.parseInt(splitFechaE[2]);

            fechaV = LocalDate.of(year, month, day);

            Licencia licencia1 = new Licencia(numeroLicencia, tipoLicencia, fechaE, fechaV);

            System.out.println("-------- CREAR LICENCIA N° 2 --------");

            System.out.print("Ingrese el numero de Licencia: ");
            numeroLicencia = scan.nextInt();
            System.out.print("Ingrese el tipo de Licencia: ");
            tipoLicencia = scan.nextLine();

            control = true;
            System.out.print("Ingrese la fecha de emisión (formato DD/MM/AAAA):");
            while (control) {
                fechaEString = scan.nextLine();
                if (validar(fechaEString)) {
                    control = false;
                } else {
                    System.out.print("Fecha incorrecta, por favor ingrese una fecha valida (formato DD/MM/AAAA):");
                }
            }

            splitFechaE = fechaEString.split("/");

            day = Integer.parseInt(splitFechaE[0]);
            month = Integer.parseInt(splitFechaE[1]);
            year = Integer.parseInt(splitFechaE[2]);

            fechaE = LocalDate.of(year, month, day);

            control = true;
            System.out.print("Ingrese la fecha de vencimiento (formato DD/MM/AAAA):");
            while (control) {
                fechaVString = scan.nextLine();
                if (validar(fechaVString)) {
                    control = false;
                } else {
                    System.out.print("Fecha incorrecta, por favor ingrese una fecha valida (formato DD/MM/AAAA):");
                }
            }

            splitFechaV = fechaVString.split("/");

            day = Integer.parseInt(splitFechaE[0]);
            month = Integer.parseInt(splitFechaE[1]);
            year = Integer.parseInt(splitFechaE[2]);

            fechaV = LocalDate.of(year, month, day);

            Licencia licencia2 = new Licencia(numeroLicencia, tipoLicencia, fechaE, fechaV);
        }

        //TODO En este bloque se crea la fecha de consulta
        {
            boolean control = true; //TODO simplificar esta variable eliminando los bloques o llevándola fuera de los bloques
            System.out.print("Ingrese la fecha de vencimiento (formato DD/MM/AAAA):");
            while (control) {
                fechaConsultaString = scan.nextLine();
                if (validar(fechaConsultaString)) {
                    control = false;
                } else {
                    System.out.print("Fecha incorrecta, por favor ingrese una fecha valida (formato DD/MM/AAAA):");
                }
            }

            splitFechaC = fechaConsultaString.split("/");

            day = Integer.parseInt(splitFechaC[0]);
            month = Integer.parseInt(splitFechaC[1]);
            year = Integer.parseInt(splitFechaC[2]);

            fechaC = LocalDate.of(year, month, day);
        }

        //TODO Logica de consulta
    }

    public static boolean validar(String fecha){
        boolean control = true;

        String[] splitFecha = fecha.split("/");
        int day = Integer.parseInt(splitFecha[0]);
        int month = Integer.parseInt(splitFecha[1]);
        //int year = Integer.parseInt(splitFecha[2]);

        // TODO Preguntar si hay que controlar año

        if(day > 31 || day < 1){
            control = false;
        } else if (month > 12 || month < 1) {
            control = false;
        }
        return control;
    }

    //TODO Implementar una metodo para transformar fechas ingresadas por el usuario o objetos LocalDate

//    i) Solicitar al usuario los datos para crear al menos dos objetos Licencia diferentes, por ejemplo: una
//    licencia vigente y una licencia vencida. Se debe realizar las validaciones correspondientes.
//    j) Después de crear las licencias, el programa debe solicitar al usuario una "fecha de consulta" (día, mes,
//    año) para verificar el estado de las licencias. Esta fecha también debe ser validada.
}


//ESTE ME