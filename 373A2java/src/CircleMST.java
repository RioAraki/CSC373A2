import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CircleMST {
	public static double circleMST(int n) {
		Map<Integer, Pair> graph = new HashMap<Integer, Pair>();
		
		double sum = 0;
		double smallest = 3; // initialize a big value 
		int smallestEdge = -1;
		for (int i = 0;  i < n; i++) { // O(N)
			double radius = Math.sqrt(Math.random());
			double degree = 2*Math.PI*Math.random();
			double x = radius*Math.cos(degree);
			double y = radius*Math.sin(degree);
			graph.put(i, new Pair(x,y,smallest));  //O(1)
		}// initialize all edges with max weight
		
		Pair previous = graph.remove(0); //first visited vertex  O(1)
		
		for (int j = 1; j < n; j++) { // n-1 edges in total  //O(N)
			for (Entry<Integer, Pair> entry: graph.entrySet()) {  //O(N)
				Pair now = entry.getValue();
				double newEdge = getEdge(now,previous);
				double oldEdge = now.getDistance();
				int index = entry.getKey();
//				System.out.println("loop: "+index + "  old:"+oldEdge+"  new:"+newEdge);
				if (oldEdge > newEdge) {
					now.setDistance(newEdge);
					graph.put(index, now);
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
			previous = graph.remove(smallestEdge);
//			System.out.println("Graph: "+graph);
			sum += smallest;
//			System.out.println("Sum now: "+sum);
			smallest = 3;
		}
		return sum;
			
	}
		
	
	public static double getEdge(Pair p1, Pair p2) {
		return Math.sqrt(Math.pow((p2.getLeft()-p1.getLeft()),2) + Math.pow((p2.getRight()-p1.getRight()), 2));
		
	}
	public static void main(String [] args) {
		int numVertices = Integer.parseInt(args[0]);
		double result = circleMST(numVertices);
		System.out.println(result);
	}
}
