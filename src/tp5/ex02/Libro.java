package tp5.ex02;

public class Libro {
    private String titulo;
    private String nombreAutor;
    private int year;
    private String genero;

    public Libro(String titulo, String nombreAutor, int year, String genero){
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.year = year;
        this.genero = genero;
    }

    //region GETTERS / SETTERS

    public int getYear() {
        return year;
    }

    public String getGenero() {
        return genero;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    //endregion


    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", year=" + year +
                ", genero='" + genero + '\'' +
                '}';
    }
}
