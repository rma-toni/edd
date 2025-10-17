package tp5.ex05;

public class Estudiante {

    private int lu;
    private String nombre;
    private String apellido;
    private int nota1;
    private int nota2;
    private int nota3;

    public Estudiante(int lu, String nombre, String apellido, int nota1, int nota2, int nota3){
        this.lu = lu;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public float promedio(){
        int suma = nota1 + nota2 + nota3;
        float promedio = (float) suma / 3;
        promedio = (float) (Math.floor(promedio * 10) / 10);
        return promedio;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "lu=" + lu +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nota1=" + nota1 +
                ", nota2=" + nota2 +
                ", nota3=" + nota3 +
                '}';
    }
}
