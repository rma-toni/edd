package tp1;

import java.time.LocalDate;

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
    //TO DO
    //        f) Un método para determinar si la licencia está vigente en una fechaConsulta dada por el usuario. Debe
    //retornar true si la fechaConsulta es igual o posterior a fechaEmision y es igual o anterior a
    //fechaVencimiento. De lo contrario, retorna false.
}
