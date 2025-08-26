package tp1;

public class ex06 {

}

//6) Escribir un programa que calcule el área y el perímetro de diferentes figuras geométricas utilizando
//herencia y demostrando polimorfismo.
//Definir una clase base FiguraGeometrica con los atributos color y nombre, y métodos para:
//a) Mostrar la información básica de la figura (color y nombre). LISTO
//b) Calcular el área (calcularArea), que será implementado en las clases derivadas. Este método debe
//devolver 0, ya que será sobreescrito en la clase derivada.
//c) Calcular el perímetro (calcularPerimetro), que también será implementado en las clases derivadas. Al
//igual que el ítem anterior, este método debe devolver 0, ya que será sobreescrito en la clase derivada.
//d) Crear las clases derivadas Circulo y Rectangulo que hereden de FiguraGeometrica e implementen los
//métodos de cálculo de área y perímetro de acuerdo a sus propiedades específicas (radio para el círculo;
////ancho y alto para el rectángulo).
//El programa debe permitir al usuario:
//e) Crear una instancia de Circulo ingresando sus dimensiones y mostrar su área y perímetro.
//f) Crear una instancia de Rectangulo ingresando sus dimensiones y mostrar su área y perímetro.
//Indicaciones:
//Este ejercicio necesita del objeto scanner para ingresar datos por la consola o teclado, se espera que el
//código controle los problemas que normalmente ocurren al operar con la consola o teclado.
//Se espera una correcta modularización entre el código que realiza el ingreso y validación de los datos
//respecto del código que hace lo que se solicita en el ejercicio.