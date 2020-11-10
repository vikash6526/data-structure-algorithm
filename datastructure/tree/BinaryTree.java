package datastructure.tree;

public class BinaryTree {

	Node root;

	public void addNode(int data) {
		Node newNode = new Node(data);

		if (root == null) {
			root = newNode;
		} else {
			Node focusNode = root;
			Node parent;

			while (true) {
				parent = focusNode;
				if (data < focusNode.data) {
					focusNode = focusNode.leftChild;
					if (focusNode == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					focusNode = focusNode.rightChild;
					if (focusNode == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public Node findNode(int data) {
		Node focusNode = root;
		while (focusNode.data != data) {
			if (data < focusNode.data) {
				focusNode = focusNode.leftChild;
			} else {
				focusNode = focusNode.rightChild;
			}

			if (focusNode == null)
				return null;
		}

		return focusNode;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
