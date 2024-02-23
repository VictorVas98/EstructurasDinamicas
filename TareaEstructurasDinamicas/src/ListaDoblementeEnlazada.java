public class ListaDoblementeEnlazada<E> {
    private Node<E> cabeza;
    private Node<E> cola;
    private int tamaño = 0;
    public void insertarAlInicio(E valor) {
        Node<E> nuevoNodo = new Node<E>(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            nuevoNodo.next = cabeza;
            cabeza.prev = nuevoNodo;
            cabeza = nuevoNodo;
        }
        tamaño++;
    }
    public void insertarAlFinal(E valor) {
        Node<E> nuevoNodo = new Node<E>(valor);
        if (cola == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            nuevoNodo.prev = cola;
            cola.next = nuevoNodo;
            cola = nuevoNodo;
        }
        tamaño++;
    }
    public void recorrerHaciaAdelante() {
        Node<E> temporal = cabeza;
        while (temporal != null) {
            System.out.println(temporal.item);
            temporal = temporal.next;
        }
    }
    public void recorrerHaciaAtras() {
        Node<E> temporal = cola;
        while (temporal != null) {
            System.out.println(temporal.item);
            temporal = temporal.prev;
        }
    }
    public int obtenerTamaño() {
        return tamaño;
    }
    public boolean estaVacia() {
        return tamaño == 0;
    }
    public E buscarElemento(E valor) {
        Node<E> temporal = cabeza;
        while (temporal != null) {
            if (temporal.item.equals(valor)) {
                return temporal.item;
            }
            temporal = temporal.next;
        }
        return null;
    }
    public E buscarElementoPorIndice(int indice) {
        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        Node<E> temporal = cabeza;
        for (int i = 0; i < indice; i++) {
            temporal = temporal.next;
        }
        return temporal.item;
    }
    public void borrarElemento(E valor) {
        Node<E> temporal = cabeza;
        while (temporal != null) {
            if (temporal.item.equals(valor)) {
                if (temporal == cabeza) {
                    cabeza = temporal.next;
                    if (cabeza != null) {
                        cabeza.prev = null;
                    }
                } else if (temporal == cola) {
                    cola = temporal.prev;
                    cola.next = null;
                } else {
                    temporal.prev.next = temporal.next;
                    temporal.next.prev = temporal.prev;
                }
                tamaño--;
                return;
            }
            temporal = temporal.next;
        }
    }
    public class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        public Node(T item) {
            this.item = item;
        }
    }
}