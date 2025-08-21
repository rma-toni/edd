package tp1;

import java.time.LocalDate;
import java.util.Scanner;

public class ex03 {
    //TODO Eliminar logica de menu, el ejercicio no pide eso
    //TODO Agregar logica secuencial para lo solicitado
    public static void main(String[] args) {

        //TODO Instanciar al menos dos licencias (datos ingresados pos Scanner) para probar el menu

        int option = -1;
        boolean control = true;
        Scanner scan = new Scanner(System.in);

        while(control){
            System.out.println("------------- MENU -------------");
            System.out.println("1 - Mostrar detalles de licencia.");
            System.out.println("2 - Verificar estado de licencia al dia de hoy.");
            System.out.println("3 - Verificar estado de licencia en una fecha especifica.");
            System.out.println("4 - Mostrar dias restantes de validez.");
            System.out.println("5 - Simular renovación.");
            System.out.println("6 - Salir");
            System.out.print("Ingrese la opción deseada: ");

            option = scan.nextInt();

            switch (option){
                case 1:
                    crearLicencia();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    control = false;
            }
        }
    }

    public static void crearLicencia(){
        Licencia licencia = new Licencia();
    }

    public static LocalDate validar(LocalDate fecha){
        return LocalDate.now();
    }
    //TODO Implementar una metodo para transformar fechas ingresadas por el usuario o objetos LocalDate

//    i) Solicitar al usuario los datos para crear al menos dos objetos Licencia diferentes, por ejemplo: una
//    licencia vigente y una licencia vencida. Se debe realizar las validaciones correspondientes.
//    j) Después de crear las licencias, el programa debe solicitar al usuario una "fecha de consulta" (día, mes,
//    año) para verificar el estado de las licencias. Esta fecha también debe ser validada.
}
