package daw;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * CÓDIGO CON CODESMELLING
 * 
 * TODO: Este código necesita un refactorización urgente.
 * - Eliminar la "Clase Dios" que es todo el main
 * - Usar programación orientada a objetos
 * - Eliminar números fijos introducidos en el código (no están dentro de
 * variables).
 * - Mejorar la gestión de logs (Patrón Singleton).
 */
public class Tienda {

    public static ArrayList<Productos> arrayProductos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = 0;

        // Datos de prueba iniciales
        arrayProductos.add(new Productos("Camiseta", 15.0, 10));
        arrayProductos.add(new Productos("Pantalón", 30.0, 5));
        arrayProductos.add(new Productos("Zapatos", 45.0, 2));

        while (op != 4) {
            System.out.println("\n--- TIENDA ---");
            System.out.println("1. Añadir producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Realizar venta");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            op = sc.nextInt();

            switch (op) {
                case 1 -> {
                    System.out.print("Nombre del producto: ");
                    String nombre = sc.next();
                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    System.out.print("Stock inicial: ");
                    int stock = sc.nextInt();

                    arrayProductos.add(new Productos(nombre, precio, stock));
                    System.out.println("Producto añadido correctamente.");
                }

                case 2 -> {
                    System.out.println("\n--- INVENTARIO ACTUAL ---");
                    if (arrayProductos.isEmpty()) {
                        System.out.println("No hay productos.");
                    } else {
                        for (int i = 0; i < arrayProductos.size(); i++) {
                            System.out.println(i + ". " + arrayProductos.get(i).getNombre() + " - "
                                    + arrayProductos.get(i).getPrecios()
                                    + "€ - Stock: " + arrayProductos.get(i).getStock());
                        }
                    }
                }
                case 3 -> {
                    System.out.println("\n--- VENTA ---");
                    System.out.print("Introduzca nombre del producto a vender: ");
                    String prod = sc.next();

                    int pos = -1;
                    for (int i = 0; i < arrayProductos.size(); i++) {
                        if (arrayProductos.get(i).getNombre().equalsIgnoreCase(prod)) {
                            pos = i;
                            break;
                        }
                    }

                    if (pos != -1) {
                        System.out.println("Producto encontrado: " + arrayProductos.get(pos).getNombre());
                        System.out.println("Precio: " + arrayProductos.get(pos).getPrecios() + "€ | Stock: "
                                + arrayProductos.get(pos).getStock());
                        System.out.print("Cantidad a comprar: ");
                        int cant = sc.nextInt();

                        if (arrayProductos.get(pos).getStock() >= cant) {
                            double total = cant * arrayProductos.get(pos).getPrecios();

                            if (total > 50) {
                                System.out.println("¡Oferta! Descuento aplicado por compra superior a 50€");
                                total = total * 0.90;
                            }

                            arrayProductos.get(pos).setStock((arrayProductos.get(pos).getStock() - cant));
                            System.out.println("Venta realizada. Total a pagar: " + total + "€");

                            // Debería ser Singleton
                            System.out.println("[LOG SYSTEM]: Venta de " + cant + "x "
                                    + arrayProductos.get(pos).getNombre() + " registrada.");
                            if (arrayProductos.get(pos).getStock() < 3) {
                                System.out.println("[LOG SYSTEM]: ALERTA DE STOCK BAJO para "
                                        + arrayProductos.get(pos).getNombre());
                            }

                        } else {
                            System.out.println("Error: No hay suficiente stock.");
                        }
                    } else {
                        System.out.println("Error: Producto no encontrado.");
                    }
                }
            }
        }
    }
}
