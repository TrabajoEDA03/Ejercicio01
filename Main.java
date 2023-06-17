package Ejercicio01;

public class Main {
    public static void main(String[] args) {
        PriorityQueueHeap<String, Integer> priorityQueue = new PriorityQueueHeap<>();

        priorityQueue.enqueue("Elemento 1", 3);
        priorityQueue.enqueue("Elemento 2", 1);
        priorityQueue.enqueue("Elemento 3", 4);
        priorityQueue.enqueue("Elemento 4", 2);
        priorityQueue.enqueue("Elemento 5", 7);
        priorityQueue.enqueue("Elemento 6", 9);
        
        //Elimina el primero en la cola de proridad y deja a los restantes
        priorityQueue.dequeue();
        

        while (!priorityQueue.isEmpty()) {
            String item = priorityQueue.dequeue();
            System.out.println(item);
        }
    }
}

