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
        return  this.data.removeLast();
    }

    public int size(){
        return this.data.size();
    }

    //todo PEEK

    @Override
    public String toString() {
        return data.toString();
    }
}
