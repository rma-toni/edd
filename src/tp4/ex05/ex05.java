package tp4.ex05;

//Se desea procesar una cola de registros de actividad física de distintos usuarios. Cada registro tiene:
//nombre del usuario, cantidad de pasos, calorías quemadas y tipo de actividad (caminar, correr o bicicleta).
//El programa debe permitir consultar el total de calorías quemadas para un tipo de actividad elegido por el
//usuario, identificar cuál fue el usuario con más pasos acumulados, y contar cuántas actividades registró un
//usuario determinado. Al finalizar el proceso la cola debe permanecer sin alteraciones.

//TODO Validar que la cola no este vacia
//TODO en usuarios con mas pasos implementar la logica necesario para el caso en el que el usuario tenga mas de una actividad
//TODO esto se puede hacer usando una cola auxiliar pero buscar metodos mas optimos

import helper.Helper;
import helper.Queue;

public class ex05 {

    public static void main(String[] args) {

        int opcion;
        Queue<ActividadFisica> actividadesFisicas = new Queue<>(100);

        while (true){
            System.out.println("1 - Agregar activiad fisica.");
            System.out.println("2 - Mostrar cantidad de calorias quemadas para un tipo de actividad.");
            System.out.println("3 - Mostrar usuario que mas pasos acumulo.");
            System.out.println("4 - Contar actividades que registro un usuario determinado.");
            System.out.println("0 - Salir");
            opcion = Helper.getInteger("Ingrese la opcion elegida: ");
            switch (opcion){
                case 1:
                    try {
                        actividadesFisicas.add(crearActividad());
                    }catch (IllegalStateException e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    int caloriasQuemadas = cantidadCaloriasQuemadas(actividadesFisicas);
                    System.out.println("La cantidad de calorias quemadas para esta actividad es de "+caloriasQuemadas);
                    break;
                case 3:
                    String usuario = usuarioConMasPasos(actividadesFisicas);
                    System.out.println("El usuario que mas pasos acumulo es "+usuario);
                    break;
                case 4:
                    int cantidadActividades = contarActividadesUsuario(actividadesFisicas);
                    System.out.println("El usuario registro "+ cantidadActividades + " actividades");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("La opcion ingresada es invalida.");
            }
        }

    }

    public static ActividadFisica crearActividad(){
        String usuario = Helper.getString("Ingrese el nombre del usuario: ");
        int cantidadPasos = Helper.getInteger("Ingrese la cantidad de pasos: ");
        while (cantidadPasos < 0){
            System.out.println("Ingrese una cantidad de pasos valida.");
            cantidadPasos = Helper.getInteger("Ingrese la cantidad de pasos: ");
        }
        int calorias = Helper.getInteger("Ingrese la cantidad de calorias quemadas: ");
        while (calorias < 0){
            System.out.println("Ingrese una cantidad de calorias valida.");
            calorias = Helper.getInteger("Ingrese la cantidad de calorias quemadas: ");
        }
        String actividad = Helper.getString("Ingrese la actividad que realizo: ");

        return new ActividadFisica(usuario, cantidadPasos, calorias, actividad);
    }

    public static int cantidadCaloriasQuemadas(Queue<ActividadFisica> actividades){
        int contadorCalorias = 0;
        int cantidad = actividades.size();
        ActividadFisica actividad;

        for (int i = 0; i < cantidad; i++) {

            try {
                actividad = actividades.remove();

                contadorCalorias += actividad.getCalorias();

                actividades.add(actividad);
            }catch (Exception e){
                System.err.println(e.getMessage());
            }

        }

        return contadorCalorias;
    }

    public static String usuarioConMasPasos(Queue<ActividadFisica> actividades){
        String usuario = null;
        int pasosMax = 0;
        int cantidad = actividades.size();
        ActividadFisica actividad;

        for (int i = 0; i < cantidad; i++) {

            try {
                actividad = actividades.remove();

                if (actividad.getPasos() > pasosMax){
                    pasosMax = actividad.getPasos();
                    usuario = actividad.getUsuario();
                }

                actividades.add(actividad);
            }catch (Exception e){
                System.err.println(e.getMessage());
            }

        }

        return usuario;
    }

    public static int contarActividadesUsuario(Queue<ActividadFisica> actividades){
        String usuario = Helper.getString("Ingresea el usuario: ");
        int cantidad = actividades.size();
        ActividadFisica actividad;
        int cantidadActividades = 0;

        for (int i = 0; i < cantidad; i++) {

            try {
                actividad = actividades.remove();

                if (actividad.getUsuario().equals(usuario)){
                    cantidadActividades++;
                }

                actividades.add(actividad);
            }catch (IllegalStateException e){
                System.err.println(e.getMessage());
            }

        }

        return cantidadActividades;
    }
}
