package tp3.ex04;

public class Evento {
    private String tipo;
    private String descripcion;
    private int codigo;

    public Evento(){
        tipo = null;
        descripcion = null;
        codigo = 0;
    }

    public Evento(String info, String descripcion, int codigo){
        this.tipo = info;
        this.descripcion = descripcion;
        this.codigo = codigo;
    }

    //region GETTERS

    public String getTipo() {
        return tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    //endregion
}

//4) Implementar la clase Evento que posea los siguientes atributos: tipo (info, advertencia, error), descripción y
//codigo. Utilizar una pila para almacenar los eventos recientes del sistema. El programa debe implementar
//los siguientes métodos:
//a) registrarEvento: recibe como parámetro la pila y el evento, debe agregar el evento a la pila.
//b) eliminarEventosDeTipo: recibe como parámetro la pila y el tipo, elimina todos los eventos del tipo
//especificado (por ejemplo "info"). El resto de los elementos de la pila no debe alterarse.
//c) buscarEventoPorCodigo: recibe como parámetro la pila y un código, devuelve el primer evento que
//coincida con el código (sin modificar la pila).
//d) contarErrores: recibe como parámetro la pila y devuelve cuántos eventos son del tipo "error".