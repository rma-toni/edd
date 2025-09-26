package tp4.ex06;

//Se debe implementar un sistema para registrar accesos a una zona restringida. Cada intento de ingreso se
//representa con un registro que contiene: dni, motivo de ingreso, hora y si fue autorizado o no. El programa
//debe procesar la cola de registros, y devolver una nueva cola que contenga aquellos registros que no
//fueron autorizados. Luego, debe mostrar cuántos accesos corresponden a un motivo particular ingresado
//por el usuario y verificar, ingresando el dni, si una persona ingresó correctamente (devuelve true si la
//persona ingresó con autorización).

import helper.Helper;
import helper.Queue;

import java.time.LocalTime;

//TODO Tratar excepciones en los metodos que no son el main
//TODO cambiar tipo de excepcion

public class ex06 {


    public static void main(String[] args) {

        int opcion;
        Queue<Ingreso> ingresos = new Queue<>(100);

        while (true){
            System.out.println("1 - Crear registro");
            System.out.println("2 - Procesar registros");
            System.out.println("3 - Mostras registros que corresponden a un motivo.");
            System.out.println("4 - Buscar por DNI si una persona ingreso correctamente.");
            System.out.println("0 - Salir");
            opcion = Helper.getInteger("Ingrese la opcion elegida: ");
            switch (opcion){
                case 1:
                    try{
                        ingresos.add(crearIngreso());
                    }catch (Exception e){
                        System.err.println(e.toString());
                    }
                    break;
                case 2:
                    Queue<Ingreso> noAutorizados = buscarNoAutorizados(ingresos);
                    System.out.println(noAutorizados.toString());
                    break;
                case 3:
                    mostrarCantidadIngresosMotivo(ingresos);
                    break;
                case 4:
                    boolean ingresoValido = verificarIngresoDNI(ingresos);
                    if (!ingresoValido){
                        System.out.println("El DNI ingresado registra al menos un ingreso invalido");
                    }else{
                        System.out.println("El DNI ingresado no registra ingresos invalidos");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("La opcion ingresada es invalida.");
            }
        }

    }

    public static Ingreso crearIngreso(){
        int dni = Helper.getInteger("Ingrese el dni de la persona: ");
        String motivo = Helper.getString("Ingrese el motivo de ingreso: ");
        LocalTime horario = Helper.getLocalTime();
        Boolean autorizado = Helper.getBoolean("El ingreso es autorizado?: "); //TODO Helper
        return new Ingreso(dni, motivo, horario, autorizado);
    }

    public static Queue<Ingreso> buscarNoAutorizados(Queue<Ingreso> queue){
        int cantidad = queue.size();
        Queue<Ingreso> noAutorizados = new Queue<>(cantidad);
        Ingreso ingreso;

        for (int i = 0; i < cantidad; i++) {
            try {
                ingreso = queue.remove();
                if (!ingreso.getAutorizado()){
                    noAutorizados.add(ingreso);
                }
                queue.add(ingreso);//vuelvo a agregar el ingreso por que necesitare la cola para otras cosas
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
        return noAutorizados;
    }

    public static void mostrarCantidadIngresosMotivo(Queue<Ingreso> queue){
        String motivoBusqueda = Helper.getString("Ingrese el motivo a partir del cual se realizara la busqueda: ");
        int cantidad = queue.size();
        int contador = 0;
        Ingreso ingreso;

        for (int i = 0; i < cantidad; i++) {
            ingreso = queue.remove();
            if (ingreso.getMotivo().equals(motivoBusqueda)){
                contador++;
            }
            queue.add(ingreso);
        }

        System.out.println("La cantidad de ingresos que corresponden al motivo es de "+contador);
    }

    //Verificar el primer ingreso si el dni esta repetido?
    //O verificar si alguno de todos los ingresos es invalido <--- lo hicimos de esta forma, sin importar la cantidad de ingresos invalidos
    public static boolean verificarIngresoDNI(Queue<Ingreso> queue){
        boolean ingresoValido = true; //Var que se retorna
        int DNI = Helper.getInteger("Ingrese el dni a buscar: ");
        int cantidad = queue.size();
        Ingreso ingreso;

        for (int i = 0; i < cantidad; i++) {
            ingreso = queue.remove();
            if (ingreso.getDni() == DNI){
                if (!ingreso.getAutorizado()){
                    ingresoValido = false;
                }
            }
            queue.add(ingreso);
        }

        return ingresoValido;
    }
}

