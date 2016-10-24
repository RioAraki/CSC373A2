import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Q1 {
	 
	public static double randomMST(int n) {
		MaxHeap edges = new MaxHeap(2*n);
		double sum = 0;
		for (int i = 2; i < n+1; i++) { // i means number of vertices currently have
			for (int j = 0; j < i-1; j++) { // j means number of edges currently should have for MST
				double number =  Math.random();
				edges.insert(number);
				sum += number;
			}
			
			while (edges.size > (i-1)) {
				sum -= edges.remove();
			} // sort the list and remove the largest one until the size of edge = j
		}
		return sum;
	}
	
	public static void main(String [] args) {
		System.out.println(randomMST(50000));
	}
	
}

