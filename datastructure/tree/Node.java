package datastructure.tree;

public class Node {

	public int data;
	public String value;
	public Node leftChild;
	public Node rightChild;
	

	Node(int data) {
		this.data = data;
	}
	Node(int data, String value) {
		this.data = data;
		this.value = value;
	}

}
