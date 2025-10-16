//Codificar una implementación de la clase Stack<T> (Pila genérica) utilizando en la estructura interna una
//lista genérica. Usando dicha implementación cargar una pila con números enteros aleatorios y duplicar los
//valores pares de la pila. El orden de los elementos en la pila no debe alterarse.
package tp8.ex08;

import helper.Helper;
import tp5.ex08.Stack;

public class ex08 {

    public static void main() {

        int n = Helper.getInteger("Ingrese la cantidad de numeros enteros a generer: ");
        Stack<Integer> stackList = new Stack<>();

        for (int i = 0; i < n; i++) {

        }

        duplicarPares(stackList);
    }


    public static void duplicarPares(Stack<Integer> original){
        Stack<Integer> copia = new Stack<>();
        int cantidad = original.size();

        for (int i = 0; i < cantidad; i++) {
            copia.push(original.pop());
        }

        for (int i = 0; i < copia.size(); i++) {
            int num = copia.pop();
            if (num % 2 == 0){
                original.push(num*2);
            }else {
                original.push(num);
            }
        }
    }

}

