import java.util.HashMap;

public class Q1modify {
	
	public static double randomMST(int n) {
		HashMap<Integer, Double> graph = new HashMap<Integer, Double>();
		double sum = 0;
		double smallest = 2; // initialize a big value 
		int smallestIndex = -1;
		for (int i = 0;  i < n; i++) { // O(N)
			graph.put(i, (double) 2);  //O(1)
		}// initialize all edges with max weight
		graph.remove(0); //first visited vertex  O(1)
		
		
		
		for (int j = 1; j < n; j++) { // n-1 edges in total  //O(N)
			//这个loop可以再优化，毕竟到最后几乎所有都已经visit过了，没必要全部loop一遍
			for (int i = 1; i < n; i ++) {  //O(N)
				if (graph.containsKey(i)){  
					double edge = Math.random();  
					if (graph.get(i) > edge){  
						graph.put(i, edge);  
					}// if current edge is smaller, replace
					if (graph.get(i) < smallest) {  
						smallest = graph.get(i);  
						smallestIndex = i; 
					}
				}	
			}
			graph.remove(smallestIndex);
			sum += smallest;
			smallest = 2;
		}
		return sum;
			
	}
		
	public static void main(String...arg) {
		System.out.println(randomMST(50000));
	}
}
