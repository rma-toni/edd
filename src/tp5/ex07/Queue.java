package tp5.ex07;

import helper.SimpleLinkedList;

public class Queue<ELEMENT> {

    private SimpleLinkedList<ELEMENT> list;
    private int dimension;
    private int count;

    public Queue(){
        list = new SimpleLinkedList<>();
        dimension = 10;
        count = 0;
    }

    public Queue(int dimension){
        list = new SimpleLinkedList<>();
        this.dimension = dimension;
        count = 0;
    }

    public boolean add(ELEMENT item){
        if (count >= dimension) {
            throw new IllegalStateException("Cola llena ...");
        }
        list.addLast(item);
        count++;
        return true;
    }

    public ELEMENT element() {

        if (this.size() <= 0) {
            throw new IllegalStateException("Cola vacía ...");
        }

        ELEMENT returnValue = list.removeFirst();
        list.addLast(returnValue);
        count++;
        return returnValue;
    }

    //encolar
    public boolean offer(ELEMENT element) {
        if (count >= dimension) {
            return false;
        }
        list.addLast(element);
        ++this.count;
        return true;
    }

    public ELEMENT peek() {
        if (this.size() <= 0) {
            return null;
        }

        ELEMENT returnValue = list.removeFirst();
        list.addLast(returnValue);

        return returnValue;
    }

    public ELEMENT pool() {
        if (this.size() <= 0) {
            return null;
        }

        ELEMENT result = this.list.removeFirst();
        --this.count;

        return result;
    }

    public ELEMENT remove() {
        if (this.size() <= 0) {
            throw new IllegalStateException("Cola vacía ...");
        }

        ELEMENT result = this.list.removeFirst();
        --this.count;

        return result;
    }

    public boolean isEmpty(){
        return this.count <= 0;
    }

    public int size(){
        return count;
    }

    public Object[] toArray() {
        Object[] result = new Object[this.count];
        int counter = 0;
        for (ELEMENT element : list){
            result[counter] = element;
            counter++;
        }
        return result;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
