package proyectoparte1;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Clase ProyectoParte1 : clase que contiene la parte 1 Y 2 del proyecto final
 * @author David Silva
 */
public class ProyectoParte1 {
    
    /**
     * Metodo main : metodo donde se ejecutara las cosas principales del proyecto
     * @param args : todos los argumentos que tenga este metodo
     */
    public static void main(String[] args) {
    //SECCION DE ORDENAMIENTOS
        LinkedList list = generateRandomList(500);  //Por medio de este metodo es que generamos una lista con 500 elementos alazares en la lista enlazada
        SortingAlgorithms sorter = new SortingAlgorithms(); //Creamos una instancia de la clase que contiene los algoritmos de ordenamiento
        
        //Este es un administrador de hilos que nos ayuda a ejecutar tareas al mismo tiempo
        //Para este executor creamos un pool para manejar 4 hilos
        //Lo que se traduce en 4 tareas de manera simultanea
        ExecutorService executor = Executors.newFixedThreadPool(4);  

        //Para usar cada algoritmo de ordenación vamos a usar la interfaz funcional de Callable<Long>
        //Esto nos permite que despues de cada ejecución se nos devuelva un valor
        
        //Creamos el callable del metodo bubble sort
        Callable<Long> bubbleSortTask = () -> {
            LinkedList bubbleSortList = list.clone();  //Creamos una copia de la lista enlazada para este metodo de ordenamiento
            long startTime = System.nanoTime(); //Empezar a registrar el tiempo de arranque del proceso de ordenación
            sorter.bubbleSort(bubbleSortList); //Ejecutamos el respectivo algoritmo de ordenamiento
            long duration = System.nanoTime() - startTime; //Calculamos el tiempo de ejecución mediente una resta
            return duration; //Retornamos la duración de esta ejecución
        };
        
        //Creamos el callable del metodo selection sort
        Callable<Long> selectionSortTask = () -> {
            LinkedList selectionSortList = list.clone(); //Creamos una copia de la lista enlazada para este metodo de ordenamiento
            long startTime = System.nanoTime(); //Empezar a registrar el tiempo de arranque del proceso de ordenación
            sorter.selectionSort(selectionSortList);//Ejecutamos el respectivo algoritmo de ordenamiento
            long duration = System.nanoTime() - startTime; //Calculamos el tiempo de ejecución mediente una resta
            return duration; //Retornamos la duración de esta ejecución
        };
        
        //Creamos el callable del metodo merge sort
        Callable<Long> mergeSortTask = () -> {
            LinkedList mergeSortList = list.clone(); //Creamos una copia de la lista enlazada para este metodo de ordenamiento
            long startTime = System.nanoTime(); //Empezar a registrar el tiempo de arranque del proceso de ordenación
            sorter.sortMerge(mergeSortList); //Ejecutamos el respectivo algoritmo de ordenamiento
            long duration = System.nanoTime() - startTime; //Calculamos el tiempo de ejecución mediente una resta            
            return duration; //Retornamos la duración de esta ejecución
        };
        
        //Creamos el callable del metodo quick sort
        Callable<Long> quickSortTask = () -> {
            LinkedList quickSortList = list.clone(); //Creamos una copia de la lista enlazada para este metodo de ordenamiento
            long startTime = System.nanoTime(); //Empezar a registrar el tiempo de arranque del proceso de ordenación
            sorter.sortQuick(quickSortList); //Ejecutamos el respectivo algoritmo de ordenamiento
            long duration = System.nanoTime() - startTime; //Calculamos el tiempo de ejecución mediente una resta
            return duration; //Retornamos la duración de esta ejecución
        };
        
        //Intentamos ejecutar el codigo a continuación
        try {
            //Con los metodos funcionales que creamos anteriormente
            //Vamos a recuperar su resultado en Future<Long>
            //Esto sirve como una representacion del futuro resultado de esa ejecución
            //Lo que hace que puedas continuar con el codigo mientras otras cosas se ejecutan para obtener el resultado mas adelante
            Future<Long> bubbleSortResult = executor.submit(bubbleSortTask); //Devolvemos el valor del metodo para el bubble sort
            Future<Long> selectionSortResult = executor.submit(selectionSortTask); //Devolvemos el valor del metodo para el selection sort
            Future<Long> mergeSortResult = executor.submit(mergeSortTask); //Devolvemos el valor del metodo para el merge sort
            Future<Long> quickSortResult = executor.submit(quickSortTask); //Devolvemos el valor del metodo para el quick sort

            //Ahora hacemos las impresiones de pantalla en la consola para ver cada tiempo de ejecución de cada metodo
            System.out.println("Bubble Sort Time: " + bubbleSortResult.get() + " ns"); //Mostramos el bubble sort
            System.out.println("Selection Sort Time: " + selectionSortResult.get() + " ns"); //Mostramos el selection sort
            System.out.println("Merge Sort Time: " + mergeSortResult.get() + " ns"); //Mostramos el merge sort
            System.out.println("Quick Sort Time: " + quickSortResult.get() + " ns"); //Mostramos el quick sort
        
        //Agarrar cualquier excepcion que suceda en caso de algun error imprevisto
        } catch (Exception e) { 
            e.printStackTrace(); //Mostramos en pantalla la ruta del error
        } finally { //Finalmente despues del bloque de codigo de Try-catch
            executor.shutdown(); //Cerramos el executor para liberar recursos y terminarlo correctamente
        }

        //SECCIÓN DE BUSQUEDAS
        
        System.out.println(""); //Espacio
        System.out.println(""); //Espacio
        
        LinkedList randomList = generateRandomList(500);  //Creamos una lista enlazada de 500 elementos aleatorios
        SortingAlgorithms sorterMethod = new SortingAlgorithms(); //Creamos una instancia para tener acceso a los metodos de ordenamiento
        randomList.add(300); //Añadimos manualmente el 300 a la lista enlazada
        sorterMethod.sortQuick(randomList);  //Ordenamos la lista enlazada usando algun metodo de ordenamiento

        SearchAlgorithms searcher = new SearchAlgorithms(); //Creamos una instancia para tener acceso a los metodo de busqueda
        int target = 300;  //Declaramos cual va a ser el numero que queremos buscar dentro de la lista enlazada
        
        randomList.printList(); //Espacio
        
        //Este es un administrador de hilos que nos ayuda a ejecutar tareas al mismo tiempo
        //Para este executor creamos un pool para manejar 2 hilos
        //Lo que se traduce en 2 tareas de manera simultanea
        ExecutorService executorSearch = Executors.newFixedThreadPool(2);  

        //Para usar cada algoritmo de ordenación vamos a usar la interfaz funcional de Callable<Long>
        //Esto nos permite que despues de cada ejecución se nos devuelva un valor
        
        //Creamos el callable del metodo de busqueda secuencial
        Callable<Long> sequentialSearchTask = () -> {
            long startTime = System.nanoTime(); //Empezar a registrar el tiempo de arranque del proceso de busqueda
            boolean found = searcher.sequentialSearch(randomList, target); //Empezamos a hacer la busqueda dentro de la lista enlazada
            long duration = System.nanoTime() - startTime; //Calculamos el tiempo de ejecución mediente una resta
            System.out.println("Sequential Search Result: " + found); //Mostramos en la consola si se encontro el elemento en la lista enlazada 
            return duration; //Retornamos la duración de esta ejecución
        };
        
        //Creamos el callable del metodo de busqueda binaria
        Callable<Long> binarySearchTask = () -> {
            long startTime = System.nanoTime(); //Empezar a registrar el tiempo de arranque del proceso de busqueda
            boolean found = searcher.binarySearch(randomList, target); //Empezamos a hacer la busqueda dentro de la lista enlazada
            long duration = System.nanoTime() - startTime; //Calculamos el tiempo de ejecución mediente una resta
            System.out.println("Binary Search Result: " + found); //Mostramos en la consola si se encontro el elemento en la lista enlazada 
            return duration; //Retornamos la duración de esta ejecución
        };
        
        //Intentamos ejecutar el bloeque de codigo
        try {
            //Con los metodos funcionales que creamos anteriormente
            //Vamos a recuperar su resultado en Future<Long>
            //Esto sirve como una representacion del futuro resultado de esa ejecución
            //Lo que hace que puedas continuar con el codigo mientras otras cosas se ejecutan para obtener el resultado mas adelante
            Future<Long> sequentialSearchResult = executorSearch.submit(sequentialSearchTask); //Devolvemos el valor del metodo para el sequential search
            Future<Long> binarySearchResult = executorSearch.submit(binarySearchTask); //Devolvemos el valor del metodo para el binary search

            //Ahora hacemos las impresiones de pantalla en la consola para ver cada tiempo de ejecución de cada metodo
            System.out.println("Sequential Search Time: " + sequentialSearchResult.get() + " ns"); //Mostramos el sequential search
            System.out.println("Binary Search Time: " + binarySearchResult.get() + " ns"); //Mostramos el binary search
        
        //Agarrar cualquier excepcion que suceda en caso de algun error imprevisto    
        } catch (Exception e) {
            e.printStackTrace(); //Mostramos en pantalla la ruta del error
        } finally { //Finalmente despues del bloque de codigo de Try-catch
            executor.shutdown(); //Cerramos el executor para liberar recursos y terminarlo correctamente 
        }
    }

    /**
     * Metodo generateRandomList : generar una lista con elementos al azar
     * @param size : el tamaño de la lista que queremos
     * @return : la lista con elementos aleatorios hasta cierto tamaño
     */
    private static LinkedList generateRandomList(int size) {
        LinkedList list = new LinkedList(); //Creamos una nueva lista enlazada
        Random random = new Random(); //Creamos una instancia de random para las cosas aleatorias
        
        //Creamos un ciclo for para ir añadiendo los elementos hasta el numero solicitado
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(1000));  //Añadimos un numero al azar del 0 a 999 a la lista enlazada
        }
        return list; //Retornamos la lista enlazada completamente aleatoria
    }

}
