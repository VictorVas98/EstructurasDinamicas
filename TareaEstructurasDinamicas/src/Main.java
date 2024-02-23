import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<>();
        int opcion;

        do {
            System.out.println("Escoge la opción que deseas realizar:");
            System.out.println("1. Insertar un elemento al principio");
            System.out.println("2. Insertar un elemento al final");
            System.out.println("3. Recorrer la lista hacia adelante");
            System.out.println("4. Recorrer la lista hacia atrás");
            System.out.println("5. Mostrar el tamaño de la lista");
            System.out.println("6. Mostrar si la lista está vacía");
            System.out.println("7. Buscar elemento por valor");
            System.out.println("8. Buscar elemento por índice");
            System.out.println("9. Borrar un Elemento");
            System.out.println("0. Salir");
            System.out.println("Ingresa la Opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el valor para insertar al principio: ");
                    int valorInicio = scanner.nextInt();
                    lista.insertarAlInicio(valorInicio);
                    break;
                case 2:
                    System.out.print("Ingresa el valor para insertar al final: ");
                    int valorFinal = scanner.nextInt();
                    lista.insertarAlFinal(valorFinal);
                    break;
                case 3:
                    System.out.println("Recorriendo la lista hacia adelante:");
                    lista.recorrerHaciaAdelante();
                    break;
                case 4:
                    System.out.println("Recorriendo la lista hacia atrás:");
                    lista.recorrerHaciaAtras();
                    break;
                case 5:
                    System.out.println("El tamaño de la lista es de: " + lista.obtenerTamaño());
                    break;
                case 6:
                    System.out.println("¿Lista vacia?: " + lista.estaVacia());
                    break;
                case 7:
                    System.out.print("Ingresa el valor para buscar: ");
                    int valorBuscar = scanner.nextInt();
                    System.out.println("El elemento es de: " + lista.buscarElemento(valorBuscar));
                    break;
                case 8:
                    System.out.print("Ingresa el índice a buscar: ");
                    int indiceBuscar = scanner.nextInt();
                    System.out.println("El elemento es: " + lista.buscarElementoPorIndice(indiceBuscar));
                    break;
                case 9:
                    System.out.print("Ingrese el valor a borrar: ");
                    int valorBorrar = scanner.nextInt();
                    lista.borrarElemento(valorBorrar);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese un número válido.");
            }
        } while (opcion != 0);
        scanner.close();
    }
}