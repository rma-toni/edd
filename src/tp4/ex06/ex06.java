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



public class ex06 {


    public static void main(String[] args) {

        int opcion;
        Queue<Ingreso> ingresos = new Queue<>(100);

        while (true){
            System.out.println("1 - Crear registro");
            System.out.println("2 - Procesar registros");
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
                if (!ingreso.autorizado()){
                    noAutorizados.add(ingreso);
                }
                queue.add(ingreso);//vuelvo a agregar el ingreso por que necesitare la cola para otras cosas
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
        return noAutorizados;
    }
}

