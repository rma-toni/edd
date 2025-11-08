package helper;

public class pruebas {
    static void main() {

            /*BinarySearchTree<Integer> tree = new BinarySearchTree<>();

            tree.add(60);
            tree.add(40);
            tree.add(25);
            tree.add(30);
            tree.add(35);
            tree.add(38);
            tree.add(27);
            tree.add(45);
            tree.add(50);
            tree.add(48);
            tree.add(37);
            tree.add(70);

             tree.PostOrder();*/

        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        System.out.println(list.peekLast());
    }
}
