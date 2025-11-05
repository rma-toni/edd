package Integrador;

import helper.AVLTree;
import helper.BinarySearchTree;
import helper.Helper;
import helper.SaveManager;

import javax.swing.*;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;

//TODO array resize
//TODO Validar telefono

public class GestorBiblioteca implements Serializable {

    private File data;
    private final String fileName = "datos.dat";

    private Libro[] books;
    private Usuario[] users;
    int booksCount;
    int usersCount;
    private AVLTree<Libro> booksTree;
    private AVLTree<Usuario> usersTree;



    public GestorBiblioteca() {
        data = new File(fileName);
        if (data.exists()){
            GestorBiblioteca load = SaveManager.loadData(fileName);
            books = load.getBooks();
            users = load.getUsers();
            booksCount = 0;
            usersCount = 0;
            booksTree = getBooksTree();
            usersTree = getUsersTree();
        }else {
            books = new Libro[100];
            users = new Usuario[100];
            booksTree = new AVLTree<>();
            usersTree = new AVLTree<>();
            SaveManager.saveData(this, fileName);
        }
    }

    //region METHODS
    public void mostrarLibros(){
        System.out.println("---------- LIBROS ----------");
        if (booksCount == 0){
            System.out.println("No hay libros");
        }else{
            StringBuilder message = new StringBuilder();
            for (int i = 0; i < booksCount; i++){
                message.append(books[i].toString()).append("\n");
            }
            System.out.println(message);
        }
        System.out.println("---------- FIN ----------");
    }

    public void mostrarUsuarios(){
        System.out.println("---------- USUARIOS ----------");
        if (usersCount == 0){
            System.out.println("No hay usuarios");
        }else{
            StringBuilder message = new StringBuilder();
            for (int i = 0; i < usersCount; i++){
                message.append(users[i].toString()).append("\n");
            }
            System.out.println(message);
        }
        System.out.println("---------- FIN ----------");
    }

    public void crearLibro(){
        int cod = booksCount+1;
        String nom = Helper.getString("Ingrese el nombre del libro: ");
        String aut = Helper.getString("Ingrese el nombre del autor: ");
        Libro book = new Libro(cod, nom, aut, true);
        booksTree.add(book);
        books[booksCount] = book;
        booksCount++;
        SaveManager.saveData(this, fileName);
    }

    public void crearUsuario(){
        int userNumber = usersCount+1;
        int dni = Helper.getInteger("Ingrese el dni del usuario: ");
        String nom = Helper.getString("Ingrese el nombre del usuario: ");
        String address = Helper.getString("Ingrese la dirección del usuario: ");
        int tel = Helper.getInteger("Ingrese el teléfono del usuario: ");
        Usuario user = new Usuario(userNumber,dni,nom,address,tel);
        usersTree.add(user);
        users[usersCount] = user;
        usersCount++;
        SaveManager.saveData(this, fileName);
    }
    //endregion

    //region GETTERS
    public Libro[] getBooks() {
        return books;
    }

    public AVLTree<Libro> getBooksTree() {
        return booksTree;
    }

    public Usuario[] getUsers() {
        return users;
    }

    public AVLTree<Usuario> getUsersTree() {
        return usersTree;
    }
    //endregion
}
