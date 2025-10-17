package tp5.ex04;

//Crear la clase CitaMedica con los atributos: numeroCita, paciente, medico, fecha, especialidad y
//confirmada(boolean). Además, crear la clase SistemaCitas y cargar una serie de citas en una lista usando
//SimpleLinkedList<CitaMedica>, luego implementar los siguientes métodos:
//a) agregarCita(CitaMedica cita): agrega una cita al final de la lista.
//b) confirmarCita(int numeroCita): marca una cita como confirmada.
//c) citasPorMedico(String medico): devuelve una nueva lista con las citas de un médico específico
//d) citasConfirmadas(): muestra solo las citas confirmadas.
//e) cancelarCita(int numeroCita): elimina la cita de la lista.
//f) proximasCitas(String paciente): devuelve una lista con las citas futuras de un paciente.

import helper.Helper;
import helper.SimpleLinkedList;

import java.time.LocalDate;

public class ex04 {
    static void main() {

        SistemaCitas sistemaCitas = new SistemaCitas();

        //------- AGREGAMOS UNOS CUANTOS PARA ACELERAR LAS PRUEBAS
        sistemaCitas.agregarCita(new CitaMedica(1, "Juan Pérez", "Carlos Gómez", LocalDate.now(), "Medicina General", false));
        sistemaCitas.agregarCita(new CitaMedica(2, "María López", "Andrea Torres", LocalDate.now().plusDays(2), "Pediatría", false));
        sistemaCitas.agregarCita(new CitaMedica(3, "Luis Fernández", "Julio Sánchez", LocalDate.of(2025, 11, 1), "Dermatología", false));
        sistemaCitas.agregarCita(new CitaMedica(4, "Ana Ruiz", "Patricia Díaz", LocalDate.now().plusWeeks(1), "Cardiología", false));
        sistemaCitas.agregarCita(new CitaMedica(5, "Pedro Gómez", "Mario Vargas", LocalDate.of(2025, 12, 15), "Traumatología", false));
        sistemaCitas.agregarCita(new CitaMedica(6, "Carla Jiménez", "Enrique Molina", LocalDate.now().plusDays(10), "Ginecología", false));
        sistemaCitas.agregarCita(new CitaMedica(7, "Roberto Sánchez", "Lucía Herrera", LocalDate.of(2025, 10, 25), "Oftalmología", false));
        sistemaCitas.agregarCita(new CitaMedica(8, "Daniel Castro", "Jorge Ramírez", LocalDate.now().plusDays(3), "Neurología", false));
        sistemaCitas.agregarCita(new CitaMedica(9, "Lucía Vega", "Sofía Navarro", LocalDate.of(2025, 11, 20), "Endocrinología", false));
        sistemaCitas.agregarCita(new CitaMedica(10, "Andrés Morales", "Ricardo Peña", LocalDate.now().plusMonths(1), "Psiquiatría", false));

        int option;
        while (true){
            System.out.println("1 - Agregar cita");
            System.out.println("2 - Confirmar cita");
            System.out.println("3 - Mostrar citas por medico");
            System.out.println("4 - Mostrar citas confirmadas");
            System.out.println("5 - Cancelar cita");
            System.out.println("6 - Mostrar proximas citas del paciente");
            System.out.println("7 - Mostrar todas las citas");
            System.out.println("0 - Salir");
            option = Helper.getInteger("Ingrese la opcion elegida: ");

            switch (option){
                case 1:
                    sistemaCitas.agregarCita(crearCita());
                    System.out.println("CITA CREADA!");
                    break;
                case 2:
                    int numeroCita = Helper.getInteger("Ingrese el numero de la cita a confirmar: ");
                    if (sistemaCitas.confirmarCita(numeroCita)){
                        System.out.println("CITA CONFIRMADA!");
                    }else {
                        System.out.println("NO SE ENCONTRO LA CITA!");
                    }
                    break;
                case 3:
                    String medico = Helper.getString("Ingrese el nombre del medico: ");
                    sistemaCitas.citasMedico(medico);
                    break;
                case 4:
                    sistemaCitas.citasConfirmadas();
                    break;
                case 5:
                    int numeroCitaCancelar = Helper.getInteger("Ingrese el numero de la cita a cancelar: ");
                    if (sistemaCitas.cancelarCita(numeroCitaCancelar)){
                        System.out.println("CITA CANCELADA!");
                    }else {
                        System.out.println("NO SE ENCONTRO LA CITA!");
                    }
                    break;
                case 6:
                    String paciente = Helper.getString("Ingrese el nombre del peciente: ");
                    SimpleLinkedList<CitaMedica> proximasCitas = sistemaCitas.proximasCitas(paciente);
                    System.out.println(proximasCitas.toString());
                    break;
                case 7:
                    sistemaCitas.showAll();
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        }
    }

    //TODO no estamos controlando que sea una fecha pasada, si hay tiempo hacerlo.
    public static CitaMedica crearCita(){
        int numeroCita = Helper.getInteger("Ingrese el numero de la cita: ");
        String paciente = Helper.getString("Ingrese el nombre del paciente: ");
        String medico = Helper.getString("Ingrese el nombre del medico: ");
        LocalDate fecha = Helper.getLocalDate("Ingrese la fecha del turno(DD/MM/AAAA): ","/");
        String especialidad = Helper.getString("Ingrese la especialidad: ");
        return new CitaMedica(numeroCita,paciente,medico,fecha,especialidad,false);
    }
}
