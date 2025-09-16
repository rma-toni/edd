package tp3.ex06;

//Definir la clase Entrega con los atributos destinatario, piso y fueEntregado. Cargar una pila con varios
//objetos de tipo Entrega. Además, implementar los siguientes métodos:
//c) obtenerPendientesPorPiso(Stack <Entrega> pila, int piso): devuelve cuántas entregas pendientes hay
//en ese piso.
//d) vaciarEntregados(Stack <Entrega> pila): elimina todos los objetos que ya fueron entregados.

import helper.Helper;
import helper.Stack;

public class ex06 {

    public static void main(String[] args) {

        //default de 10 entragas
        Stack<Entrega> entregaStack = new Stack<>();

        int opcion = -1;

        while(true){
            System.out.println("----------- MENU -------------");
            System.out.println("1 - Crear entrega");
            System.out.println("0 - Salir");
            switch (opcion){
                case 1:
                    entregaStack.push(cargarEntrega());
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
        String piso = Helper.getString("Ingrese el piso: ");
        int fueEntregadoInt = Helper.getInteger("Ingrese si fue entregado (1 - Entregado , 2 - No entregado)");
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
}
