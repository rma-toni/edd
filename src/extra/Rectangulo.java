package extra;

public class Rectangulo {

    private int alto;
    private int ancho;

    //CONSTRUCTOR POR DEFECTOS
    public Rectangulo(){
        //uso de this opcional
        alto = 0;
        ancho = 0;
    }

    //CONSTRUCTOR PARAMETRIZADO
    public Rectangulo(int alto, int ancho){
        if(alto < 0){ //COMPARA QUE NO ES UN NUMERO NEGATIVO
            this.alto = 0;
        }else{
            this.alto = alto;
        }

        if(ancho < 0){
            this.ancho = 0;
        }else{
            this.ancho = ancho;
        }
    }

    //GETTER
    public int getAlto(){
        return alto;
    }

    //SETTER No retorna nada -> void
    public void setAlto(int alto){
        if(alto < 0){
            this.alto = 0;
        } else {
            this.alto = alto;
        }
        //alto = altoParametro;
    }

}
