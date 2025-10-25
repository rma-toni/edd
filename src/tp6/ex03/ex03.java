package tp6.ex03;

//3) Incorporar en la clase BinarySearchTree los siguientes métodos genéricos:
//a) public ELEMENT buscar(ELEMENT item): el cual debe recorrer los nodos del árbol y devolver el item
//que coincide con el parámetro pasado al método. En caso de no encontrarlo devuelve null.
//b) public boolean modificar(ELEMENT item, ELEMENT nuevo): recorre el árbol buscando el nodo cuyo
//item sea igual al primer parámetro, en caso de encontrarlo modifica este item reemplazándolo por el
//segundo parámetro y devuelve true. En caso de no encontrarlo devuelve false.

import helper.BinarySearchTree;

public class ex03 {
    static void main() {
        //CONSTRUIMOS UN ARBOL DE PRUEBA, EL MISMO DEL EJERCICIO 1 por ejemplo
        BinarySearchTree<Integer> tree = createTree();
        System.out.println(tree.toString());
        Integer searchResult = tree.Buscar(320);
        System.out.println(searchResult);
        searchResult = tree.Buscar(700);
        System.out.println(searchResult);
        Boolean modifyResult = tree.modificar(551, 1);
        System.out.println(tree.toString());
        System.out.println(modifyResult);
    }

    public static BinarySearchTree<Integer> createTree(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(320);
        tree.add(250);
        tree.add(450);
        tree.add(130);
        tree.add(290);
        tree.add(390);
        tree.add(500);
        tree.add(90);
        tree.add(295);
        tree.add(600);
        tree.add(550);
        tree.add(580);
        return tree;
    }
}
