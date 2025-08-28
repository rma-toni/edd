package tp1.ex03;

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

    //TODO limitar tipos de licencia a predefinidos
    public Licencia(int numeroIdentificacion, String tipoLicencia, LocalDate fechaEmision, LocalDate fechaVencimiento){
        this.numeroIdentificacion = numeroIdentificacion;
        this.tipoLicencia = tipoLicencia;
        this.validarFechas(fechaEmision,fechaVencimiento);
    }

    @Override
    public String toString() {
        return "N° Identificacion: "+numeroIdentificacion+". Tipo: "+tipoLicencia+". Emision: "+fechaEmision.toString()+". Vencimiento: "+fechaVencimiento.toString();
    }

    //TODO PREGUNTA? Proximos 30 dias a que fecha? Entre emision y vencimiento? o desde la fecha actual?
    public void validarFechas(LocalDate emision, LocalDate vencimiento){
        boolean fechasInvalidas = emision.isAfter(vencimiento) || emision.isEqual(vencimiento);
        boolean fechasAntiguas = ChronoUnit.DAYS.between(LocalDate.now(), emision) > 30
                || ChronoUnit.DAYS.between(LocalDate.now(), vencimiento) > 30
                || ChronoUnit.DAYS.between(LocalDate.now(), emision) < 0
                || ChronoUnit.DAYS.between(LocalDate.now(), vencimiento) < 0;

        if (fechasInvalidas || fechasAntiguas) {
            this.fechaEmision = LocalDate.now();
            this.fechaVencimiento = this.fechaEmision.plusMonths(1);
        } else {
            this.fechaEmision = emision;
            this.fechaVencimiento = vencimiento;
        }
    }

    public boolean verificarVigencia(LocalDate fecha){
        return (fecha.isAfter(fechaEmision) || fecha.isEqual(fechaEmision)) && (fecha.isBefore(fechaVencimiento) || fecha.isEqual(fechaVencimiento));
    }

    public int diasRestantes(LocalDate fechaConsulta){
        return (int) ChronoUnit.DAYS.between(fechaConsulta, fechaVencimiento);
    }

    public void simularRenovacion(int cantidadAnios){
        LocalDate fechaSimulada = fechaVencimiento.plusYears(cantidadAnios);
        System.out.println("Simulacion: La nueva fecha sera: "+fechaSimulada.toString());
    }
}

//-------CLASE------- (COMPLETADO)

//3) Desarrollar un programa que simule la gestión de licencias con fecha de emisión y fecha de vencimiento,
//incorporando la funcionalidad de renovación.
//El programa debe incluir:
//COMPLETADO a) Una Clase Licencia con los atributos: numeroIdentificacion único para la licencia, tipoLicencia que
//podría ser "Conducir", "Porte de Armas" o "Habilitación Comercial", fechaEmision y fechaVencimiento.
//COMPLETADO b) Constructor predeterminado que inicializa numeroIdentificacion en 000, tipoLicencia “a definir”,
//fechaEmision con la fecha actual y fechaVencimiento igual a un mes después de la fecha actual.
//COMPLETADO c) Constructor parametrizado que permite establecer el numeroIdentificacion, tipoLicencia, fechaEmision
//y fechaVencimiento mediante argumentos.
//COMPLETADO d) Método toString() para retornar una representación textual completa y legible del objeto Licencia.
//COMPLETADO e) Método auxiliar para validar fechas que comprueba si las fechas de inicio y fin son válidas (la fecha de
//inicio debe ser anterior a la fecha de fin y ambas deben estar dentro de los próximos 30 días). Si las
//fechas no son válidas, se ajustan automáticamente del mismo modo que en el constructor
//predeterminado.
//COMPLETADO f) Un método para determinar si la licencia está vigente en una fechaConsulta dada por el usuario. Debe
//retornar true si la fechaConsulta es igual o posterior a fechaEmision y es igual o anterior a
//fechaVencimiento. De lo contrario, retorna false.
//COMPLETADO g-) Método para calcular la cantidad de días restantes para el vencimiento de la licencia desde una
//fechaConsulta, o la cantidad de días que lleva vencida si ya caducó. Si la licencia aún no ha vencido,
//debe retornar un valor positivo que represente los días restantes hasta fechaVencimiento desde
//fechaConsulta. Si la licencia ya está vencida, debe retornar un valor negativo que represente los días
//que han transcurrido desde fechaVencimiento hasta fechaConsulta. Si la fecha de vencimiento es igual
//a la fecha de consulta, debe retornar 0.
//COMPLETADO h) Método simularRenovacion(int cantidadAnios) que calcula la nueva fecha de vencimiento si la licencia
//se renovara por una cantidad específica de años a partir de su fecha de vencimiento actual.