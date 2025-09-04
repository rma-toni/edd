package tp2.ejercicio7;

import java.time.LocalDate;
import java.util.ArrayList;

//7)Desarrollar un programa que permita organizar y gestionar diferentes eventos, controlando los
//participantes inscriptos en cada uno. Para ello, se debe crear la clase Participante con los atributos:
//idParticipante, nombre, apellido y correo electrónico. Además, se requiere otra clase llamada Evento que
//representa un acontecimiento. Esta clase debe tener los atributos: idEvento, nombreEvento, fecha, lugar, y
//un atributo para guardar varios objetos de tipo Participante llamado participantesInscriptos. El programa
//principal debe gestionar un arreglo de objetos Evento. A través de un menú, el usuario debe poder realizar
//las siguientes operaciones:
//a) Crear un nuevo evento solicitando los datos de ingreso al usuario. LISTO
//b) Inscribir un participante en un evento, para lo cual debe existir previamente un evento. LISTO
//c) Solicitar al usuario el ingreso del idEvento y mostrar todos los participantes que están inscriptos en el
//mismo. LISTO
//d) Solicitar idEvento e idParticipante para eliminar a dicho participante del evento.
//e) Obtener la cantidad de participantes en un evento dado, ingresando el nombreEvento.
//f)
//Buscar eventos por fecha: Mostrar los detalles de los eventos que coincidan.
public class Ejercicio7 {
    public static void main(String[] args) {

        ArrayList<Evento> eventos = new ArrayList<>();
        int opcionMenu;
        boolean control;

        //region MENU
        while (true){
            System.out.println("----- MENU EVENTOS -----");
            System.out.println("1 - Crear evento");
            System.out.println("2 - Inscribir participante a un evento");
            System.out.println("3 - Mostrar participantes de un evento");
            System.out.println("4 - Eliminar participante de un evento");
            System.out.println("5 - Mostrar cantidad de participantes");
            opcionMenu = Helper.getInteger("Ingrese la opción elegida (NUMERO): ");
            switch (opcionMenu){
                case 1:
                    control = eventos.add(crearEvento());
                    if (control){
                        System.out.println("Evento creado con éxito");
                    }else{
                        System.out.println("El evento no se pudo crear");
                    }
                    break;
                case 2:
                    if (eventos.isEmpty()){
                        System.out.println("Tiene que crear al menos un evento para poder agregar participantes");
                    } else {
                        inscribirParticipante(eventos);
                    }
                    break;
                case 3:
                    mostrarParticipantes(eventos);
                    break;
                case 4:
                    eliminarParticipante(eventos);
                    break;
                case 5:
                    cantidadParticipantes(eventos);
                    break;
                default:
                    System.out.println("La opción ingresada es invalida");
            }
        }
    }

    //CREAR EVENTO
    public static Evento crearEvento(){
        int idEvento = Helper.getInteger("Ingrese el ID del evento: ");
        String nombreEvento = Helper.getString("Ingrese el nombre del evento: ");
        LocalDate fecha = Helper.getLocalDate("Ingrese la fecha del evento (DD/MM/AAAA):", "/");
        String lugar = Helper.getString("Ingrese el lugar del evento: ");
        return new Evento(idEvento,nombreEvento,fecha,lugar);
    }

    public static Participante crearParticipante(){
        int idParticipante = Helper.getInteger("Ingrese el ID del participante: ");
        String nombre = Helper.getString("Ingrese el NOMBRE del participante: ");
        String apellido = Helper.getString("Ingrese el APELLIDO del participante: ");
        String correoElectronico = Helper.getString("Ingrese el EMAIL del participante: ");
        return new Participante(idParticipante,nombre,apellido,correoElectronico);
    }

    //INSCRIBIR PARTICIPANTE

    public static void inscribirParticipante(ArrayList<Evento> eventos){
        int idEvento = Helper.getInteger("Ingrese el ID del evento al que desea inscribir al participante: ");
        boolean eventoExiste = false;
        for (Evento evento : eventos){
            if(evento.getIdEvento() == idEvento){
                evento.agregarParticipante(crearParticipante());
                eventoExiste = true;
            }
        }

        if (eventoExiste){
            System.out.println("Participante agregado con éxito!");
        } else {
            System.out.println("No existe el evento correspondiente al ID ingresado");
        }
    }
    //MOSTRAR PARTICIPANTES DE UN EVENTO (ID EVENTO)
    public static void mostrarParticipantes(ArrayList<Evento> eventos){
        int idEvento = Helper.getInteger("Ingrese el ID del evento para mostrar sus participantes: ");
        boolean eventoExiste = false;
        for (Evento evento : eventos){
            if(evento.getIdEvento() == idEvento){
                System.out.println("----- PARTICIPANTES -----");
                evento.mostrarParticipantes();
                eventoExiste = true;
            }
        }
        if(!eventoExiste){
            System.out.println("El id de evento ingreso no existe.");
        }
    }
    //ELIMINAR PARTICIPANTES DE UN EVENTO (ID EVENTO, ID PARTICIPANTE)
    public static void eliminarParticipante(ArrayList<Evento> eventos){
        int idEvento = Helper.getInteger("Ingrese el ID del evento para eliminar un participante: ");
        boolean eventoExiste = false;
        for (Evento evento : eventos){
            if(evento.getIdEvento() == idEvento){
                eventoExiste = true;
                int idParticipante = Helper.getInteger("Ingrese el ID del participante que desea eliminar: ");
                evento.eliminarParticipantes(idParticipante);
            }
        }
        if (!eventoExiste){
            System.out.println("El ID ingresado no corresponde a ningún evento");
        }

    }
    //CANTIDAD DE PARTICIPANTES (NOMBRE EVENTO)
    public static void cantidadParticipantes(ArrayList<Evento> eventos){
        String nombre = Helper.getString("Ingrese el nombre del evento para mostrar la cantidad de participantes inscriptos: ");
        boolean control = false;
        for(Evento evento : eventos){
            if(evento.getNombreEvento().equals(nombre)){
                control = true;
                System.out.println("La cantidad de participantes es de  "+evento.cantidadParticipantes());
            }
        }
        if (!control){
            System.out.println("El evento no existe");
        }
    }
    //endregion
}
