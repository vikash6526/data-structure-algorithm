package datastructure.graph;

public class Node {

	public int vertexIdx;
	public Node next;

	public Node(int vertexIdx, Node node) {
		this.vertexIdx = vertexIdx;
		next = node;
	}
}
