import java.util.HashMap;
import java.util.Map;

public class RandomMST {
	
	public static double randomMST(int n) {
		Map<Integer, Double> graph = new HashMap<Integer, Double>();
		
		//HashMap<>
		double sum = 0;
		double smallest = 2; // initialize a big value 
		int smallestEdge = -1;
		for (int i = 0;  i < n; i++) { // O(N)
			graph.put(i, (double) 2);  //O(1)
		}// initialize all edges with max weight
		graph.remove(0); //first visited vertex  O(1)
		
		for (int j = 1; j < n; j++) { // n-1 edges in total  //O(N)
			for (Map.Entry<Integer, Double> entry: graph.entrySet()) {  //O(N)
				double newEdge = Math.random();
				double oldEdge = entry.getValue();
				int index = entry.getKey();
//				System.out.println("loop: "+index + "  old:"+oldEdge+"  new:"+newEdge);
				if (oldEdge >= newEdge) {
					graph.put(index, newEdge);
					if (newEdge < smallest) {  
						smallest = newEdge;
						smallestEdge = index;
					}
				} else {   // if current edge is smaller, replace
					if (oldEdge < smallest) {
						smallest = oldEdge;
						smallestEdge = index;
					}
				} 		
			}
//			System.out.println("smallest index: "+smallestEdge);
			graph.remove(smallestEdge);
//			System.out.println("Graph: "+graph);
			sum += smallest;
//			System.out.println("Sum now: "+sum);
			smallest = 2;
		}
		return sum;
			
	}
		
	public static void main(String[] args) {
		int numVertices = Integer.parseInt(args[0]);
		double result = randomMST(numVertices);
		System.out.println(result);
	}
}
