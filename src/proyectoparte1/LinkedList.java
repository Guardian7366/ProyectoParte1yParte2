package proyectoparte1;

/**
 * Clase LinkedList : se encarga de manejar las listas enlazadas
 * @author David Silva
 */
public class LinkedList {
    private Node head;  //Variable para la cabeza de la lista enlazada
    private int size;  //Variable para el tamaño de la lista enlazada


    /**
     * Metodo constructor de la clase LinkedList
     * Inicializar una lista vacia
     */
    public LinkedList() {
        this.head = null; //Inicializamos la cabeza de la lista en null
        this.size = 0; //Inicializamos el tamaño de la lista en 0
    }

    /**
     * Metodo add : agregar elementos hasta el final de la lista
     * @param data 
     */
    public void add(int data) {
        Node newNode = new Node(data); //Primero creamos un nuevo nodo apartir de la información que queremos agregar
        
        //Si la cabeza de la lista esta vacia, esto quiere decir que no se ha agregado algun elemento todavia
        if (head == null) {
            head = newNode; //Establecemos el nuevo nodo como el inicio de lista o la cabeza
        } else { //Si la lista ya tiene almenos un elemento entonces...
            Node current = head; //Creamos un nodo apuntador apartir de la cabeza actual de la lista
            //Mientras el siguiente del nodo apuntador sea diferente a nulo entonces..
            while (current.getNext() != null) {
                current = current.getNext(); //Avanzamos al siguiente nodo por medio de su next
            }
            //Una vez que encontremos el ultimo nodo de la lista entonces...
            current.setNext(newNode); //Establecemos el next del ultimo nodo apuntando al nuevo nodo.
        }
        size++; //Incrementamos el tamaño de la lista cada que se agrega un nuevo nodo
    }

    /**
     * Metodo remove : remover el elemento que se le indique a la lista enlazada
     * @param data : el dato que se busca remover
     * @return : retonar si el elemento fue removido o no
     */
    public boolean remove(int data) {
        //Primero verificamos si la lista tiene la cabeza vacia
        if (head == null) { //Si esta vacia entonces...
            return false; //Retornamos falso porque no existe alguna lista en la que buscar el elemento.
        }
        
        //Verificamos que el dato de la cabeza sea igual al dato que se busca
        if (head.getData() == data) { //Si son iguales queire decir que es el primer elemento e que se encuentra
            head = head.getNext(); //Hacemos un salto hacia el siguiente nodo y de esa manera eliminamos el nodo
            size--; //Reducimos el tamaño de forma manual
            return true; //Retornamos true porque si se encontro el elemento
        }
        
        Node current = head; //Creamos un nodo apuntador apartir del nodo de la cabeza
        
        //Hacemos un ciclo while
        //Mientras el siguiente nodo sea diferente de nulo
        //Y el siguiente nodo sus datos son diferentes al valor buscado
        while (current.getNext() != null && current.getNext().getData() != data) {
            current = current.getNext(); //Avanzamos al siguiente nodo
        }
        
        //Verificamos que el siguiente nodo sea igual a nulo
        if (current.getNext() == null) { //Quiere decir que no encontramos el elemento
            return false; //Retornamos falso porque no encontramos el valor en algun nodo
        }
        
        //Establecemos el siguiente del nodo apuntador haciendo doble salto
        //De esta forma nos aseguramos de saltar el nodo que eliminamos y dejarlo afuera de la lista
        // Head - Nodo - Eliminado - Nodo - Null
        current.setNext(current.getNext().getNext()); 
        
        size--; //Reducimos el tamaño de la lista de forma manual
        return true; //Retornamos true porque si se elimino el elemento de la lista
    }

