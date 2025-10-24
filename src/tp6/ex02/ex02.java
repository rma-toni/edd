package tp6.ex02;

import helper.BinaryTree;

public class ex02 {
    static void main() {

        //ARBOL 1
        System.out.println("------------------ ARBOL 1 -------------------");
        //LEVEL3
        BinaryTree<Integer> AsubTree2l1 = new BinaryTree<>(20,new BinaryTree<>(10),null);
        BinaryTree<Integer> AsubTree2r1 = new BinaryTree<>(50,null,new BinaryTree<>(55));
        BinaryTree<Integer> AsubTree2l2 = new BinaryTree<>(75,null,null);
        BinaryTree<Integer> AsubTree2r2 = new BinaryTree<>(90,null,new BinaryTree<>(95));
        //LEVEL2
        BinaryTree<Integer> AsubTree1l = new BinaryTree<>(40,AsubTree2l1,AsubTree2r1);
        BinaryTree<Integer> AsubTree1r= new BinaryTree<>(80,AsubTree2l2,AsubTree2r2);
        //ROOT LEVEL1
        BinaryTree<Integer> tree1 = new BinaryTree<>(60,AsubTree1l,AsubTree1r);
        System.out.println("Parentizada: "+tree1.toString());
        System.out.print("In order: ");
        tree1.InOrder();
        System.out.print("\nIn order: ");
        tree1.PreOrder();
        System.out.print("\nPost order: ");
        tree1.PostOrder();
        System.out.print("\nDescending order: ");
        tree1.DescendingOrder();

        //ARBOL 2
        System.out.println("\n------------------ ARBOL 2 -------------------");
        //LEVEL4
        BinaryTree<Integer> BsubTree3l = new BinaryTree<>(93,null,null);
        BinaryTree<Integer> BsubTree3r = new BinaryTree<>(98,new BinaryTree<>(97),null);
        //LEVEL3
        BinaryTree<Integer> BsubTree2l1 = new BinaryTree<>(50,new BinaryTree<>(20),null);
        BinaryTree<Integer> BsubTree2r1 = new BinaryTree<>(95,BsubTree3l,BsubTree3r);
        BinaryTree<Integer> BsubTree2l2 = new BinaryTree<>(140,null,null);
        BinaryTree<Integer> BsubTree2r2 = new BinaryTree<>(180,new BinaryTree<>(160),null);
        //LEVEL2
        BinaryTree<Integer> BsubTree1l = new BinaryTree<>(90,BsubTree2l1,BsubTree2r1);
        BinaryTree<Integer> BsubTree1r= new BinaryTree<>(150,BsubTree2l2,BsubTree2r2);
        //ROOT LEVEL1
        BinaryTree<Integer> tree2 = new BinaryTree<>(100,BsubTree1l,BsubTree1r);
        System.out.println("Parentizada: "+tree2.toString());
        System.out.print("In order: ");
        tree2.InOrder();
        System.out.print("\nPre order: ");
        tree2.PreOrder();
        System.out.print("\nPost order: ");
        tree2.PostOrder();
        System.out.print("\nDescending order: ");
        tree2.DescendingOrder();
    }
}
