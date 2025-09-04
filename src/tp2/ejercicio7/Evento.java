package tp2.ejercicio7;

import java.time.LocalDate;
import java.util.ArrayList;

public class Evento {

    private int idEvento;
    private String nombreEvento;
    private LocalDate fecha;
    private String lugar;
    private ArrayList<Participante> participantesInscriptos;

    public Evento(){
        idEvento = 0;
        nombreEvento = "Sin definir";
        fecha = LocalDate.now(); //Se asigna fecha actual por defecto
        lugar = "Sin definir";
        participantesInscriptos = new ArrayList<>();
    }

    public Evento(int idEvento, String nombreEvento, LocalDate fecha, String lugar){
        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
        this.fecha = LocalDate.now(); //Se asigna fecha actual por defecto
        this.lugar = lugar;
        this.participantesInscriptos = new ArrayList<>();
    }

    public void agregarParticipante(Participante participante){
        participantesInscriptos.add(participante);
    }

    public void mostrarParticipantes(){
        if (participantesInscriptos.isEmpty()){
            System.out.println("No hay participantes inscriptos.");
        } else {
            for(Participante participante : participantesInscriptos){
                System.out.println("ID: "+participante.getIdParticipante()+", Nombre: "+participante.getNombre()+
                        ", Apellido: "+participante.getApellido()+", Email: "+participante.getCorreoElectronico());
            }
        }
    }

    public void eliminarParticipantes(int idParticipante){
        boolean participanteExiste = false;
        for(Participante participante : participantesInscriptos){
            if(participante.getIdParticipante() == idParticipante){
                participanteExiste = true;
                participantesInscriptos.remove(participante);
            }
        }
        if (participanteExiste) {
            System.out.println("El participante fue eliminado con éxito");
        }else{
            System.out.println("La ID ingresada no corresponde a un participante del evento.");
        }
    }

    public int cantidadParticipantes(){
        return participantesInscriptos.size();
    }

    //region GETTERS SETTERS
    public int getIdEvento() {
        return idEvento;
    }
    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    //endregion
}
