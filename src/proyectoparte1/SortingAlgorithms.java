package proyectoparte1;

/**
 * Clase SortingAlgorithms : se encargara de manejar todos los metodos de ordenamiento
 * @author David Silva
 */
public class SortingAlgorithms {
    
    /**
     * Metodo bubbleSort : ordenmaiento por medio de bubble sort para listas enlazadas
     * @param list : la lista enlazada a ordenar
     */
    public void bubbleSort(LinkedList list) {
        //Primero verificamos si la lista tiene un tamaño de 1 o menos
        if (list.size() <= 1) {
            return; //Retornamos porque no es necesario ordenar nada y se detiene la función
        }

        boolean swapped; //Creamos una variable para verificar cuando se han hecho los cambios

        //Creamos un ciclo do while para iniciar con los intercambios
        //Este ciclo se estare ejecutando hasta que la lista este completamente ordenada de inicio a final
        do {
            swapped = false; //De momento la variable swapped se establece en false
            
            Node current = list.getHead(); //Creamos un nodo apuntador apartir de la cabeza de la lista
            
            //Mientras el nodo actual sea diferente de nulo Y
            //El nodo siguiente sea diferente de nulo entonces...
            while (current != null && current.getNext() != null) {
                
                //Hacemos la comparación con el nodo actual si es mayor que el nodo que sigue
                if (current.getData() > current.getNext().getData()) {
                    
                    //Si la condición de antes se cumple, quiere decir que tenemos que hacer un cambio de posiciones
                    
                    int temp = current.getData(); //Creamos una variable temporal que guarda el valor actual del nodo para futuros usos
                    
                    //Del nodo actual, actualizamos su valor con el valor del siguiente nodo
                    current.setData(current.getNext().getData()); 
                    
                    //Del nodo que le sigue actualizamos sus datos con la variable temporal que creamos anteriormente
                    current.getNext().setData(temp); 

                    swapped = true; //Marcamos que se hizo un intercambio para que el ciclo de intercambios continue
                }
                current = current.getNext(); //Nos movemos al siguiente nodo
            }
        //Mientras la condición se vuelva True durante los intercambios quiere decir que aun siguen intercambios necesarios por hacer
        //En caso de que siga false, quiere decir que ya no existen mas intercambios necesarios y que la lista ya quedo completamente ordenada
        //Es una forma de mejorar el algoritmo de bubble sort para ahorrar una que otras operaciones
        } while (swapped); 
    }
    
