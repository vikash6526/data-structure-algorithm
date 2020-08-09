package datastructure.heap;

public class HeapDatastructure {

	private Node[] heapArray;

	private int maxSize; // size of array
	private int currentSize; // number of nodes in array

	public HeapDatastructure(int size) {
		this.maxSize = size;
		this.currentSize = 0;
		heapArray = new Node[size];
	}

	public int getSize() {
		return currentSize;
	}

	public boolean isEmpty() {
		return (currentSize == 0);
	}

	public boolean insert(int key) {

		if (currentSize == maxSize)
			return false;

		Node newNode = new Node(key);
		heapArray[currentSize] = newNode;

		trickleUp(currentSize);
		currentSize++;

		return true;
	}

	public void trickleUp(int index) {
		int parentIndex = (index - 1) / 2;
		Node nodeToDelete = heapArray[index];

		while (parentIndex > 0 && heapArray[parentIndex].getKey() < nodeToDelete.getKey()) {
			heapArray[index] = heapArray[parentIndex];
			index = parentIndex;
			parentIndex = (index - 1) / 2;
		}
		heapArray[index] = nodeToDelete;
	}

	public Node delete() {
		Node root = heapArray[0];
		heapArray[0] = heapArray[--currentSize];
		tickledown(0);

		return root;
	}

	public void tickledown(int index) {
		int largerChildInx;
		Node top = heapArray[index];
		while (index < currentSize / 2) {
			int leftChild = (2 * index) + 1;
			int rightChild = (2 * index) + 2;
			if (rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey()) {
				largerChildInx = rightChild;
			} else
				largerChildInx = leftChild;
			if (top.getKey() >= heapArray[largerChildInx].getKey())
				break;
			heapArray[index] = heapArray[largerChildInx];
			index = largerChildInx;
		}
		heapArray[index] = top;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
