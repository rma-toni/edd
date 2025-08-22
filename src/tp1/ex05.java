package tp1;

public class ex05 {
}

//Crear un programa para gestionar un inventario de vehículos aplicando el concepto de herencia. Definir
//una clase base Vehiculo con atributos comunes como marca, modelo, año de fabricación y precio. Esta
//clase debe contener el método llamado obtenerDescripcionBasica() que retornará un String con la marca,
//modelo y año de fabricación del vehículo. El método calcularAntiguedad(int anioActual) que recibirá el año
//actual como parámetro y retornará la antigüedad del vehículo en años (calculada como anioActual -
//        anioFabricacion).
//Crear las siguientes clases derivadas
//a) Moto: con los atributos cilindradaCC y tipoManillar (Deportivo, Cruiser, Enduro, etc.). Método
//obtenerClasificacionCilindrada(), devuelve"Baja" para cilindradas hasta 250cc, "Media" para cilindradas
//entre 251cc y 600cc, y "Alta" para cilindradas superiores a 600cc.
//        b) Auto: con los atributos numeroPuertas, tipoCombustible (Gasolina, Diesel, Eléctrico),
//capacidadBaulLitros. Método esFamiliar() devuelve true si numeroPuertas es 4 o 5, y false en cualquier
//otro caso. Método esEcoAmigable() devuelve true si tipoCombustible es "Eléctrico" o "Híbrido", de lo
//contrario false
//
//c) Camion: con los atributos capacidadCarga, numeroEjes, tipoCarroceria (Volquete, Caja Seca,
//Plataforma). Método requiereLicenciaEspecial() devuelve true si el numeroEjes es mayor a 2, y false en
//caso contrario. Método describirCapacidadesEspeciales() que devuelve un String diferente según el
//valor de tipoCarroceria, si es "Volquete", devuelve "Ideal para movimiento de tierras y materiales a
//granel"; si es "Caja Seca", devuelve "Apto para transporte de mercancías protegidas", en cualquier otro
//casos devuelve “Útil para todo tipo de carga”.
////En el programa principal (main) se debe permitir al usuario:
//) Crear una instancia de Auto: El programa debe solicitar al usuario todos los datos necesarios para
//inicializar tanto los atributos heredados de Vehiculo como los atributos propios de Auto.
//        e) Crear una instancia de Moto: De manera similar, solicitará todos los datos para sus atributos heredados
//y propios.
//f) Crear una instancia de Camion: Solicitará todos los datos para sus atributos heredados y propios.
//Para cada uno de los vehículos creados, el programa debe realizar las siguientes acciones y mostrar los
//resultados:
//g) Mostrar la descripción básica del vehículo utilizando el método obtenerDescripcionBasica() que ha sido
//heredado de la clase Vehiculo.
//        h) Calcular y mostrar la antigüedad del vehículo utilizando el método calcularAntiguedad() que ha sido
//heredado de la clase Vehiculo. Para esto, el anioActual puede ser un valor fijo (ej. 2025) o solicitado al
//usuario.
//        i) Finalmente, mostrar por pantalla todos los detalles completos de cada vehículo de manera
//formateada, incluyendo tanto los atributos heredados (marca, modelo, año, precio) como los atributos
//propios de su respectiva subclase.

//Indicaciones:
//Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
//código controle los problemas que normalmente ocurren al operar con la consola o teclado.
//Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
//respecto del código que hace lo que se solicita en el ejercicio