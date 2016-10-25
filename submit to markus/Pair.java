public class Pair {

  private double left;
  private double right;
  private double distance;

  public Pair(double left, double right, double distance) {
    this.left = left;
    this.right = right;
    this.distance = distance;
  }

  public double getLeft() { return left; }
  public double getRight() { return right; }
  public double getDistance() {return distance; }
  public void setDistance(double value) {
	  distance = value;
  }
  
  public String toString() {
	String result = "(" + Double.toString(getLeft()) + ", " + Double.toString(getRight()) + ", " + Double.toString(getDistance()) + ")";
	return result;
	  
  } 

//  public int hashCode() { return left.hashCode() ^ right.hashCode(); }

//  public boolean equals(Object o) {
//    if (!(o instanceof Pair)) return false;
//    Pair pairo = (Pair) o;
//    return this.left.equals(pairo.getLeft()) &&
//           this.right.equals(pairo.getRight());
//  }

}