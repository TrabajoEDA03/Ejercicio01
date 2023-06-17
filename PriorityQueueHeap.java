package Ejercicio01;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class PriorityQueueHeap<T extends Comparable<T>, P extends Comparable<P>> {
	
    private class PriorityQueueElement<T, P> implements Comparable<PriorityQueueElement<T, P>> {
        private T element;
        private P priority;

        public PriorityQueueElement(T element, P priority) {
            this.element = element;
            this.priority = priority;
        }

        public T getElement() {
            return element;
        }

        public P getPriority() {
            return priority;
        }

        
        public int compareTo(PriorityQueueElement<T, P> other) {
            return ((Comparable<T>) this.priority).compareTo((T) other.getPriority());
        }
    }

    private List<PriorityQueueElement<T, P>> heap;

    public PriorityQueueHeap() {
        heap = new ArrayList<>();
    }

    public void enqueue(T element, P priority) {
        PriorityQueueElement<T, P> newElement = new PriorityQueueElement<>(element, priority);
        heap.add(newElement);
        siftUp(heap.size() - 1);
    }

    public T dequeue() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("La cola de prioridad esta vacia.");
        }

        PriorityQueueElement<T, P> maxElement = heap.get(0);
        int lastIndex = heap.size() - 1;
        heap.set(0, heap.get(lastIndex));
        heap.remove(lastIndex);
        siftDown(0);

        return maxElement.getElement();
    }

    public T front() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("La cola de proridad esta vacia.");
        }

        return heap.get(0).getElement();
    }

    public T back() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }

        int lastIndex = heap.size() - 1;
        return heap.get(lastIndex).getElement();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    private void siftUp(int index) {
        int parentIndex = (index - 1) / 2;

        while (index > 0 && heap.get(index).compareTo(heap.get(parentIndex)) > 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void siftDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int largestIndex = index;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(largestIndex)) > 0) {
            largestIndex = leftChildIndex;
        }

        if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(largestIndex)) > 0) {
            largestIndex = rightChildIndex;
        }

        if (largestIndex != index) {
            swap(index, largestIndex);
            siftDown(largestIndex);
        }
    }

    private void swap(int i, int j) {
        PriorityQueueElement<T, P> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}

