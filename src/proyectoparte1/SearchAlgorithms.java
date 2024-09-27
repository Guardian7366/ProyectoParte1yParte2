package proyectoparte1;

/**
 * Clase SearchAlgorithms : en esta clase se tendran todos los metodos de busqueda para listas enlazadas
 * @author David Silva
 */
public class SearchAlgorithms {
    
    /**
     * Metodo sequentialSearch : buscar un elemento en una lista por medio de secuencia
     * @param list : la lista en la que se buscara el elemento
     * @param target : el elemento que se buscara
     * @return : si se ha encontrado el elemento en la lista
     */
    public boolean sequentialSearch(LinkedList list, int target) {
        Node current = list.getHead(); //Obtenemos la cabezara de la lista y lo guardamos en una variable
        
        //Mientras el nodo apuntador sea diferente de nulo entonces...
        while (current != null) {
            
            //Si el la información del nodo es igual a la del objetivo entonces...
            if (current.getData() == target) {
                return true;  //Quiere decir que hemos encontrado el elemento y retornamos True
            }
            current = current.getNext(); //Si no, avanzamos al siguiente nodo
        }
        
        //Si despues de este ciclo que recorre toda la lista no se encontro entonces...
        return false;  //Retornamos false de que no se encontro el objetivo
    }

    /**
     * Metodo binarySearch : Buscar un elemento en una lista enlazada por medio de busqueda binaria
     * @param list : la lista en la que se buscara el elemento
     * @param target : el elemento que se buscara
     * @return : si se encontro el elemento en la lista o no
     */
    public boolean binarySearch(LinkedList list, int target) {
        int left = 0; //Iniciamos la variable para el inicio de la lista
        int right = list.size() - 1; //Iniciamos la variable para el final de la lista

        // Convert linked list to an array for binary search logic
        
        //Convertimos la lista enlazada en un array normal para la busqueda binaria
        //Mientras la derecha sea mayor que la izquierda entonces...
        while (left <= right) {
            int middle = left + (right - left) / 2; //Obtenemos la mitad apartir de los calculos necesarios
            
            //Por cada iteración que hagamos vamor a ir pasando la misma lista pero un diferente medio
            //Este metodo va a retornar el nodo que se encuentre antes del medio actual
            //Esto se ira ajustando conforme el ciclo while para llegar con el numero correcto
            //Lo que retorne lo guardamos en middleValue
            int middleValue = getNodeAtIndex(list, middle).getData();
            
            //Si el valor del medio de vuelto es igual al objetivo entonces...
            if (middleValue == target) {
                return true;  //Significa que encontramos el valor y retornamos true
            
            //Si el valor del medio es menor que el objetivo entonces...
            } else if (middleValue < target) {
                left = middle + 1;  //Hacemos la modificación para buscar hacia la derecha de la lista
            } else { //De lo contrario si es mayor...
                right = middle - 1;  //Hacemos la modificación para buscar hacia la izquierda de la lista
            }
        }

        return false;  //Retornamos falso en caso de que no se encontrara algun valor igual al objetivo en la lista.
    }

    /**
     * Metodo getNodeAtIndex : metodo que ayuda a la busqueda binaria para obtener el nodo
     * @param list : la lista que se desea recorrer para la busqueda
     * @param index : hasta donde llegara la busqueda dentro de la lista enlazada
     * @return : retornamos el nodo que se encuentre en medio
     */
    private Node getNodeAtIndex(LinkedList list, int index) {
        Node current = list.getHead(); //Obtenemos el nodo que se encuentre en la cabeza de la lista actual
        int currentIndex = 0; //Iniciamos un contador en cero

        // Traverse the list until we reach the desired index
        
        //Iniciamos un bucle para llegar al index deseado
        //Mientras el nodo actual sea diferente de nulo Y
        //El contador sea menor al index indicado 
        while (current != null && currentIndex < index) {
            current = current.getNext(); //Avanzamos al siguiente nodo
            currentIndex++; //Incrementamos el contador 
        }
        
        return current; //Devolvemos el nodo hasta donde llego el recorrido.
    }
}
