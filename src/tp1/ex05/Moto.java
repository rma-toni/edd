package tp1.ex05;

//TODO Controlar que no se ingrese una cilindrada negativa
//TODO toString
public class Moto extends Vehiculo {
    private int cilindradaCC;
    private String tipoManillar; //(Deportivo, Cruiser, Enduro, etc.)

    public Moto(){
        super();
        cilindradaCC = 0;
        tipoManillar = "Sin especificar";
    }

    public Moto(String marca, String modelo, int anio, int precio, int cilindradaCC, String tipoManillar){
        super(marca,modelo,anio,precio);
        this.cilindradaCC = cilindradaCC;
        this.tipoManillar = tipoManillar;
    }

    public String obtenerClasificacionCilindrada(){
        String returnValue;
        if(cilindradaCC <= 250){
            returnValue = "Baja";
        } else if (cilindradaCC <= 600) {
            returnValue = "Media";
        } else {
            returnValue = "Alta";
        }
        return returnValue;
    }

    //region Getters and Setters

    public int getCilindradaCC() {
        return cilindradaCC;
    }

    public void setCilindradaCC(int cilindradaCC) {
        this.cilindradaCC = cilindradaCC;
    }

    public String getTipoManillar() {
        return tipoManillar;
    }

    public void setTipoManillar(String tipoManillar) {
        this.tipoManillar = tipoManillar;
    }

    //endregion
}
