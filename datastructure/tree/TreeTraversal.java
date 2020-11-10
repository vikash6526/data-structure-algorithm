package datastructure.tree;

public class TreeTraversal {

	public static void inOrderTraversal(Node focusNode) {
		if (focusNode != null) {
			inOrderTraversal(focusNode.leftChild);
			System.out.print(focusNode.data+", ");
			inOrderTraversal(focusNode.rightChild);
		}
	}
	
	public static void preOrderTraversal(Node focusNode) {
		if (focusNode != null) {
			System.out.print(focusNode.data+", ");
			preOrderTraversal(focusNode.leftChild);
			preOrderTraversal(focusNode.rightChild);
		}
	}
	public static void postOrderTraversal(Node focusNode) {
		if (focusNode != null) {
			postOrderTraversal(focusNode.leftChild);
			postOrderTraversal(focusNode.rightChild);
			System.out.print(focusNode.data+", ");
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.leftChild=new Node(2);
		root.leftChild.rightChild=new Node(4);
		root.rightChild=new Node(3);
		root.rightChild.leftChild=new Node(5);
		root.rightChild.leftChild.leftChild=new Node(7);
		root.rightChild.rightChild=new Node(6);
		root.rightChild.rightChild.leftChild=new Node(8);
		root.rightChild.rightChild.rightChild=new Node(9);

		inOrderTraversal(root);
		System.out.println();
		System.out.println("**********************");
		preOrderTraversal(root);
		System.out.println();
		System.out.println("**********************");
		postOrderTraversal(root);
		System.out.println();
		System.out.println("**********************");

	}

}
