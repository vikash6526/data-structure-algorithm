package datastructure.doublylinkedlist;

public class DoublyLinkedList {

	private static Node first;
	private static Node last;

	public DoublyLinkedList() {
		this.first = null;
		this.last = null;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insertFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;

		if (isEmpty()) {
			last = newNode;
		} else {
			first.previous = newNode;
		}
		newNode.next = first;
		first = newNode;
	}

	public void insertLast(int data) {
		Node newNode = new Node();
		newNode.data = data;
		if (isEmpty()) {
			insertFirst(data);
		} else {
			last.next = newNode;
			newNode.previous = last;
		}
		last = newNode;
	}

	public int deleteFirst() {
		int data = 0;
		if (isEmpty()) {
			System.out.println("List is Empty");
		} else if (first.next == null) {
			data = first.data;
			first = null;
			last = null;
		} else {
			data = first.data;
			first = first.next;
			first.previous = null;
		}
		return data;
	}

	public int deleteLast() {
		int data = 0;
		if (isEmpty()) {
			System.out.println("List is Empty");
		} else if (first.next == null) {
			data = last.data;
			first = null;
			last = null;
		} else {
			data = last.data;
			last = last.previous;
			last.next = null;
			// last.previous.next=null;
		}
		return data;
	}

	public boolean insertAfter(int key, int data) {

		if (isEmpty()) {
			System.out.println("List is Empty");
		} else {
			Node current = first;
			while (current.data != key) {
				current = current.next;
				if (current == null)
					return false;
			}
			Node newNode = new Node();
			newNode.data = data;

			if (current == last) {
				insertLast(data);
			} else {
				newNode.next = current.next;
				current.next.previous = newNode;
				newNode.previous = current;
				current.next = newNode;
			}

		}
		return true;
	}

	public boolean deleteKey(int key) {
		if (isEmpty()) {
			System.out.println("List is Empty");
		}
		Node current = first;
		while (current.data != key) {
			current = current.next;
			if (current == null)
				return false;
		}

		if (current == first)
			deleteFirst();
		else if (current == last)
			deleteLast();
		else {
			current.previous.next = current.next;
			current.next.previous = current.previous;
		}
		return true;
	}

	public void displayList() {
		System.out.println("List ( First -- > Last)");
		Node curr = first;
		while (curr != null) {
			curr.displayNode();
			curr = curr.next;
		}
		System.out.println("***********");
	}

	public int getCount(Node node) {
		if (node == null) {
			return 0;
		}

		return 1 + getCount(node.next);
	}

	public Node reverseDoublyLinkedList(Node node) {
		Node current = node;
		Node currentPrev = null;
		Node currentNext = null;
		while (current != null) {
			currentPrev = current.previous;
			current.next = currentPrev;
			currentNext = current.next;
			current.previous = currentNext;
			current = current.previous;
		}

		return node;
	}

	public static void main(String[] args) {
		DoublyLinkedList myList = new DoublyLinkedList();
		myList.insertFirst(500);
		myList.insertFirst(400);
		myList.insertFirst(300);
		myList.insertFirst(200);
		myList.insertFirst(100);

		// System.out.println("Length " + myList.getCount(first));

		myList.displayList();

		first = myList.reverseDoublyLinkedList(last);
		myList.displayList();

	}

}
