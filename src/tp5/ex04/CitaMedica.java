package tp5.ex04;

import java.time.LocalDate;

public class CitaMedica {
    private int numeroCita;
    private String paciente;
    private String medico;
    private LocalDate fecha;
    private String especialidad;
    private boolean confirmada;

    public CitaMedica( int numeroCita, String paciente, String medico, LocalDate fecha, String especialidad, boolean confirmada){
        this.numeroCita = numeroCita;
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = fecha;
        this.especialidad = especialidad;
        this.confirmada = confirmada;
    }

    public void confirmarCita(){
        this.confirmada = true;
    }

    //region GETTERS

    public int getNumeroCita() {
        return numeroCita;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getMedico() {
        return medico;
    }

    public String getPaciente() {
        return paciente;
    }

    public boolean getConfirmada(){
        return confirmada;
    }
    //endregion


    @Override
    public String toString() {
        return "CitaMedica{" +
                "numeroCita=" + numeroCita +
                ", paciente='" + paciente + '\'' +
                ", medico='" + medico + '\'' +
                ", fecha=" + fecha +
                ", especialidad='" + especialidad + '\'' +
                ", confirmada=" + confirmada +
                '}';
    }
}
