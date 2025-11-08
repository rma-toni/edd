package Integrador;

import helper.*;

import javax.swing.*;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

//TODO array resize
//TODO Validar telefono
//TODO tiempo de prestamo

public class GestorBiblioteca implements Serializable {

    private File data;
    private final String fileName = "datos.dat";

    private Libro[] books;
    private Usuario[] users;
    private int booksCount;
    private int usersCount;
    private int opCount;
    private BinarySearchTree<Libro> booksTree;
    private BinarySearchTree<Usuario> usersTree;
    private ArrayList<Integer> booksCode;
    private ArrayList<Integer> usersCode;
    private Queue<Pendiente> pendientes;
    private Stack<Operacion> operaciones;

    public GestorBiblioteca() {
        /*data = new File(fileName);
        if (data.exists()){
            GestorBiblioteca load = SaveManager.loadData(fileName);
            this.books = load.getBooks();
            this.users = load.getUsers();
            this.booksCount = load.getBooksCount();
            this.usersCount = load.getUsersCount();
            this.opCount = load.getOpCount();
            this.booksTree = load.getBooksTree();
            this.usersTree = load.getUsersTree();
            this.usersCode = load.getUsersCode();
            this.booksCode = load.getBooksCode();
            this.pendientes = load.getPendientes();
            this.operaciones = load.getOperaciones();
        }else {
            books = new Libro[100];
            users = new Usuario[100];
            booksTree = new BinarySearchTree<>();
            usersTree = new BinarySearchTree<>();
            usersCode = new ArrayList<>();
            booksCode = new ArrayList<>();
            booksCount = 0;
            usersCount = 0;
            opCount = 0;
            pendientes = new Queue<>(100);
            operaciones = new Stack<>(100);
            SaveManager.saveData(this, fileName);
        }*/

        books = new Libro[100];
        users = new Usuario[100];
        booksTree = new BinarySearchTree<>();
        usersTree = new BinarySearchTree<>();
        usersCode = new ArrayList<>();
        booksCode = new ArrayList<>();
        booksCount = 0;
        usersCount = 0;
        opCount = 0;
        pendientes = new Queue<>(100);
        operaciones = new Stack<>(100);
        SaveManager.saveData(this, fileName);
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
        int cod = rand();
        while (booksCode.contains(cod)){
            cod = rand();
        }
        String nom = Helper.getString("Ingrese el nombre del libro: ");
        String aut = Helper.getString("Ingrese el nombre del autor: ");
        float precio = Helper.getFloat("Ingrese el precio del libro: ");
        Libro book = new Libro(cod, nom, aut, precio,true);
        booksTree.add(book);
        books[booksCount] = book;
        booksCount++;
        SaveManager.saveData(this, fileName);
    }

    public void crearUsuario(){
        int userNumber = rand();
        while (usersCode.contains(userNumber)){
            userNumber = rand();
        }
        usersCode.add(userNumber);
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

    public boolean prestamo(){
        boolean opResult = true;
        //TODO buscar Usuario
        Usuario user = userByCode();
        return opResult;
    }

    public boolean devolucion(){
        boolean opResult = true;
        return opResult;
    }
    //endregion

    //region GETTERS
    public Libro[] getBooks() {
        return books;
    }
    public BinarySearchTree<Libro> getBooksTree() {
        return booksTree;
    }
    public Usuario[] getUsers() {
        return users;
    }
    public BinarySearchTree<Usuario> getUsersTree() {
        return usersTree;
    }
    public ArrayList<Integer> getBooksCode() {
        return booksCode;
    }
    public ArrayList<Integer> getUsersCode() {
        return usersCode;
    }
    public Queue<Pendiente> getPendientes() {
        return pendientes;
    }
    public Stack<Operacion> getOperaciones() {
        return operaciones;
    }
    public int getBooksCount() {
        return booksCount;
    }
    public int getUsersCount() {
        return usersCount;
    }
    public int getOpCount() {
        return opCount;
    }
    //endregion

    //region Aux Methods
    public int rand(){
        Random random = new Random(10000);
        return rand();
    }

    public Usuario userByCode(){
        Usuario result = null;
        int codUsuario = Helper.getInteger("Ingrese el codigo de usuario: ");
        if (usersCode.contains(codUsuario)){
            result = getUsersTree().Buscar(new Usuario(codUsuario));
        }else{
            System.out.println("El usuario no existe.");
        }
        return result;
    }
    
    public Libro searchBook(){
        Libro result = null;
        int opcion = 0;
        while (true){
            System.out.println("---------- BUSQUEDA DE LIBRO ------------");
            System.out.println("1 - BUSCAR POR CODIGO");
            System.out.println("2 - BUSCAR POR AUTOR");
            System.out.println("3 - BUSCAR POR TITULO");
            opcion = Helper.getInteger("Seleccion una opcione una opcion: ");
            switch (opcion){
                case 1:
                    result = bookByCode();
                    if (result == null){
                        opcion = Helper.getInteger("Ingrese 1 para volver a buscar o ingrese 0 para salir: ");
                        if (opcion == 1){
                            continue;
                        }
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    continue;
            }
            break;
        }
        return result;
    }

    public Libro bookByCode(){
        Libro result = null;
        int codLibro = Helper.getInteger("Ingrese el codigo de libro : ");
        if (booksCode.contains(codLibro)){
            result = getBooksTree().Buscar(new Libro(codLibro));
        }else{
            System.out.println("El libro no existe.");
        }
        return result;
    }
    //endregion

    //region Debug Methods
    public void addDebugDataBooks(){
        int codigo = 123;
        booksCode.add(codigo);
        Libro book1 = new Libro(codigo,"Orgullo y Prejuicio", "Jane Austen",12000 ,true);
        booksTree.add(book1);
        books[booksCount] = book1;
        booksCount++;
        codigo = 213;
        booksCode.add(codigo);
        Libro book2 = new Libro(codigo,"Calculo: Trascendentes Tempranas", "James Stewart", 25000,true);
        booksTree.add(book2);
        books[booksCount] = book2;
        booksCount++;
        SaveManager.saveData(this, fileName);
    }

    public void addDebugDataUsers(){
        int codigo = 123;
        usersCode.add(codigo);
        Usuario user1 = new Usuario(codigo, 31522333,"Marco","Avenida Alvear 218", 1173695623);
        usersTree.add(user1);
        users[usersCount] = user1;
        usersCount++;
        codigo = 231;
        usersCode.add(codigo);
        Usuario user2 = new Usuario(codigo, 31522333,"Juan","Corrientes 230", 1173325641);
        usersTree.add(user2);
        users[usersCount] = user2;
        usersCount++;
        SaveManager.saveData(this, fileName);
    }
    //endregion
}
