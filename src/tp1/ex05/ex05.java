package tp1.ex05;

//TODO Modularizar creacion de instancias
//TODO Opcional Input de fecha

import tp1.Helper;

public class ex05 {
    public static void main(String[] args) {
        String marca;
        String modelo;
        int anio;
        int precio;
        System.out.println("------------ CREAR AUTO ------------");
        marca = Helper.getString("Ingrese la marca del auto: ");
        modelo = Helper.getString("Ingrese el modelo del auto: ");
        anio = Helper.getInteger("Ingrese el año de fabricación: ");
        precio = Helper.getInteger("Ingrese el precio del vehiculo: ");
        int numeroPuertas = Helper.getInteger("Ingrese la cantidad de puertas: ");
        String tipoCombustible = Helper.getString("Ingrese el tipo de combustible: ");
        int capacidadBaulLitros = Helper.getInteger("Ingrese la capacidad del baul (litros): ");
        Auto auto1 = new Auto(marca,modelo,anio,precio,numeroPuertas,tipoCombustible,capacidadBaulLitros);
        System.out.println(auto1.obtenerDescripcionBasica());
        System.out.println("Antiguedad: "+ auto1.getAntiguedad(2025));
        System.out.println("DESCRIPCIÓN COMPLETA DEL VEHICULO:");
        System.out.println(auto1.obtenerDescripcionBasica());
        System.out.println("Ecoamigable: "+auto1.esEcoAmigable());
        System.out.println("Familiar: "+auto1.esFamiliar());
        System.out.println("------------ CREAR MOTO ------------");
        marca = Helper.getString("Ingrese la marca de la moto: ");
        modelo = Helper.getString("Ingrese el modelo de la moto: ");
        anio = Helper.getInteger("Ingrese el año de fabricación: ");
        precio = Helper.getInteger("Ingrese el precio del vehiculo: ");
        int cilindradaCC = Helper.getInteger("Ingrese la cilindrada: ");
        String tipoManillar = Helper.getString("Ingrese el tipo de manillar: ");
        Moto moto1 = new Moto(marca,modelo,anio,precio,cilindradaCC,tipoManillar);
        System.out.println(moto1.obtenerDescripcionBasica());
        System.out.println("Antiguedad: "+ moto1.getAntiguedad(2025));
        System.out.println("DESCRIPCIÓN COMPLETA DEL VEHICULO:");
        System.out.println(moto1.obtenerDescripcionBasica());
        System.out.println("Clacificacion Cilindrada: "+moto1.obtenerClasificacionCilindrada());
        System.out.println("----------- CREAR CAMION -----------");
        marca = Helper.getString("Ingrese la marca del camion: ");
        modelo = Helper.getString("Ingrese el modelo del camion: ");
        anio = Helper.getInteger("Ingrese el año de fabricación: ");
        precio = Helper.getInteger("Ingrese el precio del vehiculo: ");
        int capacidadCarga = Helper.getInteger("Ingrese la capacidad de carga: ");
        int numeroEjes = Helper.getInteger("Ingrese el numero de ejes: ");
        String tipoCarroceria = Helper.getString("Ingrese el tipo de carrocería: ");
        Camion camion1 = new Camion(marca,modelo,anio,precio,capacidadCarga,numeroEjes,tipoCarroceria);
        System.out.println(camion1.obtenerDescripcionBasica());
        System.out.println("Antiguedad: "+ camion1.getAntiguedad(2025));
        System.out.println("DESCRIPCIÓN COMPLETA DEL VEHICULO:");
        System.out.println(camion1.obtenerDescripcionBasica());
        System.out.println("Requiere licencia especial: "+camion1.requiereLicenciaEspecial());
        System.out.println("Capacidades especiales: "+camion1.describirCapacidadesEspeciales());
    }
}

//Crear un programa para gestionar un inventario de vehículos aplicando el concepto de herencia. Definir
//una clase base Vehiculo con atributos comunes como marca, modelo, año de fabricación y precio. Esta
//clase debe contener el método llamado obtenerDescripcionBasica() que retornará un String con la marca,
//modelo y año de fabricación del vehículo. El método calcularAntiguedad(int anioActual) que recibirá el año
//actual como parámetro y retornará la antigüedad del vehículo en años (calculada como anioActual -
//        anioFabricacion). LISTO
//Crear las siguientes clases derivadas
//a) Moto: con los atributos cilindradaCC y tipoManillar (Deportivo, Cruiser, Enduro, etc.). Método
//obtenerClasificacionCilindrada(), devuelve"Baja" para cilindradas hasta 250cc, "Media" para cilindradas
//entre 251cc y 600cc, y "Alta" para cilindradas superiores a 600cc. LISTO
//        b) Auto: con los atributos numeroPuertas, tipoCombustible (Gasolina, Diesel, Eléctrico),
//capacidadBaulLitros. Método esFamiliar() devuelve true si numeroPuertas es 4 o 5, y false en cualquier
//otro caso. Método esEcoAmigable() devuelve true si tipoCombustible es "Eléctrico" o "Híbrido", de lo
//contrario false LISTO
//
//c) Camion: con los atributos capacidadCarga, numeroEjes, tipoCarroceria (Volquete, Caja Seca,
//Plataforma). Método requiereLicenciaEspecial() devuelve true si el numeroEjes es mayor a 2, y false en
//caso contrario. Método describirCapacidadesEspeciales() que devuelve un String diferente según el
//valor de tipoCarroceria, si es "Volquete", devuelve "Ideal para movimiento de tierras y materiales a
//granel"; si es "Caja Seca", devuelve "Apto para transporte de mercancías protegidas", en cualquier otro
//casos devuelve “Útil para todo tipo de carga”. LISTO
//En el programa principal (main) se debe permitir al usuario:
//) Crear una instancia de Auto: El programa debe solicitar al usuario todos los datos necesarios para
//inicializar tanto los atributos heredados de Vehiculo como los atributos propios de Auto. LISTO
//e) Crear una instancia de Moto: De manera similar, solicitará todos los datos para sus atributos heredados
//y propios. LISTO
//f) Crear una instancia de Camion: Solicitará todos los datos para sus atributos heredados y propios. LISTO
//Para cada uno de los vehículos creados, el programa debe realizar las siguientes acciones y mostrar los
//resultados:
//g) Mostrar la descripción básica del vehículo utilizando el método obtenerDescripcionBasica() que ha sido
//heredado de la clase Vehiculo. LISTO
//        h) Calcular y mostrar la antigüedad del vehículo utilizando el método calcularAntiguedad() que ha sido
//heredado de la clase Vehiculo. Para esto, el anioActual puede ser un valor fijo (ej. 2025) o solicitado al
//usuario. LISTO
//        i) Finalmente, mostrar por pantalla todos los detalles completos de cada vehículo de manera
//formateada, incluyendo tanto los atributos heredados (marca, modelo, año, precio) como los atributos
//propios de su respectiva subclase.

//Indicaciones:
//Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
//código controle los problemas que normalmente ocurren al operar con la consola o teclado.
//Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
//respecto del código que hace lo que se solicita en el ejercicio