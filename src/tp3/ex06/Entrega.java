package tp3.ex06;

//Definir la clase Entrega con los atributos destinatario, piso y fueEntregado. Cargar una pila con varios
//objetos de tipo Entrega. Además, implementar los siguientes métodos:

public class Entrega {

    private String destinatario;
    private String piso;
    private boolean fueEntregado;

    //TODO Constructor default

    public Entrega(String destinatario, String piso, boolean fueEntregado){
        this.destinatario = destinatario;
        this.piso = piso;
        this.fueEntregado = fueEntregado;
    }

}
