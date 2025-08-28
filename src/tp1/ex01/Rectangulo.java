package tp1.ex01;

public class Rectangulo {
    private float ancho;
    private float alto;

    //region GETTERS SETTERS TOSTRING
    //note: El ejercio no pide o aclara que hay que implementar Getters y Setters, ni sobrecargar el toString() pero yo lo hago por las dudas

    public float getAlto() {
        return alto;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAlto(float alto) {
        this.alto = alto;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    @Override
    public String toString() {
        return "Alto: "+alto+", Ancho: "+ancho;
    }

    //endregion

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
