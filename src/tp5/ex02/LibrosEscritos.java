package tp5.ex02;

public class LibrosEscritos {
    //nombre de autor y cantidad de libros
    private String nombreAutor;
    private int librosEscritos;

    public LibrosEscritos(String nombreAutor, int librosEscritos){
        this.nombreAutor = nombreAutor;
        this.librosEscritos = librosEscritos;
    }

    public void addBook(){
        librosEscritos++;
    }
}
