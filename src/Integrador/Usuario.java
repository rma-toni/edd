package Integrador;

public class Usuario implements Comparable<Usuario>{

    private int numeroUsuario;
    private int DNI;
    private String nombre;
    private String direccion;
    private int telefono;
    private int cantidadPrestados;

    public Usuario(int numeroUsuario, int DNI, String nombre, String direccion, int telefono){
        this.numeroUsuario = numeroUsuario;
        this.DNI = DNI;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cantidadPrestados = 0;
    }

    public Usuario(int numeroUsuario){
        this.numeroUsuario = numeroUsuario;
        DNI = 0;
        nombre = null;
        direccion = null;
        telefono = 0;
        cantidadPrestados = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroUsuario() {
        return numeroUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "numeroUsuario=" + numeroUsuario +
                ", DNI=" + DNI +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono +
                ", cantidadPrestados=" + cantidadPrestados +
                '}';
    }

    @Override
    public int compareTo(Usuario o) {
        return Integer.compare(this.numeroUsuario, o.numeroUsuario);
    }
}
