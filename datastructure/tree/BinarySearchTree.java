package datastructure.tree;

public class BinarySearchTree {

	private static Node root;

	public void insert(int data) {
		Node newNode = new Node(data);

		if (root == null)
			root = newNode;
		else {
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
			if (data < focusNode.data)
				focusNode = focusNode.leftChild;
			else
				focusNode = focusNode.rightChild;
		}
		return focusNode;
	}

	public Node findMin() {
		Node focusNode = root;
		Node last = null;
		while (focusNode != null) {
			last = focusNode;
			focusNode = focusNode.leftChild;
		}
		return last;
	}

	public Node findMax() {
		Node focusNode = root;
		Node last = null;
		while (focusNode != null) {
			last = focusNode;
			focusNode = focusNode.rightChild;
		}
		return last;
	}

	public boolean deleteNode(int data) {
		Node focusNode = root;
		Node parent = root;

		boolean isLeftChild = false;

		while (focusNode.data != data) {
			parent = focusNode;
			if (data < focusNode.data) {
				isLeftChild = true;
				focusNode = focusNode.leftChild;
			} else {
				isLeftChild = false;
				focusNode = focusNode.rightChild;
			}
			if (focusNode == null)
				return false;
		}

		// found the node
		Node nodeToDelete = focusNode;

		// if node is a leaf node
		if (nodeToDelete.leftChild == null && nodeToDelete.rightChild == null) {
			if (nodeToDelete == root)
				root = null;
			else if (isLeftChild)
				parent.leftChild = null;
			else
				parent.rightChild = null;
		}

		// if node has a child

		else if (nodeToDelete.rightChild == null) {
			if (nodeToDelete == root) {
				root = nodeToDelete.leftChild;
			} else if (isLeftChild) {
				parent.leftChild = nodeToDelete.leftChild;
			}
		}

		else if (nodeToDelete.leftChild == null) {
			if (nodeToDelete == root) {
				root = nodeToDelete.rightChild;
			} else if (!isLeftChild) {
				parent.leftChild = nodeToDelete.rightChild;
			}
		}

		// if node has 2 nodes
		else {
			Node successor = getSuccessor(nodeToDelete);
			if (isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;

			successor.leftChild = nodeToDelete.leftChild;
		}
		return true;
	}

	private Node getSuccessor(Node nodeToDelete) {
		Node focusNode = nodeToDelete.rightChild;
		Node last = focusNode;
		Node parent = focusNode;
		while (focusNode != null) {
			parent = last;
			last = focusNode;
			focusNode = focusNode.leftChild;
		}
		if (focusNode != nodeToDelete.rightChild) {
			parent.leftChild = last.rightChild;
			last.rightChild = nodeToDelete.rightChild;
		}
		return last;
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		tree.insert(35);
		tree.insert(55);
		tree.insert(90);
		tree.insert(45);
		tree.insert(75);
		tree.insert(76);
		TreeTraversal.inOrderTraversal(root);
		System.out.println("");
		// TreeTraversal.postOrderTraversal(root);
		// System.out.println("");
		// TreeTraversal.preOrderTraversal(root);
		tree.deleteNode(70);
		TreeTraversal.inOrderTraversal(root);
		System.out.println("");
//		bst.addNode(10, "ten");
//		bst.addNode(20, "twenty");
//		bst.addNode(15, "fifteen");
//		bst.addNode(18, "eighteen");
//
//		System.out.println(bst.findNode(15).data);
//
//		System.out.println(bst.findMin().data);
//		System.out.println(bst.findMax().data);

	}

}
