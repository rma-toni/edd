package tp1.ex06;

public class Circulo extends FiguraGeometrica{
    private double radio;
    public Circulo(String color, String nombre, double radio){
        super(color, nombre);
        this.radio = radio;
    }

    public double perimetro(){
        return (2*Math.PI*radio);
    }

    public double area(){
        return (Math.PI*Math.pow(radio,2));
    }
    //TODO toString Override
    //region Getters, Setters, toString

    public void setRadio(float radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    @Override
    public String toString() {
        return super.toString()+", radio: "+radio;
    }

    //endregion
}
