package tp1.ex06;

public class Rectangulo extends FiguraGeometrica {
    double alto;
    double ancho;
    public Rectangulo(String color, String nombre, double alto, double ancho){
        super(color,nombre);
        this.alto = alto;
        this.ancho = ancho;
    }

    public double perimetro(){
        return (alto*2)+(ancho*2);
    }

    public double area(){
        return alto*ancho;
    }

    //TODO toString override
    //region Getters, Setters, toString

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public double getAlto() {
        return alto;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getAncho() {
        return ancho;
    }

    @Override
    public String toString() {
        return super.toString()+", ancho: "+ancho+", alto"+alto;
    }

    //endregion
}
