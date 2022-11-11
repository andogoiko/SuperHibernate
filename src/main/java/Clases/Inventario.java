package Clases;

import Interfaces.Enviable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventario{

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("supermercat");
    private static EntityManager manager = emf.createEntityManager();


    public static void addNuevoProducto(Producto producto){

        manager.getTransaction().begin();
        manager.persist(producto);

        manager.getTransaction().commit();

    }

    public static void mostrarProductos(){

        List<Producto> productos = (List<Producto>) manager.createQuery("FROM Producto").getResultList();

        productos.forEach((e) -> System.out.println(e.volcar()));

        System.out.printf("Hay %d productos.\n", productos.size());

    }

    public static Producto getProducto(int id){

        Query q = manager.createQuery("FROM Producto WHERE codigo = :ClassVariableId");
        q.setParameter("ClassVariableId", id);

        Producto producto = (Producto)q.getResultList().get(0);

        return producto;

    }

    public static Producto actualizarCantidad(int codigo, int cantidad){
        Query q = manager.createQuery("FROM Producto WHERE codigo = :ClassVariableId");
        q.setParameter("ClassVariableId", codigo);

        Producto producto = (Producto)q.getResultList().get(0);
        producto.setCantidad(cantidad);

        return producto;
    }

    public static int tamanyo(){

        List<Producto> productos = (List<Producto>) manager.createQuery("FROM Producto").getResultList();

        return productos.size();
    }

    public static void mostrarProductosEnviables(){

        List<Producto> productos = (List<Producto>) manager.createQuery("FROM Producto").getResultList();

        productos.forEach((e) -> {
            if(e instanceof Enviable){
                System.out.println(e.volcar());
            }
        });

    }

    public static void eliminarProducto(int id){
        Query q = manager.createQuery("DELETE FROM Producto WHERE codigo = :ClassVariableId");
        q.setParameter("ClassVariableId", id);

        manager.getTransaction().begin();
        q.executeUpdate();
        manager.getTransaction().commit();
    }

}
