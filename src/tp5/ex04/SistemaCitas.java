package tp5.ex04;

import helper.SimpleLinkedList;

public class SistemaCitas {

    SimpleLinkedList<CitaMedica> citas;

    public SistemaCitas(){
        citas = new SimpleLinkedList<>();
    }

    public void agregarCita(CitaMedica cita){
        citas.addLast(cita);
    }

    public boolean confirmarCita(int numeroCita){
        boolean encontrada = false;
        for (CitaMedica cita : citas){
            if (cita.getNumeroCita() == numeroCita){
                cita.confirmarCita();
                encontrada =true;
            }
        }

        return encontrada;
    }

    public void citasMedico(String medico){
        SimpleLinkedList<CitaMedica> returnList = new SimpleLinkedList<>();
        for (CitaMedica cita : citas){
            if (cita.getMedico().equals(medico)){
                System.out.println(cita.toString());
            }
        }
    }

    public void citasConfirmadas(){
        for (CitaMedica cita : citas){
            if (cita.getConfirmada()){
                System.out.println(cita.toString());
            }
        }
    }

    public boolean cancelarCita(int numeroCita){
        int size = citas.size();
        boolean encontrada = false;
        for (int i = 0; i < size; i++) {
            CitaMedica cita = citas.removeFirst();
            if (cita.getNumeroCita() != numeroCita){
                citas.addLast(cita);
            }else {
                encontrada = true;
            }
        }
        return encontrada;
    }

    public SimpleLinkedList<CitaMedica> proximasCitas(String paciente){
        SimpleLinkedList<CitaMedica> returnList = new SimpleLinkedList<>();
        for (CitaMedica cita : citas){
            if (cita.getPaciente().equals(paciente)){
                returnList.addLast(cita);
            }
        }
        return returnList;
    }

    public void showAll(){
        System.out.println(citas.toString());
    }
}
