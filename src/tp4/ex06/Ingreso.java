package tp4.ex06;

import java.time.LocalTime;

//En teoria el ingreso tiene que ser inmutable por eso uso Record y no creo una clase Ingreso
public record Ingreso(int dni, String motivo, LocalTime hora, boolean autorizado){}
