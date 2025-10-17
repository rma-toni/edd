package tp5.ex08;

import helper.SimpleLinkedList;

public class Stack<ELEMENT> {

    private SimpleLinkedList<ELEMENT> data;

    public Stack(){
        data = new SimpleLinkedList<>();
    }

    public void push(ELEMENT element) {
        this.data.addLast(element);
    }

    public ELEMENT pop(){
        if (this.size() <= 0) {
            throw new IllegalStateException("Cola vacía ...");
        }
        return  this.data.removeLast();
    }

    public int size(){
        return this.data.size();
    }

    public ELEMENT peek(){
        ELEMENT returnValue = data.removeLast();
        data.addLast(returnValue);
        return returnValue;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
