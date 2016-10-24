import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Q1 {
	 
	public static double randomMST(int n) {
		ArrayList<Double> edges = new ArrayList();
		ArrayList<Double> visitedEdges = new ArrayList();
		double sum = 0;
		for (int i = 2; i < n+1; i++) { // i means number of vertices currently have
			for (int j = 0; j < i-1; j++) { // j means number of edges currently should have for MST
				Random generator = new Random();
				double number = generator.nextDouble();
				edges.add(number);
			}
			while (edges.size() > (i-1)) {
				Collections.sort(edges);
				edges.remove(edges.size()-1);
				//System.out.println(edges);
			} // sort the list and remove the largest one until the size of edge = j
		}
		for (Double d : edges)
			sum += d;
		System.out.println(sum);
		return sum;
	}
	
	public static void main(String [] args) {
		randomMST(1000);
	}
	
}

