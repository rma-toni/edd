package tp3.ex05;

import helper.Helper;
import helper.Stack;

import java.util.Objects;

//5) Dada una pila de caracteres, implementar una compresión en la cual secuencias de letras consecutivas
//iguales son convertidas a una letra seguida de su cantidad.
//Por ejemplo, una pila que contiene 'a', 'a', 'a', 'b', 'b', 'c' se convierte en 'a3', 'b2', 'c1'.
//El programa debe implementar los siguientes métodos:
public class ex05 {
    public static void main(String[] args) {
        int cantidad = Helper.getInteger("Ingrese la cantidad de caracteres que desea ingresar: ");
        Stack<Character> stackCaracteres = new Stack<>(cantidad);

        for (int i = 0; i < cantidad; i++) {
            stackCaracteres.push(Helper.getCharacter("Ingrese el caracter "+(i+1)+": "));
        }

        System.out.println(stackCaracteres.toString());
        Stack<String> etiquetasGeneradas = generarEtiquetas(stackCaracteres);
        System.out.println(stackCaracteres.toString());
        System.out.println(etiquetasGeneradas.toString());
    }

    //a) generarEtiquetas(Stack <Character> pila) Devuelve una pila de String llamada etiquetas agrupando los
    //caracteres consecutivos iguales y contando su frecuencia, por ejemplo "a3", "b2", ...".
    public static Stack<String> generarEtiquetas(Stack<Character> original){
        int capacidadOriginal = original.size();
        Stack<Character> auxiliar = new Stack<>(capacidadOriginal);
        Stack<String> retorno = new Stack<>(capacidadOriginal);
        int consecutivas = 1;

        for (int i = 0; i < capacidadOriginal; i++) {
            auxiliar.push(original.pop());
        }
        
        //region Implementacion de la solucion 
        for (int i = 0; i < capacidadOriginal; i++) {
            System.out.println("DEBUG");
            char caracter = auxiliar.pop();
            original.push(caracter);
            if (i < capacidadOriginal-1 && Objects.equals(caracter, auxiliar.peek())){
                consecutivas++;
            }else{
                retorno.push(caracter+Integer.toString(consecutivas));
                consecutivas = 1;
            }
            System.out.println(original.toString());
        }
        //endregion
        return retorno;
    }

    //b) buscarEtiqueta(Stack <String> etiquetas, char letra) Retorna la etiqueta correspondiente a una letra
    //dada. Si no la encuentra devuelve null.
    public static String buscarEtiqueta(Stack <String> etiquetas, char letra){
        String valorRetorno = null;
        int capacidadEtiquetas = etiquetas.size();
        Stack<String> auxiliar = new Stack<>(capacidadEtiquetas);
        boolean encontrado = false;

        for (int i = 0; i < capacidadEtiquetas; i++) {
            auxiliar.push(etiquetas.pop());
        }

        for (int i = 0; i < capacidadEtiquetas; i++) {
            String valor = auxiliar.pop();
            if (valor.charAt(0) == letra && !encontrado){
                valorRetorno = valor;
                encontrado = true;
            }
            etiquetas.push(valor);
        }

        return valorRetorno;
    }

    //TODO Completar
    //c) expandirEtiqueta(Stack <String> etiquetas) Reconstruye la pila original a partir de la pila de etiquetas,
    //por ejemplo, si la pila de etiquetas tiene "c4", la pila debe contener 'c', 'c', 'c', 'c'.
    public static Stack<Character> expandirEtiqueta(Stack <String> etiquetas){
        
        int capacidadEtiquetas = etiquetas.size();
        Stack<String> auxiliar = new Stack<>(capacidadEtiquetas);
        int capacidadOriginal = 0;
        
        for (int i = 0; i < capacidadEtiquetas; i++) {
            String valor = etiquetas.pop();
            capacidadEtiquetas+=(valor.charAt(1) - '0');
            auxiliar.push(valor);
        }

        for (int i = 0; i < capacidadEtiquetas; i++) {
            String valor = auxiliar.pop();

        }
        
        return null;
    }
}

