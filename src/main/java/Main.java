import Clases.*;

import java.util.Scanner;

public class Main {

    private static Scanner scannerGlobal = new Scanner(System.in);

    public static void main(String[] args){

        Inventario.getInstance();

        int opcion = 1;

        System.out.println("========================================================================");
        System.out.println("=                 SISTEMA DE GESTION DE SUPER-ON-LINE                  =");
        System.out.println("========================================================================");
        System.out.println();
        System.out.println();


        while (opcion != 0) {
            mostrarMenuInventario();
            System.out.println("Opción? ");
            opcion = leerOpcion(5);
            switch(opcion) {
                case 0:	System.out.println("Termina la aplicación");
                    System.exit(0);
                /*case 1: Inventario.cargarProductos();
                    pause();
                    break; // cargar productos*/
                case 1: Inventario.mostrarProductos();
                    pause();
                    break;
                case 2:     //actualizar la cantidad de un producto en almancÃ©n
                    Producto p;
                    while (opcion!=0) {
                        Inventario.mostrarProductos();
                        System.out.println("0 - Finalizar actualizaciÃ³n del inventario");
                        System.out.println("Elige el nÃºmero del producto a actualizar, tecla:x (/= 0):");
                        System.out.println("OpciÃ³n? ");
                        opcion = scannerGlobal.nextInt();
                        scannerGlobal.nextLine();
                        p = Inventario.getProducto(opcion);
                        if (opcion!=0 && p != null) {
                            System.out.println("Producto elegido: "+p.getNombre()+", existencias: "+p.getCantidad());
                            System.out.println("Elige la nueva cantidad:");
                            int cant = scannerGlobal.nextInt();
                            scannerGlobal.nextLine();
                            p = Inventario.actualizarCantidad(opcion, cant);   //actualiza el mismo producto del inventario
                            //NO ES NECESARIA LA ACTUALIZACIÃ“N DESDE INVENTARIO!!
                            System.out.println("Producto actualizado: "+p.getNombre()+", Nueva cantidad en almacÃ©n: " + p.getCantidad());
                            System.out.println();
                            pause();
                        }
                    } opcion=1; break;
                case 3: 	//aÃ±adir un nuevo producto al almancÃ©n
                    while (opcion!=0) {
                        mostrarMenuAddNuevoProducto();
                        System.out.println("Opción? ");
                        opcion = leerOpcion(5); // 5 clases de productos y salida del menÃº
                        if (opcion!=0) {
                            Producto P = nuevoProducto(opcion);
                            Inventario.addNuevoProducto(P);
                            //System.out.println("Producto añadido, número "+Inventario.tamanyo());
                            P.imprimir(); //imprime el Ãºltimo producto incluido
                            System.out.println();
                            System.out.println();
                            pause();
                        }
                    } opcion=1; break;
                case 4: Inventario.mostrarProductosEnviables();
                    pause();
                    break;
                case 5:
                    Inventario.mostrarProductos();
                    System.out.println("Elija el producto que desea eliminar:");
                    opcion = scannerGlobal.nextInt();
                    scannerGlobal.nextLine();
                    Inventario.eliminarProducto(opcion);
                    pause();
                    break;
            }
        }
    }

    public static void mostrarMenuInventario() {// ver productos del super ordenados
        System.out.println("====================================================================");
        System.out.println("=            MENU PRINCIPAL - GESTIÓN DE INVENTARIO                =");
        System.out.println("====================================================================");
        //System.out.println("            tecla:1   - Cargar productos");
        System.out.println("            tecla:1   - Mostrar inventario");
        System.out.println("            tecla:2   - Actualizar existencias");
        System.out.println("            tecla:3   - Añadir nuevo producto");
        System.out.println("            tecla:4   - Mostrar productos enviables");
        System.out.println("            tecla:5   - Eliminar Producto");
        System.out.println("            tecla:0   - Terminar");
        System.out.println("====================================================================");
    }


    public static void mostrarMenuAddNuevoProducto() {// ver productos y escoger uno
        System.out.println("====================================================");
        System.out.println("=   Elige el tipo de producto que quieres añadir:  =");
        System.out.println("====================================================");
        System.out.println("         tecla:1 - Lacteo");
        System.out.println("         tecla:2 - Frutas u hortalizas");
        System.out.println("         tecla:3 - Bebidas");
        System.out.println("         tecla:4 - Herramientas");
        System.out.println("         tecla:5 - Otros");
        System.out.println("         tecla:0 - Cancelar");
        System.out.println("====================================================");
    }

    public static Producto nuevoProducto (int n) {
        Scanner es = new Scanner (System.in);
        Producto P;
        switch(n) {
            case 1: P = new Lacteo(es);break;
            case 2: P = new FrutaHortaliza(es);break;
            case 3: P = new Bebida(es);break;
            case 4: P = new Herramienta(es);break;
            default: P = new Otros(es);break;
        }
        return P;
    }

    private static void pause() {
        System.out.println("(pulsa 0 para continuar...");
        leerOpcion(1);
    }


    private static int leerOpcion(int max){

        Scanner scannerMenu = new Scanner(System.in);

        int opcion;

        while (true){

            try{
                opcion = scannerMenu.nextInt();

                if(opcion <= max){
                    break;
                }else{
                    System.out.println("No existe esa opción");
                }

            }catch (Exception e){
                System.out.println("Introduce un número entero!!!");
                scannerMenu.nextLine();
            }

        }


        return opcion;
    }
}
