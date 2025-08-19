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
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
    }

}

//a) Una Clase Licencia con los atributos: numeroIdentificacion único para la licencia, tipoLicencia que
//podría ser "Conducir", "Porte de Armas" o "Habilitación Comercial", fechaEmision y fechaVencimiento.
//        b) Constructor predeterminado que inicializa numeroIdentificacion en 000, tipoLicencia “a definir”,
//fechaEmision con la fecha actual y fechaVencimiento igual a un mes después de la fecha actual.
//c) Constructor parametrizado que permite establecer el numeroIdentificacion, tipoLicencia, fechaEmision
//y fechaVencimiento mediante argumentos.