    /**
     * Metodo selectionSort : ordanmiento de la lista por medio del metodo de selection sort
     * @param list : la lista enlazada que sera ordenada
     */
    public void selectionSort(LinkedList list) {
        Node head = list.getHead();  //Obtenemos la cabeza de la lista enlazada y la guardamos
        
        //Creamos un ciclo for en el que...
        //Creamos primero un nodo actual que sera a apartir de la cabeza, osea el inicio de la lista
        //La condición sera mientras ese nodo actual no sea nulo
        //Y avanzara al siguiente nodo en cada iteración
        for (Node current = head; current != null; current = current.getNext()) {
            Node minNode = current;  //De momento el nodo actual sera nuestro minimo para esta iteración
            
            //Creamos un ciclo for en el que...
            //Se inicie apartir del siguiente que le sigue al nodo actual de antes
            //La condición sera mientras ese nodo siguiente sea diferente de nulo
            //Y avanzara al siguiente nodo en cada iteración
            for (Node nextNode = current.getNext(); nextNode != null; nextNode = nextNode.getNext()) {
                
                //Si durante la iteración se encuentra un valor menor que el valor menor que declaramos antes..
                if (nextNode.getData() < minNode.getData()) {
                    minNode = nextNode;  //Entonces se actualiza ese valor menor para que sea el nuevo valor menor
                }
            }
            
            //Una vez que se halle recorrido toda la lista es el momento de hacer los intercambios
            //Primero se verifica si el nodo minimo es diferente del nodo actual de antes
            //Esto se hace por si el nodo actual resulta ser realmente desde un inicio el mas pequeño
            //Por lo que si llegara a hacer el caso no hacemos ningun intercambio, de lo contrario si
            if (minNode != current) {
                int temp = current.getData(); //Creamos una variable temporal y guardamos en el lo que tenga el nodo actual
                current.setData(minNode.getData()); //Del nodo actual actualizamos su valor con el que tenga el nodo minimo
                minNode.setData(temp); //Finalmente del nodo minimo se le actualiza su valor con la variable temporal de antes
            }
            //Una vez que se hace este intercambio volvemos a la iteración de antes, osea el ciclo externo para seguirle
            //Con el siguiente elemento y asi volver a entrar al ciclo interno para la busqueda del elemento mas pequeño
            //Y asi volver a hacer el intercambio entre elementos, asi hasta que el ciclo externo halla acabado de recorrer toda la lista
        }
    }
    
    
    /**
     * Metodo mergeSort : ordenamiento de la lista enlazada por medio de merge sort
     * @param head : la cabeza de la lista enlazada
     * @return :
     */
    public Node mergeSort(Node head) {
        //Verificamos si la lista esta vacia o si en todo caso solo tiene un nodo
        //Esto seria siendo el caso base en caso de llegar a ese punto de la recursividad
        if (head == null || head.getNext() == null) {
            return head; //Regresamos la cabeza porque quiere decir que la lista ya esta ordenada completamente
        }

        //Sigue la parte de dividir la lista en dos mitades para iniciar con la etapa de dividir la lista en sublistas
        Node middle = getMiddle(head); //Llamamos a metodo para encontrar el nodo que se encuentre en medio de la lista y lo guardamos
        
        //Para este punto la lista sigue "conectada" por asi decirlo
        //Por lo que tenemos que apuntar directamente al nodo que sigue despues del medio
        //Este nodo servira de cabeza para la segunda mitada de la lista
        Node nextOfMiddle = middle.getNext();
        middle.setNext(null);  //Cortamos la conexión entre la primera y segunda mitad de la lista, haciendo que middle apunte ahora a null
        
        //Es como si tuvieramos lo siguiente:
        // head - node - middle - null (Primera mitad)
        // nextOfMiddle - node - node - null (Segunda mitad)

        //Ahora sigue la parte recursiva de este algoritmo
        //Primero hablamos de manera recursiva para la primera mitada que es donde esta head como primer nodo
        //Segundo hablamos de manera recursiva para la segunda mita que es donde esta nextOfMiddle como primer nodo
        
        
        //Este metodo se llama a asi mismo para aplicar todo lo anteriomente escrito pero ahora solo con esta primera mitad
        //De esta manera las listas se terminaran subdividiendo asi mismas hasta que solo quede un nodo o queden vacias
        //Una vez que lleguemos a ese caso base, retornar ese nodo y se almacena en left para esa llamada recursiva.
        Node left = mergeSort(head);
        
        //Este metodo se llama a asi mismo para aplicar todo lo anteriomente escrito pero ahora solo con esta segunda mitad
        //De esta manera las listas se terminaran subdividiendo asi mismas hasta que solo quede un nodo o queden vacias
        //Una vez que lleguemos a ese caso base, retornar ese nodo y se almacena en right para esa llamada recursiva.
        Node right = mergeSort(nextOfMiddle);

         
        //Ahora que las listas han sido divididas en sublistas de solo un nodo o vacias
        //Ahora sigue fusionar esas sublistas para que puedan ir creando el orden correcto
        //Con esta instruccion lo que hacemos es combinar el left y right de la respectiva llamada recursiva en una sola lista enlazada
        return merge(left, right);
    }

    /**
     * Metodo getMiddle : Nos sirve para obtener el medio de las sublistas
     * @param head : el nodo que se encuentre en el inicio de esa lista
     * @return : el medio de esa lista
     */
    private Node getMiddle(Node head) {
        //Primero se tiene que verificar si la cabeza es nula y funciona como caso base
        if (head == null) {
            return head; //Retornamos la cabeza si resulta ser nula, esto funciona como caso base
        }
        
        //Para una lista enlazada que funciona con nodos
        //Es complicado determinar su mitad porque es con nodos
        //Para eso se declara un nodo que ira lento
        //Y un nodo que ira mas rapido
        Node slow = head;  //Este nodo solo avanzara uno solo a la vez
        Node fast = head.getNext(); //Este nodo avanzara dos nodos a la vez por cada iteración

        //Creamos un ciclo while en donde
        //El nodo rapido sea diferente de nulo y el siguiente del nodo rapido sea diferente de nulo tambien
        //Esto se hace para que el nodo rapido no salte de mas o llegue a nodo que no exista
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext(); //Avanzamos uno con el nodo lento
            fast = fast.getNext().getNext(); //Avanzamos dos veces con el nodo rapido
        }