    /**
     * Metodo get : obtener un elemento en una posición dada
     * @param index : el indice del valor que queremos recuperar
     * @return : el elemento buscado en la lista
     */
    public int get(int index) {
        //Verificamos que el indice dado sea positivo y que este dentro del rango de la lista
        if (index < 0 || index >= size) { //Si el numero es erroneo
            throw new IndexOutOfBoundsException("Indice fuera de rango de la lista"); //Lanzamos una excepción de que el indice esta afuera de la lista
        }

        Node current = head; //Creamos un nodo apuntador apartir de la cabeza de la lista enlazada
        //Creamos un ciclo en el que recorre antes de del inidice dado para lelgar al nodo correcto
        for (int i = 0; i < index; i++) {
            current = current.getNext(); //Avanzamos al siguiente nodo de la lista
        }
        return current.getData(); //Obtenemos la información del nodo encontrado por medio de inidice
    }

    /**
     * Metodo contains : metodo para buscar si existe algun elemento dentro de la lista enlazada 
     * @param data : la informacion que vamos a buscar
     * @return : Si el elemento existe
     */
    public boolean contains(int data) {
        Node current = head; //Usamos como apuntador la cabeza de la lista
        
        //Mientras el nodo apuntador sea diferente de nulo
        while (current != null) {
            
            //Si la informacion del nodo es igual a la información que se busca entonces...
            if (current.getData() == data) {
                return true; //Retornamos true porque se encontro el nodo correcto
            }
            current = current.getNext(); //Avanzamos al siguiente nodo
        }
        return false; //Retornamos false porque no se encontro el nodo en ningun momento del ciclo
    }

    /**
     * Metodo size : obtener el tamaño actual de la lista enlazada
     * @return : el tamaño de la lista enlazada
     */
    public int size() { 
        return size; //Retornamos el tamaño de la lista
    }

    /**
     * Metodo printList : imprimir la lista actual en pantalla
     */
    public void printList() {
        Node current = this.head;  //Creamos un apuntador que sera la cabeza de la lista enlazada
        StringBuilder output = new StringBuilder(); //Creamos un Stringbuilder que nos servira para construir el output de esta lista
        
        //Mientras el nodo actual sea diferente de nulo entonces...
        while (current != null) {
            output.append(current.getData());  //Añadimos el nodo al Stringbuilder
            
            //Si el siguiente nodo es diferente de nulo entonces...
            if (current.getNext() != null) {
                output.append(" -> ");  //Agregamos esta flecha para indicar a que apunta el siguieten nodo
            }
            current = current.getNext();  //Avanzamos al siguiente nodo
        }
        //Si la condición no se cumple no se imprime flecha porque llegamos al final de la lista
        
        System.out.println(output.toString());  //Usamos el StringBuilder junto su toString para mostrar todos los elementos de la lista
    }

    /**
     * Metodo clone : devuelve una copia de una lista enlazada
     * @return : una copia de la lista enlazada
     */
    public LinkedList clone() {
        LinkedList newList = new LinkedList(); //Craemos una nueva lista enlazada que sera la que ten
        Node current = head; //Creamos un nodo apuntador que sera la cabeza actual de la lista que usa este metodo
        
        //Mientras el nodo apuntador sea diferente de nulo entonces...
        while (current != null) {
            newList.add(current.getData()); //Por medio del metodo add agregamos la información del nodo actual
            current = current.getNext(); //Avanzamos al siguiente nodo
        }

        return newList; //Retornamos la lista clonada que uso este metodo
    }
    
    /**
     * Metodo clear : limpiar la lista enlazada
     */
    public void clear() {
        head = null; //Reiniciamos la cabeza a null lo que quiere decir que la lista fue reiniciada
        size = 0; //Reiniciamos el tamaño a 0 elementos
    }   
    
    /**
     * Metodo getHead : obtener el nodo que se encuentre en la cabeza
     * @return : el nodo que sea la cabeza actual de la lista enlazada
     */
    public Node getHead() {
        return head; //La cabeza de la lista enlazada
    }
    
    /**
     * Metodo setHead : Establecer el valor para la cabeza de la lista
     * @param head : la nueva cabeza da la lista
     */
    public void setHead(Node head) {
        this.head = head; //Actualizamos la cabeza de la lista
    }

    
    
}