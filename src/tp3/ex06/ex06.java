package tp3.ex06;

//Definir la clase Entrega con los atributos destinatario, piso y fueEntregado. Cargar una pila con varios
//objetos de tipo Entrega. Además, implementar los siguientes métodos:

import helper.Helper;
import helper.Stack;

import java.util.Objects;

public class ex06 {

    public static void main(String[] args) {

        //default de 10 entragas
        Stack<Entrega> entregaStack = new Stack<>();

        int opcion = -1;

        while(true){
            System.out.println("----------- MENU -------------");
            System.out.println("1 - Crear entrega");
            System.out.println("2 - Marcar entrega como entregada");
            System.out.println("3 - Buscar envios pendientes por piso");
            System.out.println("4 - Eliminar envios entregados");
            System.out.println("5 - Mostrar todas las entregas");
            System.out.println("0 - Salir");
            opcion = Helper.getInteger("Ingrese la opcion elegida: ");
            switch (opcion){
                case 1:
                    entregaStack.push(cargarEntrega());
                    break;
                case 2:
                    String destinatario = Helper.getString("Ingrese el destinatario: ");
                    marcarComoEntregado(entregaStack, destinatario);
                    break;
                case 3:
                    int píso = Helper.getInteger("Ingrese el numero de piso: ");
                    System.out.println("La cantidad de envios pendientes es de "+obtenerPendientesPorPiso(entregaStack,píso));
                    break;
                case 4:
                    vaciarEntregados(entregaStack);
                    break;
                case 5:
                    System.out.println(entregaStack.toString());
                    break;
                case 0:
                    return;
                default:
                    System.out.println("El valor ingresado es invalido.");
            }
        }
    }

    //a) cargarEntrega(Stack <Entrega> pila, Entrega nueva): agrega una nueva entrega a la pila.
    public static Entrega cargarEntrega(){
        String destinatario = Helper.getString("Ingrese el destinatario: ");
        int piso = Helper.getInteger("Ingrese el piso: ");
        int fueEntregadoInt = Helper.getInteger("Ingrese si fue entregado (1 - Entregado , 2 - No entregado): ");
        boolean fueEntregado;
        if (fueEntregadoInt == 1){
            fueEntregado = true;
        } else if (fueEntregadoInt == 2) {
            fueEntregado = false;
        } else {
            System.out.println("Valor invalido, se asigna \"No entregado\".");
            fueEntregado = false;
        }
        return new Entrega(destinatario,piso,fueEntregado);
    }

    //b) marcarComoEntregado(Stack <Entrega> pila, String destinatario): cambia el valor de fueEntregado a
    //true para ese destinatario.
    public static void marcarComoEntregado(Stack <Entrega> pila, String destinatario){
        int cantidad = pila.size();
        Stack<Entrega> auxiliar = new Stack<>(cantidad);

        for (int i = 0; i < cantidad; i++) {
            auxiliar.push(pila.pop());
        }

        for (int i = 0; i < cantidad; i++) {
            Entrega entrega = auxiliar.pop();
            if (Objects.equals(entrega.getDestinatario(), destinatario)){
                entrega.setFueEntregado(true);
            }
            pila.push(entrega);
        }
    }

    //c) obtenerPendientesPorPiso(Stack <Entrega> pila, int piso): devuelve cuántas entregas pendientes hay
    //en ese piso.
    public static int obtenerPendientesPorPiso(Stack <Entrega> pila, int piso){
        int cantidad = pila.size();
        int cantidadPendientes = 0;
        Stack<Entrega> auxiliar = new Stack<>(cantidad);

        for (int i = 0; i < cantidad; i++) {
            auxiliar.push(pila.pop());
        }

        for (int i = 0; i < cantidad; i++) {
            Entrega entrega = auxiliar.pop();
            if (entrega.getPiso() == piso){
                if (!entrega.getFueEntregado()){
                    cantidadPendientes++;
                }
            }
            pila.push(entrega);
        }
        return cantidadPendientes;
    }


    //d) vaciarEntregados(Stack <Entrega> pila): elimina todos los objetos que ya fueron entregados.
    public static void vaciarEntregados(Stack <Entrega> pila){
        int cantidad = pila.size();
        Stack<Entrega> auxiliar = new Stack<>(cantidad);

        for (int i = 0; i < cantidad; i++) {
            auxiliar.push(pila.pop());
        }

        for (int i = 0; i < cantidad; i++) {
            Entrega entrega = auxiliar.pop();
            if (!entrega.getFueEntregado()){
                pila.push(entrega);
            }
        }
    }
}
