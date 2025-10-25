package tp6.ex01;

//Utilizando la clase BinaryTree<T> presentada en teoría, construir un árbol binario correspondiente a la
//siguiente figura. VER TP

import helper.BinaryTree;

//A partir del árbol obtenido:
//a. Calcular la cantidad de nodos del árbol.
//b. Calcular la cantidad de hojas del árbol.
//c. Calcular la cantidad de nodos internos del árbol.
//d. Determinar el máximo nivel del árbol.
//e. Determinar la altura del árbol.
//f. Recorrer el árbol en orden descendente.
//g. Imprimir en pantalla la representación parentizada del árbol. (Pregun)

public class ex01 {

    static void main() {
        System.out.println("--------------------- ARBOL ---------------------");
        //NIVEL6
        BinaryTree<Integer> subTree5 = new BinaryTree<>(580,null,null);
        //NIVEL5
        BinaryTree<Integer> subTree4 = new BinaryTree<>(550,null,subTree5);
        //NIVEL4
        BinaryTree<Integer> subTree3 = new BinaryTree<>(600,subTree4,null);
        //NIVEL3
        BinaryTree<Integer> subTree2l1 = new BinaryTree<>(130,new BinaryTree<>(90),null);
        BinaryTree<Integer> subTree2r1 = new BinaryTree<>(290,null,new BinaryTree<>(295));
        BinaryTree<Integer> subTree2l2 = new BinaryTree<>(390,null,null);
        BinaryTree<Integer> subTree2r2 = new BinaryTree<>(500,null,subTree3);
        //NIVEL2
        BinaryTree<Integer> subTree1l = new BinaryTree<>(250,subTree2l1,subTree2r1);
        BinaryTree<Integer> subTree1r= new BinaryTree<>(450,subTree2l2,subTree2r2);
        //NIVEL1
        BinaryTree<Integer> tree = new BinaryTree<>(320, subTree1l,subTree1r);
        System.out.println("Cantidad de nodos: "+tree.NodeCount());
        System.out.println("Cantidad de hojas: "+tree.LeafCount());
        System.out.println("Cantidad de nodos internos: "+tree.InternalCount());
        System.out.println("Nivel maximo: "+tree.MaxLevel());
        System.out.println("Altura del arbol: "+tree.Height());
        tree.DescendingOrder();
        System.out.println("\n"+tree.toString());
    }
}
