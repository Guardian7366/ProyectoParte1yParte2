package proyectoparte1;

/**
 * Clase Node : se encarga de manejar los nodos de la lista enlazada
 * @author David Silva
 */
public class Node {
    private int data; //La información que contiene el nodo
    private Node next; //El siguiente nodo que sigue
    
    /**
     * Metodo constructor de la clase Node
     * @param data : la información que guardara el nodo
     */
    public Node(int data) {
        this.data = data; //Inicializamos la información del nodo
        this.next = null; //Inicializamos de momento en null el siguiente nodo
    }
    
    /**
     * Metodo getData : obtener la información actual del nodo
     * @return : la información del nodo
     */
    public int getData() {
        return data; //Retornamos la información del nodo
    }
    
    /**
     * Metodo setData : actualizar la información del nodo
     * @param data : la información nueva del nodo
     */
    public void setData(int data) {
        this.data = data; //Actualizamos la información por la nueva información
    }
    
    /**
     * Metodo getNext : Obtener el siguiente nodo 
     * @return : el siguiente nodo
     */
    public Node getNext() {
        return next; //Retornamos el siguiente nodo
    }
    
    /**
     * Metodo setNext : actualizamos el siguiente nodo
     * @param next : el nodo que sigue
     */
    public void setNext(Node next) {
        this.next = next; //Actualizamos el valor de siguiente en el nodo
    }
     
}