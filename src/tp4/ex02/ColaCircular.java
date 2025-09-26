package tp4.ex02;

public class ColaCircular<T> {
    private final T[] elementos;
    private int capacidad; //Podria ser tambien constante
    private int frente;
    private int fin;
    private int tamaño;

    public ColaCircular(int capacidad) {
        this.capacidad = capacidad;
        this.elementos = (T[]) new Object[capacidad];
        this.frente = 0;
        this.fin = -1;
        this.tamaño = 0;
    }

    // Insertar en la cola
    public boolean add(T elemento) {
        if (isFull()) {
            return false; // La cola está llena
        }
        fin = (fin + 1) % capacidad; //cuando fin + 1 sea igual a capacidad volvemos al indice 0
        elementos[fin] = elemento; //agregamos el elemento a la cola
        tamaño++; // aumentamos el tamaño
        return true;
    }

    // Extraer de la cola
    public T remove() {
        if (isEmpty()) {
            return null; // Cola vacía
        }
        T elemento = elementos[frente];
        elementos[frente] = null; // opcional: limpiar referencia
        frente = (frente + 1) % capacidad; //Lo mismo que antes
        tamaño--;
        return elemento;
    }

    public boolean isEmpty() {
        return tamaño == 0;
    }

    public boolean isFull() {
        return tamaño == capacidad;
    }

    public int size() {
        return tamaño;
    }

    // Debug opcional TODO: Aprender a usar StringBuilder
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < tamaño; i++) {
            int index = (frente + i) % capacidad;
            sb.append(elementos[index]);
            if (i < tamaño - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}