package tp1;

public class Licencia {

    private int numeroIdentificacion;
    private String tipoLicencia;
    private int fechaEmision;
    private int fechaVencimiento;

    public Licencia(){
        this.numeroIdentificacion = 0;
        this.tipoLicencia = "a definir";
        this.fechaEmision =
    }

}

//a) Una Clase Licencia con los atributos: numeroIdentificacion único para la licencia, tipoLicencia que
//podría ser "Conducir", "Porte de Armas" o "Habilitación Comercial", fechaEmision y fechaVencimiento.
//        b) Constructor predeterminado que inicializa numeroIdentificacion en 000, tipoLicencia “a definir”,
//fechaEmision con la fecha actual y fechaVencimiento igual a un mes después de la fecha actual.
//c) Constructor parametrizado que permite establecer el numeroIdentificacion, tipoLicencia, fechaEmision
//y fechaVencimiento mediante argumentos.