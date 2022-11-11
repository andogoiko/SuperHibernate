package Clases;

import javax.persistence.Entity;
import java.util.Scanner;

@Entity
public abstract class NoPerecedero extends Producto{

    public NoPerecedero(int codigo, String nombre, double precio, int cantidad, double peso) {
        super(codigo, nombre, precio, cantidad, peso);
    }

    public NoPerecedero(){}

    public NoPerecedero(Scanner in){
        super(in);
    }

    @Override

    public void imprimir(){

        super.imprimir();
        System.out.printf("(Producto no perecedero), ");
    }
}
