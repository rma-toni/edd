package tp2.ejercicio7;

//Para ello, se debe crear la clase Participante con los atributos:
//idParticipante, nombre, apellido y correo electrónico

public class Participante {
    private int idParticipante;
    private String nombre;
    private String apellido;
    private String correoElectronico;

    public Participante(){
        idParticipante = 0;
        nombre = "Sin definir";
        apellido = "Sin definir";
        correoElectronico = "Sin definir";
    }

    public Participante(int idParticipante, String nombre, String apellido, String correoElectronico){
        this.idParticipante = idParticipante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico; //Se puede comprar validez con expresiones regulares, pero solo complicaria el asunto
    }

    //region SETTERS GETTERS

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    public int getIdParticipante() {
        return idParticipante;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    //endregion
}