        return slow; //Al final el lento terminara en el nodo del medio de esa lista enlazada
    }

    /**
     * Metodo merge : fusionar las dos listas enlazadas
     * @param left : la lista enlazada primera mitad
     * @param right : la lista enlazada segunda mitad
     * @return 
     */
    private Node merge(Node left, Node right) {
        //Manejamos primero los casos bases de ambos lados
        //Si alguna de la listas es null, devolvemos la otra lista
        //Esto se tiene que hacer asi porque significa no hay nada por fusionar
        
        //Si left es igual a null, significa que los elementos de la izquierda ya fueron ordenados
        //Por lo que solo faltan los de la derecha
        if (left == null) {
            return right; //Retornamos la lista enlazada derecha 
        }
        
        //Si right es igual a null, significa que los elementos de la derecha ya fueron ordenados
        //Por lo que solo faltan los de la izquierda
        if (right == null) {
            return left; //Retornamos la lista enlazada izquierda
        }

        Node result; //Creamos un nodo que funciona para guardar el resultado
        
        //Si ambas listas enlazadas tienen elementos, entonces tenemos que comparar valores para ordenarlos
        //Si el nodo de la izquierda es menor o igual el nodo de la derecha entonces...
        if (left.getData() <= right.getData()) {
            result = left; //El nodo left se guarda en la variable result
            
            //Ahora tenemos que volver a aplicar la recursión
            //Esta recursión funciona hacia atras
            //Esto quiere decir que una vez que llegamos al caso base en alguna de las dos listas
            //Es momento de ir construyendo la lista hacia atras usando los setNext para de esta manera
            //Ir conectando cada nodo con el siguiente mas pequeño que fue retornado en las llamadas recursivas
            result.setNext(merge(left.getNext(), right));
        } else { //De lo contrario si no es menor o igual que el de la derecha entonces...
            result = right; //El nodo right se guarda en la variable result
            
            //Ahora tenemos que volver a aplicar la recursión
            //Esta recursión funciona hacia atras
            //Esto quiere decir que una vez que llegamos al caso base en alguna de las dos listas
            //Es momento de ir construyendo la lista hacia atras usando los setNext para de esta manera
            //Ir conectando cada nodo con el siguiente mas pequeño que fue retornado en las llamadas recursivas
            result.setNext(merge(left, right.getNext()));
        }

        return result; //Una vez que todas las llamadas recurivas fueron hechas, se retorna la cabeza de la nueva lista ordenada
    }

    // Helper method to sort a LinkedList
    /**
     * Metodo sortMerge : ordenar la lista con el metodo sort Merg
     * @param list : la lista enlazada que tendra que ser ordenada
     */
    public void sortMerge(LinkedList list) {
        Node newHead = mergeSort(list.getHead());  //Por medio de este metodo es que obtenemos la nueva cabeza de la lista ordenada y se almacena
        list.setHead(newHead);  //Se actualiza la cabeza de la lista con la nueva cabeza de la lista ordenada que contienen todos los otros nodos
    }
    
    
    
    
    /**
     * Metodo quickSort : aqui se encuentra la logica del algoritmo de quick sort
     * @param head : la cabeza de la sub lista en la que nos encontramos
     * @return : la fusion de las sub listas
     */
    public Node quickSort(Node head) {
        //Primero verificamos que la cabeza sea igual a nulo o el siguiente de la cabeza sea nulo, osease que solo tiene un nodo
        //Esta verificación funciona como el caso base porque significa que no se tiene que hacer nada mas
        if (head == null || head.getNext() == null) {
            return head; //Devolvemos la cabeza paras las recursiones
        }

        //Dentro del algoritomo de quickSort existe el elemento pivote
        //Este sera clave para el ordenamiento de la lista
        //Para esto llamamos al metodo partition para obtener las particiones de la lista
        //El metodo nos retonara una lista con los elementos en orden para cada cosa
        Node[] partitioned = partition(head);
        Node left = partitioned[0];   //En la posición 0 se encuentran los elementos menores al pivote
        Node pivot = partitioned[1];  //En la posición 1 se encuentra el elemento pivote
        Node right = partitioned[2];  //En la posición 2 se encuentran los elementos mayores al pivote

        //Aqui es donde tenemos que aplicar la recursividad dentro de este algoritmo
        //Dentro de cada llamada recursiva se va aplicando la misma logica de sacar un elemento pivote y dos particiones de la lista
        //Si hay mas de un elemento en la sublista entonces se volvera a dividir en partes mas pequeñas
        //Una vez que solo tenga 1 o menos la lista, entocnes se retorna directamente ese nodo
        Node sortedLeft = quickSort(left); //Usamos la llamada recursiva para la particion con elementos menores al pivote
        Node sortedRight = quickSort(right); //Usamos la llamada recursiva para la particion con elementos mayores al pivote

        //AL final de cada llamada recursiva se usa este retorno para empezar a ordenar la lista enlazada
        //El metodo concatenate se encarga de combinar las partes izquierda, pivote y derecha y juntarlas en una sola lista ordenada
        //El sortedLeft son los nodos ordenados de manera recursiva menores al pivote
        //El pivot es el nodo que se eligio para la partición
        //El sortedRight son los nodos ordenados de manera revursica mayores al pivote
        //Retornara una cabeza que contiene una nueva lista que es la combinacipon de las tres partes
        return concatenate(sortedLeft, pivot, sortedRight);
    }

    /**
     * Metodo partition : devuelve una lista con los nodos y se encarga de crear las particiones para las listas
     * @param head : la cabeza de la lista enlazada o sublista que se va a dividir
     * @return :
     */
    private Node[] partition(Node head) {
        Node pivot = head;  //El pivote siempre sera el primer elemento de esa lista
        Node left = null, right = null; //De momento inicializamos el izquierdo y derecho en nulos
        Node leftTail = null, rightTail = null; //Tambien sus colas las inizializamos en nulos
        Node current = head.getNext();  //Creamos un apauntador apartir del que sigue del pivote, ya que el pivote no puede estar en las particiones
        
        //Mientras el nodo actual sea diferente de nulo entocnes...
        while (current != null) {
            Node nextNode = current.getNext(); //Guardamos el siguiente nodo en esta variable para no perderlo durante la ejecución
            
            //Si del nodo actual su valor es menor que el pivote entonces...
            if (current.getData() < pivot.getData()) {
                
                //Si el nodo izquierdo esta vacio, es decir primer insert
                if (left == null) {
                    left = current; //El nodo apuntador se vuelve el primero del izquierdo
                    leftTail = current; //Y tambien el primero de su cola
                    //Esto ayuda a que ambos punteros apunten al mismo y por ende conserven la misma referencia
                } else { //De lo contrario si ya hay nodos entonces...
                    leftTail.setNext(current); //Se actualiza el siguiente nodo de la cola
                    //Esta operacion tambien afecta a left en su estructura
                    leftTail = current; //Y se actualiza la cola para que apunte al nodo aputandor
                }
            } else { //De lo contrario si es mayor que el pivote entonces...
                
                //Si el nodo derecho esta vacio, es decir primer insert
                if (right == null) {
                    right = current; //El nodo apuntador se vuelve el primero derecho
                    rightTail = current; //Y tambien el primero de su cola
                    //Esto ayuda a que ambos punteros apunten al mismo y por ende conserven la misma referencia
                } else { //De lo contrario si ya hay nodos entonces...
                    rightTail.setNext(current); //Se actualiza el siguiente nodo de la cola
                    //Esta operacion tambien afecta a right en su estructura
                    rightTail = current; //Y se actualiza la cola para que apunte al nodo aputandor
                }
            }
            current.setNext(null); //Se hace esto para evitar la creación de ciclos al separar nodos que se meuven entre particiones.
            current = nextNode; //Por medio de la variable que creamos al inicio del ciclo es que nos movemos al siguiente nodo y seguimos iterando
        }
        
        //Al final retornamos la cabeza con los nodos menores al pivote
        //El nodo pivote
        //La cabeza con los nodos mayores al pivote
        return new Node[]{left, pivot, right};
    }

    /**
     * Metodo concatenate : se utiliza para combinar las partes izquierdas con el pivote y luego las partes derechas
     * @param left : Cabeza de la lista de nodos que sean menores al pivote 
     * @param pivot : Nodo que fue pivote durante la partición
     * @param right : Cabeza de la lista de nodos que sean mayores al pivote
     * @return : la nueva cabeza de la lista ordenada
     */
    private Node concatenate(Node left, Node pivot, Node right) {
        //Primero tenemos que verificar si no existen nodos en la aprte izquierda
        //Esto quiere decir que el pivote sea el elemento con menor valor
        //Por lo que tenemos que hacer que el pivote apunte hacia la derecha porque es mayor al pivote
        if (left == null) {
            pivot.setNext(right); //El pivote ahora apunta hacia la derecha
            return pivot; //El pivote se vuelve la cabeza de la lista combinada y lo retornamos
        }

        //Buscaremos la cola de la parte izquierda
        Node leftTail = left; //Iniciamos en la cabeza de la sublista izquierda
        
        //Mientras el siguiente de ese nodo sea diferente de nulo
        while (leftTail.getNext() != null) {
            leftTail = leftTail.getNext(); //Avanzamos al siguiente nodo de la sublista izquierda
        }
        leftTail.setNext(pivot); //Conectamos la lista izquierda con el pivote

        pivot.setNext(right); //Ahora conectamos el pivote con la lista derecha

        return left;  //Por ultimo devolvemos left que es la nueva cabeza de la lista que esta ordenada, izquierda seguida del pivote y despues derecha
    }

    /**
     * Metodo sortQuick : metodo que usa la lista enlazada para ordenarse por medio de quick sort
     * @param list : la lista enlazada que sera ordenada
     */
    public void sortQuick(LinkedList list) {
        Node newHead = quickSort(list.getHead());//Por medio de este metodo es que obtenemos la nueva cabeza de la lista ordenada y se almacena
        list.setHead(newHead);//Se actualiza la cabeza de la lista con la nueva cabeza de la lista ordenada que contienen todos los otros nodos
    }
    
    
}