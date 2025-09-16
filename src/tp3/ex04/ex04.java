package tp3.ex04;

import helper.Stack;
import tp1.Helper;

import java.util.Objects;

//TODO Probar que funcione jejejejejejje

public class ex04 {
    public static void main(String[] args) {
        //Tamaña por default
        Stack<Evento> eventoStack = new Stack<>();
        int option = -1;
        while (true){
            System.out.println("----------- MENU ------------");
            System.out.println("1 - Crear evento");
            System.out.println("2 - Eliminar eventos por tipo");
            System.out.println("3 - Buscar evento por codigo");
            System.out.println("4 - Cantidad de eventos del tipo error");
            System.out.println("0 - Salir");
            option = Helper.getInteger("Ingrese la opcion deseada: ");
            switch (option){
                case 1:
                    eventoStack.push(crearEvento());
                    break;
                case 2:
                    String tipo = Helper.getString("Ingrese el tipo de los eventos que desea eliminar: ");
                    elimnarEventosDeTipo(eventoStack, tipo);
                    break;
                case 3:
                    int codigo = Helper.getInteger("Ingrese el codigo a buscar: ");
                    buscarEventoPorCodigo(eventoStack,codigo);
                    break;
                case 4:
                    System.out.println("Cantidad de eventos de tipo error: "+contarErrores(eventoStack));
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opcion invalida");
            }
        }
    }


    //a) registrarEvento: recibe como parámetro la pila y el evento, debe agregar el evento a la pila.
    public static void registrarEvento(Stack<Evento> eventos, Evento evento){
        eventos.push(evento);
    }


    //b) eliminarEventosDeTipo: recibe como parámetro la pila y el tipo, elimina todos los eventos del tipo
    //especificado (por ejemplo "info"). El resto de los elementos de la pila no debe alterarse.
    public static void elimnarEventosDeTipo(Stack<Evento> eventos, String tipo){
        int cantidad = eventos.size();
        Stack<Evento> auxiliar = new Stack<>(cantidad);

        for (int i = 0; i < cantidad; i++) {
            auxiliar.push(eventos.pop());
        }

        for (int i = 0; i < cantidad; i++) {
            Evento evento = auxiliar.pop();
            if (!Objects.equals(tipo, evento.getTipo())){
                eventos.push(evento);
            }
        }
    }


    //c) buscarEventoPorCodigo: recibe como parámetro la pila y un código, devuelve el primer evento que
    //coincida con el código (sin modificar la pila).
    //TODO PREGUNTA: El primer elemento de los que vamos sacando o el primer elemnto en el orden que fueron agregados al stack?
    //de momento esta construido como el primer elemento agregado al stack que coincida
    public static Evento buscarEventoPorCodigo(Stack<Evento> eventos, int codigo){
        Evento eventoRetornar = null;
        int cantidad = eventos.size();
        Stack<Evento> auxiliar = new Stack<>(cantidad);
        boolean encontrado = false;

        for (int i = 0; i < cantidad; i++) {
            auxiliar.push(eventos.pop());
        }

        for (int i = 0; i < cantidad; i++) {
            Evento evento = auxiliar.pop();
            if(evento.getCodigo() == codigo && !encontrado){
                eventoRetornar = evento;
                encontrado = true;
            }
            eventos.push(evento);
        }

        if (!encontrado){
            System.out.println("No se encontra ninguna evento con el codigo proporcionado.");
        }

        return eventoRetornar;
    }


    //d) contarErrores: recibe como parámetro la pila y devuelve cuántos eventos son del tipo "error".
    public static int contarErrores(Stack<Evento> eventos){
        int cantidadErrores = 0;
        int cantidad = eventos.size();
        Stack<Evento> auxiliar = new Stack<>(cantidad);

        for (int i = 0; i < cantidad; i++) {
            auxiliar.push(eventos.pop());
        }

        for (int i = 0; i < cantidad; i++) {
            Evento evento = auxiliar.pop();
            if (Objects.equals(evento.getTipo(), "Error")){
                cantidadErrores++;
            }
            eventos.push(evento);
        }

        return cantidadErrores;
    }

    public static Evento crearEvento(){
        String tipo = Helper.getString("Ingrese la informacion: ");
        String descripcion = Helper.getString("Ingrese la advertencia: ");
        int codigo = Helper.getInteger("Ingrese el error: ");
        return new Evento(tipo,descripcion,codigo);
    }
}
