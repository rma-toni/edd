package tp1;

public class Rectangulo {
    private float ancho;
    private float alto;

    //TODO Agregar getters and setters , override to String


    public Rectangulo(){
        this.ancho = 0.0f;
        this.alto = 0.0f;
    }

    public Rectangulo(float an, float al){
        this.ancho = an;
        this.alto = al;
    }

    public float getArea(){
        return ancho*alto;
    }

    public float getPerimetro(){
        return (ancho*2)+(alto*2);
    }
}
