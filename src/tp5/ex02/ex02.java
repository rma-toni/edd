package tp5.ex02;

//2) Usando una lista doblemente enlazada cargada con objetos de la clase Libro que contiene los atributos
//título, nombre de autor, año y género, realizar lo siguiente:
//a) Escribir un método que devuelva el libro más antiguo de la lista.
//b) Crear y mostrar una lista de libros cuyo género corresponde a uno específico ingresado por el usuario.
//c) Crear una nueva clase llamada LibrosEscritos con los atributos nombre de autor y cantidad de libros
//escritos. Recorrer la lista inicial y contar cuántos libros escribió cada autor. Con esta información crear
//los objetos LibrosEscritos y guardarlos en una nueva lista doble ordenada por la cantidad de libros
//escritos. Mostrar la lista generada.

import helper.DoubleLinkedList;
import helper.Helper;
import helper.SimpleLinkedList;

public class ex02
{
    static void main() {

        DoubleLinkedList<Libro> listaLibros = new DoubleLinkedList<>();

        listaLibros.addLast(new Libro("Cien años de soledad", "Gabriel Garcia Marquez", 1967, "Novela"));
        listaLibros.addLast(new Libro("Cien años de soledad", "Gabriel Garcia Marquez", 1967, "Novela"));
        listaLibros.addLast(new Libro("1984", "George Orwel", 1949, "Ciencia ficcion"));
        listaLibros.addLast(new Libro("1984", "George Orwel", 1949, "Ciencia ficcion"));
        listaLibros.addLast(new Libro("Orgullo y prejuicio", "Jane Austen", 1813, "Novela"));
        listaLibros.addLast(new Libro("El nombre de la rosa", "Umberto Eco", 1980, "Misterio"));
        listaLibros.addLast(new Libro("Los juegos del hambre", "Suzanne Collins", 2008, "Aventura"));
        listaLibros.addLast(new Libro("Tokio blues (Norwegian Wood)", "Haruki Murakami", 1987, "Romance"));
        listaLibros.addLast(new Libro("Fahrenheit 451", "Ray Bradbury", 1953, "Ciencia ficcion"));
        listaLibros.addLast(new Libro("El alquimista", "Paulo Coelho", 1988, "Aventura"));
        listaLibros.addLast(new Libro("El alquimista", "Paulo Coelho", 1988, "Aventura"));
        listaLibros.addLast(new Libro("El alquimista", "Paulo Coelho", 1988, "Aventura"));
        listaLibros.addLast(new Libro("El alquimista", "Paulo Coelho", 1988, "Aventura"));
        listaLibros.addLast(new Libro("Crónica de una muerte anunciada", "Gabriel Garcia Marquez", 1981, "Novela"));
        listaLibros.addLast(new Libro("La sombra del viento", "Carlos Ruiz Zafon", 2001, "Misterio"));

        System.out.println("--------------- LISTA LIBROS ---------------");
        System.out.println(listaLibros.toString());
        System.out.println("--------------- LIBRO MAS ANTIGUO ---------------");
        System.out.println(masAntiguo(listaLibros).toString());
        System.out.println("--------------- LISTA POR GENERO ---------------");
        String genero = Helper.getString("Ingrese el genero que desea buscar: ");
        DoubleLinkedList<Libro> listaGenero = buscarGenero(listaLibros, genero);
        System.out.println(listaGenero.toString());
        System.out.println("----------- LISTA POR AUTORES / LIBROS ESCRITOS -----------");
        DoubleLinkedList<LibrosEscritos> listaAutores = ordenarPorCantidadLibrosEscritos(listaLibros);
        System.out.println(listaAutores);

    }

    public static Libro masAntiguo(DoubleLinkedList<Libro> libros){
        Libro masAntiguo = null;
        for (Libro libro : libros){
            if (masAntiguo == null){
                masAntiguo = libro;
            }else {
                if (masAntiguo.getYear() > libro.getYear()){
                    masAntiguo = libro;
                }
            }
        }
        return masAntiguo;
    }

    public static DoubleLinkedList<Libro> buscarGenero(DoubleLinkedList<Libro> libros, String genero){
        DoubleLinkedList<Libro> librosEncontrados = new DoubleLinkedList<>();

        for (Libro libro : libros){
            if (libro.getGenero().equals(genero)){
                librosEncontrados.addLast(libro);
            }
        }

        return librosEncontrados;
    }

    public static DoubleLinkedList<LibrosEscritos> ordenarPorCantidadLibrosEscritos(DoubleLinkedList<Libro> libros){
        DoubleLinkedList<LibrosEscritos> librosEscritos = new DoubleLinkedList<>();
        String nombreAutor;

        for (Libro libro1 : libros){
            nombreAutor = libro1.getNombreAutor();
            boolean yaAgregado = false;
            for (LibrosEscritos autor : librosEscritos){
                if (autor.getNombreAutor().equals(nombreAutor)){
                    yaAgregado = true;
                }
            }
            if (yaAgregado){
                for (LibrosEscritos autor : librosEscritos){
                    if (autor.getNombreAutor().equals(nombreAutor)){
                        autor.addBook();
                    }
                }
            }else{
                librosEscritos.addLast(new LibrosEscritos(nombreAutor, 1));
            }

        }

        //region ORDENAR
        DoubleLinkedList<LibrosEscritos> returnList = new DoubleLinkedList<>();
        DoubleLinkedList<LibrosEscritos> copia = new DoubleLinkedList<>();
        for (LibrosEscritos autor : librosEscritos) {
            copia.addLast(autor);
        }

        while (copia.size() != 0){
            // Buscar el valor mínimo en la lista
            LibrosEscritos min;
            try {
                min = copia.removeFirst();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            boolean isLesser = true;
            for (LibrosEscritos autor : copia) {
                if (autor.getLibrosEscritos() < min.getLibrosEscritos()) {
                    isLesser = false;
                    break;
                }
            }
            if (!isLesser){
                copia.addLast(min);
            }else{
                returnList.addLast(min);
            }
        }
        //endregion

        return returnList;
    }
}
