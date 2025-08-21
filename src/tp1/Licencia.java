package tp1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Licencia {

    private int numeroIdentificacion;
    private String tipoLicencia;
    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;

    public Licencia(){
        this.numeroIdentificacion = 0;
        this.tipoLicencia = "a definir";
        this.fechaEmision = LocalDate.now();
        this.fechaVencimiento = this.fechaEmision.plusMonths(1);
    }

    public Licencia(int numeroIdentificacion, String tipoLicencia, LocalDate fechaEmision, LocalDate fechaVencimiento){
        this.numeroIdentificacion = numeroIdentificacion;
        this.tipoLicencia = tipoLicencia;
        this.validarFechas(fechaEmision,fechaVencimiento);
    }

    @Override
    public String toString() {
        return "N° Identificacion: "+numeroIdentificacion+". Tipo: "+tipoLicencia+". Emision: "+fechaVencimiento.toString()+". Vencimiento: "+fechaVencimiento.toString();
    }

    public void validarFechas(LocalDate emision, LocalDate vencimiento){
        if(emision.isAfter(vencimiento) || emision.isEqual(vencimiento)){
            this.fechaEmision = LocalDate.now();
            this.fechaVencimiento = fechaEmision.plusMonths(1);
        }else{
            this.fechaEmision = emision;
            this.fechaVencimiento = vencimiento;
        }
    }

    public boolean verificarVigencia(LocalDate fecha){
        return (fecha.isAfter(fechaEmision) || fecha.isEqual(fechaEmision)) && (fecha.isBefore(fechaVencimiento) && fecha.isEqual(fechaVencimiento));
    }

    public int diasRestantes(LocalDate fechaConsulta){
        return (int) ChronoUnit.DAYS.between(fechaConsulta, fechaVencimiento);
    }

    public void simularRenovacion(int cantidadAnios){
        LocalDate fechaSimulada = fechaVencimiento.plusYears(cantidadAnios);
        System.out.println("Simulacion: La nueva fecha sera: "+fechaSimulada.toString());
    }
}
