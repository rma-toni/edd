package tp1;

public class ex03 {

}

//3) Desarrollar un programa que simule la gestión de licencias con fecha de emisión y fecha de vencimiento,
//incorporando la funcionalidad de renovación.
//El programa debe incluir:
//a) Una Clase Licencia con los atributos: numeroIdentificacion único para la licencia, tipoLicencia que
//podría ser "Conducir", "Porte de Armas" o "Habilitación Comercial", fechaEmision y fechaVencimiento.
//        b) Constructor predeterminado que inicializa numeroIdentificacion en 000, tipoLicencia “a definir”,
//fechaEmision con la fecha actual y fechaVencimiento igual a un mes después de la fecha actual.
//c) Constructor parametrizado que permite establecer el numeroIdentificacion, tipoLicencia, fechaEmision
//y fechaVencimiento mediante argumentos.
//d) Método toString() para retornar una representación textual completa y legible del objeto Licencia.
//e) Método auxiliar para validar fechas que comprueba si las fechas de inicio y fin son válidas (la fecha de
//        inicio debe ser anterior a la fecha de fin y ambas deben estar dentro de los próximos 30 días). Si las
//fechas no son válidas, se ajustan automáticamente del mismo modo que en el constructor
//predeterminado.
//        f) Un método para determinar si la licencia está vigente en una fechaConsulta dada por el usuario. Debe
//retornar true si la fechaConsulta es igual o posterior a fechaEmision y es igual o anterior a
//fechaVencimiento. De lo contrario, retorna false.
// g) Método para calcular la cantidad de días restantes para el vencimiento de la licencia desde una
////fechaConsulta, o la cantidad de días que lleva vencida si ya caducó. Si la licencia aún no ha vencido,
//debe retornar un valor positivo que represente los días restantes hasta fechaVencimiento desde
//fechaConsulta. Si la licencia ya está vencida, debe retornar un valor negativo que represente los días
//que han transcurrido desde fechaVencimiento hasta fechaConsulta. Si la fecha de vencimiento es igual
//a la fecha de consulta, debe retornar 0.
//h) Método simularRenovacion(int cantidadAnios) que calcula la nueva fecha de vencimiento si la licencia
//se renovara por una cantidad específica de años a partir de su fecha de vencimiento actual.