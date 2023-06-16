package Ejercicio01;
import java.util.*;
public class MainHeap {

	public static void main(String[] args) {
		
		MaxHeap<Integer> heap = new MaxHeap<>();
		
		heap.insert(3);
		heap.insert(10);
		heap.insert(13);
		heap.insert(8);
		heap.insert(4);
		heap.insert(23);
		heap.insert(1);
		

		while (!heap.isEmpty()) {
		    System.out.println(heap.removeMax());
		}

	}

}
