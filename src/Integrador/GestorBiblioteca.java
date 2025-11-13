package Integrador;

import helper.*;

import javax.swing.*;
import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

//TODO array resize
//TODO Validar telefono
//TODO tiempo de prestamo
//TODO Procesar pendientes PROBAR
//TODO Buscar libro
//TODO Buscar Usuario
//TODO Devolver libro

public class GestorBiblioteca implements Serializable {
    private File data;
    private final String fileName = "datos.dat";

    //region ATTRIBUTES
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
    //endregion

    //region CONSTRUCTOR
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
    //endregion

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
        Usuario user = userByCode();
        Libro libro;
        if (user==null) return false;
        System.out.println("-------- USUARIO --------");
        System.out.println(user.toString());
        libro = searchBook();
        if (libro==null) return false;
        System.out.println("--------- LIBRO ---------");
        System.out.println(libro.toString());
        if (libro.isDisponible()){
            operaciones.push(new Operacion(++opCount,Operacion.Opcion.PRESTAMO,user,libro, LocalDate.now(),60));
            libro.setDisponible(false);
            user.prestar();
            return true;
        }else{
            pendientes.add(new Pendiente(user,libro));
            System.out.println("El libro no se encuentra disponible, se agrego a PENDIENTES.");
            return false;
        }
    }

    public boolean devolucion(){
        boolean opResult = true;
        ArrayList<Operacion> opList = new ArrayList<>();
        Usuario user = userByCode();
        int cantidadOp = operaciones.size();
        for (int i = 0; i < cantidadOp; i++) {
            Operacion op = operaciones.pop();
            if (op.getUser().equals(user) && !op.isCompletada()){
                opList.add(op);
            }
            operaciones.push(op);
        }

        for (int i = 0; i < opList.size(); i++) {
            System.out.println((i+1)+" - "+opList.get(i).toString());
        }

        return opResult;
    }

    public void mostrarOp(){
        int cantidad = operaciones.size();
        if (cantidad == 0){
            System.out.println("No hay operaciones!");
        }else{
            Stack<Operacion> aux = new Stack<>();
            Operacion op;
            for (int i = 0; i < cantidad; i++) {
                aux.push(operaciones.pop());
            }
            for (int i = 0; i < cantidad; i++) {
                op = aux.pop();
                System.out.println(op);
                operaciones.push(op);
            }
        }
    }

    public void mostrarPendientes(){
        Pendiente pend;
        int size = pendientes.size();

        for (int i = 0; i < size; i++) {
            pend = pendientes.remove();
            System.out.println(pend);
            pendientes.add(pend);
        }
    }

    public void procesarPendientes(){
        int size = pendientes.size();
        Pendiente aux;
        for (int i = 0; i < size; i++) {
            aux = pendientes.remove();
            if (aux.getLibro().isDisponible()){
                System.out.println("El libro se encuentra disponible, desea realizar el prestamo? 1 - Si, 2 - No");
                int number = Helper.getInteger("Ingrese la opcion seleccionada: ");
                while (number!= 1 && number != 2) number = Helper.getInteger("Ingrese una opcion valida: ");
                if (number == 1){
                    operaciones.push(new Operacion(opCount, Operacion.Opcion.PRESTAMO, aux.getUsuario(),aux.getLibro(), LocalDate.now(), 60));
                    opCount++;
                    System.out.println("Operacion completada y pendiente removida!");
                }else {
                    System.out.println("Pendiente removido!");
                }
            }else{
                pendientes.add(aux);
            }
        }
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

    //region AUX METHODS
    public int rand(){
        Random random = new Random();
        return random.nextInt(10000);
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
                    result = bookByAutor();
                    if (result == null){
                        opcion = Helper.getInteger("Ingrese 1 para volver a buscar o ingrese 0 para salir: ");
                        if (opcion == 1){
                            continue;
                        }
                    }
                    break;
                case 3:
                    result = booksByTitle();
                    if (result == null){
                        opcion = Helper.getInteger("Ingrese 1 para volver a buscar o ingrese 0 para salir: ");
                        if (opcion == 1){
                            continue;
                        }
                    }

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

    public Libro bookByAutor(){
        String sub = Helper.getString("Ingrese el nombre o parte del nombre de autor a buscar: ");
        Libro result = null;
        ArrayList<Libro> booksList = new ArrayList<>();
        for (int i = 0; i < booksCount ; i++){
            if (books[i].getAutor().contains(sub)){
                booksList.add(books[i]);
            }
        }
        if (booksList.isEmpty()){
            System.out.println("No se encontraron resultados.");
        }else{
            for (int i = 0; i < booksList.size(); i++) {
                System.out.println((i+1)+" - "+booksList.get(i).toString());
            }
            int opcion = Helper.getInteger("Ingrese el libro elegido (0 para cancelar):");
            if (!(opcion == 0)){
                result = booksList.get(opcion-1);
            }else {
                System.out.println("Operacion cancelada.");
            }
        }
        return result;
    }

    public  Libro booksByTitle(){
        String sub = Helper.getString("Ingrese el nombre o parte del titulo a buscar: ");
        Libro result = null;
        ArrayList<Libro> booksList = new ArrayList<>();
        for (int i = 0; i < booksCount ; i++){
            if (books[i].getTitulo().contains(sub)){
                booksList.add(books[i]);
            }
        }
        if (booksList.isEmpty()){
            System.out.println("No se encontraron resultados.");
        }else{
            for (int i = 0; i < booksList.size(); i++) {
                System.out.println((i+1)+" - "+booksList.get(i).toString());
            }
            int opcion = Helper.getInteger("Ingrese el libro elegido (0 para cancelar):");
            if (!(opcion == 0)){
                result = booksList.get(opcion-1);
            }else {
                System.out.println("Operacion cancelada.");
            }
        }
        return result;
    }
    //endregion

    //region Debug Methods
    public void addDebugDataBooks(){
        int codigo = 123;
        booksCode.add(codigo);
        Libro book1 = new Libro(codigo,"Orgullo y Prejuicio", "Jane Austen",12000 ,false);
        booksTree.add(book1);
        books[booksCount] = book1;
        booksCount++;
        codigo = 213;
        booksCode.add(codigo);
        Libro book2 = new Libro(codigo,"Calculo: Trascendentes Tempranas", "James Stewart", 25000,true);
        booksTree.add(book2);
        books[booksCount] = book2;
        booksCount++;
        codigo = 214123;
        booksCode.add(codigo);
        Libro book3 = new Libro(codigo,"Mujercitas", "Louisa May Alcott", 10000,true);
        booksTree.add(book3);
        books[booksCount] = book3;
        booksCount++;
        codigo = 4568;
        booksCode.add(codigo);
        Libro book4 = new Libro(codigo,"Persuasion", "Jane Austen", 10000,false);
        booksTree.add(book4);
        books[booksCount] = book4;
        booksCount++;
        codigo = 7985;
        booksCode.add(codigo);
        Libro book5 = new Libro(codigo,"Quimica", "Raymond Chang", 32000,true);
        booksTree.add(book5);
        books[booksCount] = book5;
        booksCount++;
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
        codigo = 132;
        usersCode.add(codigo);
        Usuario user3 = new Usuario(codigo, 37582553,"Ana","Salta 540", 123456789);
        usersTree.add(user3);
        users[usersCount] = user3;
        usersCount++;
    }

    public void addDebugDataOp(){
        Operacion op1 = new Operacion(++opCount, Operacion.Opcion.PRESTAMO,users[1],books[3],LocalDate.now(),60);
        operaciones.push(op1);
        users[1].prestar();
        Operacion op2 = new Operacion(++opCount, Operacion.Opcion.PRESTAMO,users[1],books[0],LocalDate.now(),60);
        operaciones.push(op2);
        users[1].prestar();
    }

    public void addDebugData(){
        addDebugDataUsers();
        addDebugDataBooks();
        addDebugDataOp();
    }
    //endregion
}
