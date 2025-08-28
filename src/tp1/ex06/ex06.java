package tp1.ex06;

import tp1.Helper;

public class ex06 {
    public static void main(String[] args) {
        String color;
        String nombre;
        //-----CREAR CIRCULO
        System.out.println("--------- CREAR CIRCULO ---------");
        color = Helper.getString("Ingrese el color del Circulo: ");
        nombre = Helper.getString("Ingrese el nombre del Circulo: ");
        double radio = Helper.getDouble("Ingrese el radio del Circulo: ");
        Circulo circulo = new Circulo(color, nombre, radio);
        System.out.println("Circulo creado!");
        System.out.println(circulo.toString());
        System.out.println("Perimetro: "+circulo.perimetro()+", Area: "+circulo.area());
        System.out.println("--------- CREAR RECTANGULO ---------");
        color = Helper.getString("Ingrese el color del Rectangulo: ");
        nombre = Helper.getString("Ingrese el nombre del Rectangulo: ");
        double ancho = Helper.getDouble("Ingrese el ancho del Rectangulo: ");
        double alto = Helper.getDouble("Ingrese el ancho del Rectangulo: ");
        Rectangulo rectangulo = new Rectangulo(color,nombre,alto,ancho);
        System.out.println("Circulo creado!");
        System.out.println(rectangulo.toString());
        System.out.println("Perimetro: "+rectangulo.perimetro()+", Area: "+rectangulo.area());
    }
}

//6) Escribir un programa que calcule el área y el perímetro de diferentes figuras geométricas utilizando
//herencia y demostrando polimorfismo.
//Definir una clase base FiguraGeometrica con los atributos color y nombre, y métodos para:
//a) Mostrar la información básica de la figura (color y nombre). LISTO
//b) Calcular el área (calcularArea), que será implementado en las clases derivadas. Este método debe
//devolver 0, ya que será sobreescrito en la clase derivada.LISTO
//c) Calcular el perímetro (calcularPerimetro), que también será implementado en las clases derivadas. Al
//igual que el ítem anterior, este método debe devolver 0, ya que será sobreescrito en la clase derivada. LISTO
//d) Crear las clases derivadas Circulo y Rectangulo que hereden de FiguraGeometrica e implementen los
//métodos de cálculo de área y perímetro de acuerdo a sus propiedades específicas (radio para el círculo;
//ancho y alto para el rectángulo).LISTO
//El programa debe permitir al usuario:
//e) Crear una instancia de Circulo ingresando sus dimensiones y mostrar su área y perímetro.
//f) Crear una instancia de Rectangulo ingresando sus dimensiones y mostrar su área y perímetro.
//Indicaciones:
//Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
//código controle los problemas que normalmente ocurren al operar con la consola o teclado.
//Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
//respecto del código que hace lo que se solicita en el ejercicio.