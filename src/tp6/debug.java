package tp6;

import helper.AVLTree;
import helper.BinarySearchTree;
import helper.DoubleLinkedList;

public class debug {
    static void main() {

        AVLTree<Integer> debugTree = new AVLTree<>();

        debugTree.add(56); //TODO Ejercicio 8
        debugTree.add(23);
        debugTree.add(34);
        debugTree.add(36);
        debugTree.add(31);
        debugTree.add(13);
        debugTree.add(21);
        debugTree.add(16);
        debugTree.add(11);
        debugTree.add(26);
        debugTree.add(43);

        debugTree.PreOrder();
        System.out.println();
        debugTree.InOrder();
        System.out.println();
        debugTree.PostOrder();

        /*debugTree.add(50); //TODO 9
        debugTree.add(30);
        debugTree.add(20);
        debugTree.add(40);
        debugTree.add(10);
        debugTree.add(35);
        debugTree.add(45);
        debugTree.add(55);
        debugTree.add(60);
        debugTree.add(25);
        debugTree.add(38);*/

        /*debugTree.add(80);
        debugTree.add(60);
        debugTree.add(100);
        debugTree.add(40);
        debugTree.add(120);
        debugTree.add(110);
        debugTree.add(140);
        debugTree.add(20);
        debugTree.add(115);
        debugTree.add(160);
        debugTree.add(113);
        debugTree.add(70);
        debugTree.add(10);

        debugTree.PostOrder();
        System.out.println("\n");
        debugTree.PreOrder();
        System.out.println("\n");
        debugTree.InOrder();*/

        //public ELEMENT buscar(ELEMENT item): el cual debe recorrer los nodos del árbol y devolver el item
        //que coincide con el parámetro pasado al método. En caso de no encontrarlo devuelve null.
        /*public ELEMENT buscar(ELEMENT item) {
            return buscar(this.root, item);
        }
        private ELEMENT buscar(BTNode<ELEMENT> root, ELEMENT item) {
            if (root == null) return null;
            if (root.item.equals(item)) return root.item;
            ELEMENT encontrado = buscar(root.left, item);
            if (encontrado != null) return encontrado;
            return buscar(root.right, item);
        }
        //public boolean modificar(ELEMENT item, ELEMENT nuevo): recorre el árbol buscando el nodo cuyo
        //item sea igual al primer parámetro, en caso de encontrarlo modifica este item reemplazándolo por el
        //segundo parámetro y devuelve true. En caso de no encontrarlo devuelve false.

        // Método auxiliar que busca y devuelve el nodo, no el item
        private BTNode<ELEMENT> buscarNodo(BTNode<ELEMENT> root, ELEMENT item) {
            if (root == null) return null;
            if (root.item.equals(item)) return root;
            BTNode<ELEMENT> encontrado = buscarNodo(root.left, item);
            if (encontrado != null) return encontrado;
            return buscarNodo(root.right, item);
        }
        public boolean modificar(ELEMENT item, ELEMENT nuevo) {
            BTNode<ELEMENT> nodo = buscarNodo(this.root, item);
            if (nodo != null) {
                System.out.println("Nodo encontrado: " + nodo.item + " reemplazado por: " + nuevo);
                nodo.item = nuevo;
                return true;
            }
            System.out.println("Elemento " + item + " no encontrado en el árbol.");
            return false;*/
        /*DoubleLinkedList<Integer> lista = new DoubleLinkedList<>();
        lista.addLast(1);
        lista.addLast(2);
        lista.addLast(3);
        lista.addLast(4);
        lista.addLast(5);
        System.out.println(lista.toString());
        lista.removeLastDebug();
        lista.removeLastDebug();
        lista.removeLastDebug();
        lista.removeLastDebug();
        lista.removeLastDebug();
        lista.removeLastDebug();
        System.out.println(lista.toString());*/

    }

}
