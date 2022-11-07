package Clases;

import Interfaces.Enviable;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Inventario implements Iterable<Producto>{

    private static ArrayList<Producto> listaProductos;

    private static String ficheroInventario;
    private static int ultimoCodigo;

    private static  Inventario instance;

    private Inventario(){
        listaProductos = new ArrayList<Producto>();
    }

    public static Inventario getInstance(){

        if(instance == null){
            instance = new Inventario();
        }

        return instance;
    }

    public static void cargarProductos(){

        System.out.println("========================================================================");
        System.out.println("=                        CARGANDO PRODUCTOS ...                        =");
        System.out.println("========================================================================");

        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3316/anderioPrime",
                    "root", "root");

            try (PreparedStatement statement = connection.prepareStatement("""
            SELECT *
            FROM PRODUCTOS
        """)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {

                    ResultSetMetaData metadata = resultSet.getMetaData();
                    int columnCount = metadata.getColumnCount();

                    switch (resultSet.getString(columnCount)){
                        case "Herramienta":
                            Herramienta herramienta = new Herramienta(0, resultSet.getString(2), resultSet.getDouble(3), resultSet.getInt(4), resultSet.getDouble(5));
                            System.out.println(herramienta.volcar());
                            break;
                        case "Otros":
                            Otros otros = new Otros(0, resultSet.getString(2), resultSet.getDouble(3), resultSet.getInt(4), resultSet.getDouble(5), resultSet.getString(7));
                            System.out.println(otros.volcar());
                            break;
                        case "FrutaHortaliza":
                            FrutaHortaliza frutaHortaliza = new FrutaHortaliza(0, resultSet.getString(2), resultSet.getDouble(3), resultSet.getInt(4), resultSet.getDouble(5), resultSet.getString(6), resultSet.getString(7));
                            System.out.println(frutaHortaliza.volcar());
                            break;
                        case "Bebida":
                            Bebida bebida = new Bebida(0, resultSet.getString(2), resultSet.getDouble(3), resultSet.getInt(4), resultSet.getDouble(5), resultSet.getString(6), resultSet.getString(7));
                            System.out.println(bebida.volcar());
                            break;
                        case "Lacteo":
                            Lacteo lacteo = new Lacteo(0, resultSet.getString(2), resultSet.getDouble(3), resultSet.getInt(4), resultSet.getDouble(5), resultSet.getString(6), resultSet.getString(7));
                            System.out.println(lacteo.volcar());
                            break;
                    }

                }
            }



        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("========================================================================");
        System.out.println("=                     CARGA DE PRODUCTOS COMPLETA                      =");
        System.out.println("========================================================================");

    }

    public static void migrarProductos(){

        try  {

            Connection connection = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3316/anderioPrime",
                    "root", "root"
            );


           /* try (PreparedStatement statement = connection.prepareStatement("""
        INSERT INTO persona(Nombre, Apellido, Num_telef)
        VALUES (?, ?, ?)
      """)) {
                statement.setString(1, "Paco");
                statement.setString(2, "Manteca");
                statement.setInt(3, 608956673);
                int rowsInserted = statement.executeUpdate();
            }*/

            /*ArrayList<Usuarios> users = new ArrayList<>();

            try (PreparedStatement statement = connection.prepareStatement("""
            SELECT usuario, contrasenya
            FROM usuarios
        """)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {

                    users.add(new Usuarios(resultSet.getString(1), resultSet.getString(2)));

                }
            }

            Scanner in = new Scanner(System.in);

            System.out.println("Introduce un usuario: ");

            String user = in.nextLine();

            List<Usuarios> usuario = users.stream()
                    .filter(usuarioData -> user.equals(usuarioData.usuario))
                    .collect(Collectors.toList());
            //scanner y filter

            if(usuario.size() > 0){

                System.out.println("Introduce la contraseña: ");

                String passw = in.nextLine();

                if(usuario.get(0).contrasenya.equals(passw)){
                    System.out.printf("Bienvenido %s", usuario.get(0).usuario);
                }else{
                    System.out.println("Contraseña incorrecta, vuelva a intentarlo");
                }
            }else{
                System.out.println("No existe tal usuario en nuestra b6ase de datos");
            }

            connection.close();

             */

            Statement statement = connection.createStatement();

            /*String myTableName = "CREATE TABLE Clientes ("
                    + "nombre VARCHAR(32) NOT NULL,"
                    + "apellido VARCHAR(32) NOT NULL,"
                    + "DNI CHAR(9),"
                    + "CP CHAR(5),"
                    + "PRIMARY KEY(DNI))";


            //This line has the issue
            statement.executeUpdate(myTableName);*/

            /*String InsertameEsta = "INSERT INTO Clientes ( "
                    + " nombre,                 "
                    + " apellido,                   "
                    + " DNI,             "
                    + " CP)                   "
                    + "VALUES (                   "
                    + " 'Paco',                        "
                    + " 'Manteca',                        "
                    + " '72599395X',                        "
                    + " 20100),                             "
                    + "(                   "
                    + " 'Pipi',                        "
                    + " 'Trancaslargas',                        "
                    + " '72599396X',                        "
                    + " 20100);                             ";


            statement.executeUpdate(InsertameEsta);*/

            /*String ActualizameEsta = "UPDATE Clientes  "
                    + "SET nombre = 'Adriang', apellido = 'Prime'                 "
                    + "Where DNI = '72599396X';";


            statement.executeUpdate(ActualizameEsta);

            String InsertameEstaOtra = "INSERT INTO Clientes ( "
                    + " nombre,                 "
                    + " apellido,                   "
                    + " DNI,             "
                    + " CP)                   "
                    + "VALUES (                   "
                    + " 'Uwu',                        "
                    + " 'TuBB',                        "
                    + " '72599375X',                        "
                    + " 20100);                             ";


            statement.executeUpdate(InsertameEstaOtra);

            String BorrameEsta = "DELETE FROM Clientes "
                    + " WHERE DNI = '72599375X';                             ";


            statement.executeUpdate(BorrameEsta);*/

            /*String seleccionameEsta = "SELECT * FROM Clientes;";

            ArrayList<String> allClientes = new ArrayList<>();*/

            /*ResultSet clientes = statement.executeQuery(seleccionameEsta);
            while (clientes.next()) {

                allClientes.add(clientes.getString(1) + " " + clientes.getString(2) + " " + clientes.getString(3) + " " + clientes.getString(4));

            }

            allClientes.forEach((c) -> {System.out.println(c);});*/

            //allClientes.clear();

            /*System.out.println("Introduce un usuario: ");

            Scanner in = new Scanner(System.in);

            String cliUser = in.nextLine();

            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Clientes WHERE DNI = ?");
            stmt.setString(1, cliUser);

            ResultSet clientes = stmt.executeQuery();
            while (clientes.next()) {

                allClientes.add(clientes.getString(3));

            }

            //scanner y filter

            if(allClientes.size() > 0){

                System.out.println("Introduce la contraseña: ");

                String passw = in.nextLine();

                if(allClientes.get(0).equals(passw)){
                    System.out.printf("Bienvenido al sistema");
                }else{
                    System.out.println("Contraseña incorrecta, vuelva a intentarlo");
                }
            }else{
                System.out.println("No existe tal usuario en nuestra b6ase de datos");
            }*/



            /*connection.setAutoCommit(false);

            String pnj1 = "INSERT INTO Clientes ( "
                    + " nombre,                 "
                    + " apellido,                   "
                    + " DNI,             "
                    + " CP)                   "
                    + "VALUES (                   "
                    + " 'Anderio',                        "
                    + " 'Fauno',                        "
                    + " '72598375X',                        "
                    + " 20100);                             ";


            statement.executeUpdate(pnj1);

            String pnj2 = "INSERT INTO Clientes ( "
                    + " nombre,                 "
                    + " apellido,                   "
                    + " DNI,             "
                    + " CP)                   "
                    + "VALUES (                   "
                    + " 'Eidrien',                        "
                    + " 'Prime',                        "
                    + " '72898375X',                        "
                    + " 20100);                             ";


            statement.executeUpdate(pnj2);

            try{
                statement.executeUpdate(pnj2);
                connection.commit();
            }catch (SQLException e){
                e.printStackTrace();
                System.out.println("\nse hace rollback\n");
                connection.rollback();
            }finally {

            }*/

            /*String facturas = "CREATE TABLE facturas ("
                    + "id INT NOT NULL AUTO_INCREMENT,"
                    + "details VARCHAR(32),"
                    + "PRIMARY KEY(id));";


            //This line has the issue
            statement.executeUpdate(facturas);*/

            /*String factura1 = "INSERT INTO facturas ( "
                    + " details)                   "
                    + "VALUES (                   "
                    + " 'pon tu numero de cuenta');                             ";


            statement.executeUpdate(factura1, Statement.RETURN_GENERATED_KEYS);

            ResultSet ids = statement.getGeneratedKeys();

            while (ids.next()) {
                System.out.println("el id es: " + ids.getInt(1));
            }*/


            /*String productos = "CREATE TABLE PRODUCTOS ("
                    + "id INT NOT NULL AUTO_INCREMENT,"
                    + "nombre VARCHAR(32),"
                    + "precio DOUBLE,"
                    + "cantidad NUMERIC,"
                    + "peso DOUBLE,"
                    + "fechaCad DATE,"
                    + "especificacion VARCHAR(32),"
                    + "tipo VARCHAR(32),"
                    + "PRIMARY KEY(id));";


            //This line has the issue
            statement.executeUpdate(productos);*/

            listaProductos.forEach(producto -> {
                String[] propiedades = producto.volcar().split(" ");

                String query = "";

                String tipo = propiedades[propiedades.length - 1].trim();

                switch (tipo){
                    case "Herramienta":
                        query = "INSERT INTO PRODUCTOS ( "
                                + " nombre,                 "
                                + " precio,                   "
                                + " cantidad,             "
                                + " peso,                   "
                                + " tipo)                   "
                                + "VALUES (                   "
                                + " '" + producto.getNombre() + "',                        "
                                + " " + producto.getPrecio() + ",                        "
                                + " " + producto.getCantidad() + ",                        "
                                + " " + producto.getPeso() + ",                        "
                                + " '" + tipo + "');                             ";
                        break;
                    case "Otros":
                        query = "INSERT INTO PRODUCTOS ( "
                                + " nombre,                 "
                                + " precio,                   "
                                + " cantidad,             "
                                + " peso,                   "
                                + " especificacion,                   "
                                + " tipo)                   "
                                + "VALUES (                   "
                                + " '" + producto.getNombre() + "',                        "
                                + " " + producto.getPrecio() + ",                        "
                                + " " + producto.getCantidad() + ",                        "
                                + " " + producto.getPeso() + ",                        "
                                + " '" + propiedades[propiedades.length - 2] + "',                        "
                                + " '" + tipo + "');                             ";
                        break;
                    default:
                        String[] fechaSplit = propiedades[5].split("/");

                        String fechaParaMaria = fechaSplit[2] + "-" + fechaSplit[1] + "-" + fechaSplit[0];

                        query = "INSERT INTO PRODUCTOS ( "
                                + " nombre,                 "
                                + " precio,                   "
                                + " cantidad,             "
                                + " peso,                   "
                                + " fechaCad,                 "
                                + " especificacion,                   "
                                + " tipo)                   "
                                + "VALUES (                   "
                                + " '" + producto.getNombre() + "',                        "
                                + " " + producto.getPrecio() + ",                        "
                                + " " + producto.getCantidad() + ",                        "
                                + " " + producto.getPeso() + ",                        "
                                + " '" + fechaParaMaria + "',                        "
                                + " '" + propiedades[propiedades.length - 2] + "',                        "
                                + " '" + tipo + "');                             ";
                        break;
                }

                try {
                    statement.executeUpdate(query);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            });


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addNuevoProducto(Producto producto){


        try  {

            Connection connection = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3316/anderioPrime",
                    "root", "root"
            );

            PreparedStatement stmt;

            String[] propiedades = producto.volcar().split(" ");

            String query = "";

            String tipo = propiedades[propiedades.length - 1].trim();

            switch (tipo){
                case "Herramienta":
                    query = "INSERT INTO PRODUCTOS ( "
                            + " nombre,                 "
                            + " precio,                   "
                            + " cantidad,             "
                            + " peso,                   "
                            + " tipo)                   "
                            + "VALUES (                   "
                            + " ?,                        "
                            + " ?,                        "
                            + " ?,                        "
                            + " ?,                        "
                            + " ?);                             ";
                    
                    stmt = connection.prepareStatement(query);
                    stmt.setString(1, producto.getNombre());
                    stmt.setDouble(2, producto.getPrecio());
                    stmt.setInt(3, producto.getCantidad());
                    stmt.setDouble(4, producto.getPeso());
                    stmt.setString(5, tipo);
                    break;
                case "Otros":
                    query = "INSERT INTO PRODUCTOS ( "
                            + " nombre,                 "
                            + " precio,                   "
                            + " cantidad,             "
                            + " peso,                   "
                            + " especificacion,                   "
                            + " tipo)                   "
                            + "VALUES (                   "
                            + " ?,                        "
                            + " ?,                        "
                            + " ?,                        "
                            + " ?,                        "
                            + " ?,                        "
                            + " ?);                             ";

                    stmt = connection.prepareStatement(query);
                    stmt.setString(1, producto.getNombre());
                    stmt.setDouble(2, producto.getPrecio());
                    stmt.setInt(3, producto.getCantidad());
                    stmt.setDouble(4, producto.getPeso());
                    stmt.setString(5, propiedades[propiedades.length - 2]);
                    stmt.setString(6, tipo);
                    break;
                default:
                    String[] fechaSplit = propiedades[5].split("/");

                    String fechaParaMaria = fechaSplit[2] + "-" + fechaSplit[1] + "-" + fechaSplit[0];

                    query = "INSERT INTO PRODUCTOS ( "
                            + " nombre,                 "
                            + " precio,                   "
                            + " cantidad,             "
                            + " peso,                   "
                            + " fechaCad,                 "
                            + " especificacion,                   "
                            + " tipo)                   "
                            + "VALUES (                   "
                            + " ?,                        "
                            + " ?,                        "
                            + " ?,                        "
                            + " ?,                        "
                            + " ?,                        "
                            + " ?,                        "
                            + " ?);  ";

                        stmt = connection.prepareStatement(query);
                        stmt.setString(1, producto.getNombre());
                        stmt.setDouble(2, producto.getPrecio());
                        stmt.setInt(3, producto.getCantidad());
                        stmt.setDouble(4, producto.getPeso());
                        stmt.setString(5, fechaParaMaria);
                        stmt.setString(6, propiedades[propiedades.length - 2]);
                        stmt.setString(7, tipo);
                    break;
            }

            stmt.executeQuery();

        }catch(SQLException e){
            
            e.printStackTrace();
        }
    }

    public static void mostrarProductos(){
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3316/anderioPrime",
                    "root", "root");

            try (PreparedStatement statement = connection.prepareStatement("""
            SELECT *
            FROM PRODUCTOS
        """)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {

                    ResultSetMetaData metadata = resultSet.getMetaData();

                    int columnCount = metadata.getColumnCount();

                    switch (resultSet.getString(columnCount)){
                        case "Herramienta":
                            Herramienta herramienta = new Herramienta(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getInt(4), resultSet.getDouble(5));
                            System.out.println(herramienta.volcar());
                            break;
                        case "Otros":
                            Otros otros = new Otros(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getInt(4), resultSet.getDouble(5), resultSet.getString(7));
                            System.out.println(otros.volcar());
                            break;
                        case "FrutaHortaliza":
                            FrutaHortaliza frutaHortaliza = new FrutaHortaliza(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getInt(4), resultSet.getDouble(5), resultSet.getString(6), resultSet.getString(7));
                            System.out.println(frutaHortaliza.volcar());
                            break;
                        case "Bebida":
                            Bebida bebida = new Bebida(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getInt(4), resultSet.getDouble(5), resultSet.getString(6), resultSet.getString(7));
                            System.out.println(bebida.volcar());
                            break;
                        case "Lacteo":
                            Lacteo lacteo = new Lacteo(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getInt(4), resultSet.getDouble(5), resultSet.getString(6), resultSet.getString(7));
                            System.out.println(lacteo.volcar());
                            break;
                    }

                }
            }



        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static Producto getProducto(int id){

        try {

            Connection connection = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3316/anderioPrime",
                    "root", "root"
            );

            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM PRODUCTOS WHERE id = ?;");
            stmt.setInt(1, id);

            ResultSet productoSelec = stmt.executeQuery();

            ResultSetMetaData metadata = productoSelec.getMetaData();
            int columnCount = metadata.getColumnCount();

            productoSelec.next();

            switch (productoSelec.getString(columnCount)){
                case "Herramienta":
                    Herramienta herramienta = new Herramienta(0, productoSelec.getString(2), productoSelec.getDouble(3), productoSelec.getInt(4), productoSelec.getDouble(5));
                    return herramienta;
                case "Otros":
                    Otros otros = new Otros(0, productoSelec.getString(2), productoSelec.getDouble(3), productoSelec.getInt(4), productoSelec.getDouble(5), productoSelec.getString(7));
                    return otros;
                case "FrutaHortaliza":
                    FrutaHortaliza frutaHortaliza = new FrutaHortaliza(0, productoSelec.getString(2), productoSelec.getDouble(3), productoSelec.getInt(4), productoSelec.getDouble(5), productoSelec.getString(6), productoSelec.getString(7));
                    return frutaHortaliza;
                case "Bebida":
                    Bebida bebida = new Bebida(0, productoSelec.getString(2), productoSelec.getDouble(3), productoSelec.getInt(4), productoSelec.getDouble(5), productoSelec.getString(6), productoSelec.getString(7));
                    return bebida;
                case "Lacteo":
                    Lacteo lacteo = new Lacteo(0, productoSelec.getString(2), productoSelec.getDouble(3), productoSelec.getInt(4), productoSelec.getDouble(5), productoSelec.getString(6), productoSelec.getString(7));
                    return lacteo;
                }

        } catch (SQLException throwables) {
            System.out.println("Introduce un Código válido");
        }
        return null;
    }

    public static Producto actualizarCantidad(int codigo, int cantidad){

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3316/anderioPrime",
                    "root", "root"
            );

            PreparedStatement stmt = connection.prepareStatement("UPDATE PRODUCTOS SET cantidad = ? WHERE id = ?;");
            stmt.setInt(1, cantidad);
            stmt.setInt(2, codigo);

            ResultSet actualizarCant = stmt.executeQuery();

            return getProducto(codigo);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int tamanyo(){

        int tamanyo = 0;

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3316/anderioPrime",
                    "root", "root"
            );

            PreparedStatement stmt = connection.prepareStatement("" +
                    "select\n" +
                    "        count(*) row_count\n" +
                    "                from\n" +
                    "        PRODUCTOS;");

            ResultSet tamanyoRS = stmt.executeQuery();

            tamanyoRS.next();

            tamanyo = tamanyoRS.getInt(1);



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tamanyo;
    }

    public static void mostrarProductosEnviables(){
        try{
            Connection connection = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3316/anderioPrime",
                    "root", "root");

            try (PreparedStatement statement = connection.prepareStatement("""
            SELECT *
            FROM PRODUCTOS
            WHERE tipo != 'Otros'
        """)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {

                    ResultSetMetaData metadata = resultSet.getMetaData();

                    int columnCount = metadata.getColumnCount();

                    switch (resultSet.getString(columnCount)){
                        case "Herramienta":
                            Herramienta herramienta = new Herramienta(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getInt(4), resultSet.getDouble(5));
                            System.out.println(herramienta.volcar());
                            break;
                        case "Otros":
                            Otros otros = new Otros(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getInt(4), resultSet.getDouble(5), resultSet.getString(7));
                            System.out.println(otros.volcar());
                            break;
                        case "FrutaHortaliza":
                            FrutaHortaliza frutaHortaliza = new FrutaHortaliza(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getInt(4), resultSet.getDouble(5), resultSet.getString(6), resultSet.getString(7));
                            System.out.println(frutaHortaliza.volcar());
                            break;
                        case "Bebida":
                            Bebida bebida = new Bebida(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getInt(4), resultSet.getDouble(5), resultSet.getString(6), resultSet.getString(7));
                            System.out.println(bebida.volcar());
                            break;
                        case "Lacteo":
                            Lacteo lacteo = new Lacteo(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getInt(4), resultSet.getDouble(5), resultSet.getString(6), resultSet.getString(7));
                            System.out.println(lacteo.volcar());
                            break;
                    }

                }
            }



        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void eliminarProducto(int id){
        try  {

            Connection connection = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3316/anderioPrime",
                    "root", "root"
            );

            PreparedStatement stmt = connection.prepareStatement("DELETE FROM PRODUCTOS WHERE id = ?;");

            stmt.setInt(1, id);

            

            stmt.executeQuery();

        }catch(SQLException e){
            
            System.out.println("Introduce un Código válido");
        }
    }

    @Override
    public Iterator iterator() {
        return listaProductos.iterator();
    }
}
