package Clases;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Scanner;

@Entity
@Table(name = "Producto")
public class Producto implements Serializable {

    private double iva;
    private int codigo;
    private String nombre;
    private double precio;
    private int cantidad;
    private double peso;

    public Producto(int codigo, String nombre, double precio, int cantidad, double peso) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.peso = peso;
    }

    public Producto(Scanner in){

        System.out.println("Introduce el nombre del producto (string):");

        while (true){

            try{
                nombre = in.nextLine();
                break;
            }catch (Exception e){
                System.out.println("nombre incorrecto, vuelva a introducirlo");
            }

        }

        System.out.println("Introduce el precio del producto por unidad en €:");

        while (true){

            try{
                precio = in.nextDouble();
                break;
            }catch (Exception e){
                System.out.println("Precio incorrecto, vuelva a introducirlo");
            }finally {
                in.nextLine();
            }

        }

        System.out.println("Introduce la cantidad (número de unidades):");

        while (true){

            try{
                cantidad = in.nextInt();
                break;
            }catch (Exception e){
                System.out.println("Cantidad incorrecta, vuelva a introducirlo");
            }finally {
                in.nextLine();
            }

        }

        System.out.println("Introduce el peso del producto por unidad (en kg):");

        while (true){

            try{
                peso = in.nextDouble();
                break;
            }catch (Exception e){
                System.out.println("Peso incorrecto, vuelva a introducirlo");
            }finally {
                in.nextLine();
            }

        }
    }

    public Producto(){
    }


    @Column(name = "iva")
    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    @Id
    @GeneratedValue
    @Column(name = "codigo", unique = true , nullable = false )
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Column(name = "nombre", length = 50)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "precio")
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Column(name = "cantidad")
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Column(name = "peso")
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double calcularPrecioIVA(){

        return (precio * getIva()) + precio;
    }

    public void imprimir(){
        System.out.printf("Id: %d, ", codigo);
        System.out.printf("Nombre: %s, ", nombre);
        System.out.printf("Cantidad: %d, ", cantidad);
        System.out.printf("Precio: %.2f, ", precio);
    }

    public void imprimirEnvio(){

        System.out.printf("Producto: %s\n", nombre);
        System.out.printf("Producto número: %f\n", peso);
        System.out.printf("Precio del producto: %f\n", precio);
        System.out.printf("Precio IVA incluído: %f\n", calcularPrecioIVA());

    }

    public String volcar(){

        String productInfo = "";

        productInfo = getCodigo() + " " + getNombre() + " " + getPrecio() + " " + getCantidad() + " " + getPeso();

        return productInfo;
    }
}
