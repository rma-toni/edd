package helper;

public class Stack_<T> {
    private T[] elements;
    private int position;
    private int capacity;

    public Stack_(int capacity){
        this.capacity = capacity;
        this.elements = (T[]) new Object[capacity];
        this.position = -1;
    }

    public void push(T element) throws Exception{
        if (isFull()) {
            throw new Exception("Stack is full");
        }
        elements[++position] = element;
    }

    public T pop() throws Exception{
        if (isEmpty()){
            throw new Exception("Stack is empty");
        }
        return elements[position--];
    }

    public T peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }
        return elements[position];
    }

    public boolean isFull(){
        return position == capacity - 1;
    }

    public boolean isEmpty(){
        return position == -1;
    }

    public int length(){
        return position+1;
    }

    public void print(){
        if (isEmpty()){
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Contenido de la pila: ");
        for (int i = 0; i < length(); i++) {
            if (i == length()-1){
                System.out.print(elements[i]);
            }else{
                System.out.print(elements[i]+", ");
            }
        }
        System.out.println();
    }
}
