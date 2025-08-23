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

//3) Desarrollar un programa que simule la gestión de licencias con fecha de emisión y fecha de vencimiento,
//incorporando la funcionalidad de renovación.
//El programa debe incluir:
//TODO a) Una Clase Licencia con los atributos: numeroIdentificacion único para la licencia, tipoLicencia que
//podría ser "Conducir", "Porte de Armas" o "Habilitación Comercial", fechaEmision y fechaVencimiento.
//TODO b) Constructor predeterminado que inicializa numeroIdentificacion en 000, tipoLicencia “a definir”,
//fechaEmision con la fecha actual y fechaVencimiento igual a un mes después de la fecha actual.
//TODO c) Constructor parametrizado que permite establecer el numeroIdentificacion, tipoLicencia, fechaEmision
//y fechaVencimiento mediante argumentos.
//TODO d) Método toString() para retornar una representación textual completa y legible del objeto Licencia.
//TODO e) Método auxiliar para validar fechas que comprueba si las fechas de inicio y fin son válidas (la fecha de
//inicio debe ser anterior a la fecha de fin y ambas deben estar dentro de los próximos 30 días). Si las
//fechas no son válidas, se ajustan automáticamente del mismo modo que en el constructor
//predeterminado.
//TODO f) Un método para determinar si la licencia está vigente en una fechaConsulta dada por el usuario. Debe
//retornar true si la fechaConsulta es igual o posterior a fechaEmision y es igual o anterior a
//fechaVencimiento. De lo contrario, retorna false.
//TODO g) Método para calcular la cantidad de días restantes para el vencimiento de la licencia desde una
//fechaConsulta, o la cantidad de días que lleva vencida si ya caducó. Si la licencia aún no ha vencido,
//debe retornar un valor positivo que represente los días restantes hasta fechaVencimiento desde
//fechaConsulta. Si la licencia ya está vencida, debe retornar un valor negativo que represente los días
//que han transcurrido desde fechaVencimiento hasta fechaConsulta. Si la fecha de vencimiento es igual
//a la fecha de consulta, debe retornar 0.
//TODO h) Método simularRenovacion(int cantidadAnios) que calcula la nueva fecha de vencimiento si la licencia
//se renovara por una cantidad específica de años a partir de su fecha de vencimiento actual.
//En el programa principal (main) se debe:
//TODO i) Solicitar al usuario los datos para crear al menos dos objetos Licencia diferentes, por ejemplo: una
//licencia vigente y una licencia vencida. Se debe realizar las validaciones correspondientes.
//TODO j) Después de crear las licencias, el programa debe solicitar al usuario una "fecha de consulta" (día, mes,
//año) para verificar el estado de las licencias. Esta fecha también debe ser validada.
//Para cada objeto Licencia creado, el programa debe:
//TODO k) Mostrar sus detalles utilizando el método toString().
//TODO l) Llamar al método estaVigente() pasándole la "fecha de consulta" y mostrar el resultado.
//TODO m) Llamar al método calcularDiasRestantesOVencidos() pasándole la misma "fecha de consulta" y mostrar
//la cantidad de días restantes o vencidos.
//TODO n) Solicitar al usuario una cantidad de años para simular una renovación, llamar al método
//simularRenovacion() y mostrar la nueva fecha de vencimiento calculada (sumar fechas).