package datastructure;

public class CircularLinkedList {

	private static Node first;
	private static Node last;
	private static Node firstNode;

	public boolean isEmpty() {
		return first == null;
	}

	public void insertFirst(int data) {
		Node newNode = new Node(data);
		// newNode.data = data;

		if (isEmpty()) {
			last = newNode;
		}
		newNode.next = first;
		first = newNode;
	}

	public void insertLast(int data) {
		Node newNode = new Node(data);
		// newNode.data = data;

		if (isEmpty()) {
			insertFirst(data);
		} else {
			last.next = newNode;
			last = newNode;
		}
	}

	public int deleteFirst() {
		int data = first.data;
		if (isEmpty()) {
			System.out.println("List is Empty.");
		} else if (first.next == null) {
			first = null;
			last = null;
		} else {
			first = first.next;
		}
		System.out.println("Deleteing first " + first.data + "   " + last.data);
		return data;
	}

	public void displayList(Node head) {
		System.out.println("List ( First -- > Last)");
		Node curr = head;
		while (curr != null) {
			curr.displayNode();
			curr = curr.next;
		}
		System.out.println("***********");
	}

	public int deleteLast() {
		int data = 0;
		if (isEmpty()) {
			System.out.println("List is Empty");
		} else if (first.next == null) {
			first = null;
			last = null;
		} else {
			data = last.data;
			Node newNode = first;
			while (newNode.next != last) {
				newNode = newNode.next;
			}
			newNode.next = null;
			last = newNode;
		}
		System.out.println("Deleteing last " + first.data + "   " + last.data);
		return data;
	}

	public Node rotateLinkedList(Node node1, Node node2, int key) {
		// Node ptr1 = node1;
		// Node ptr2 = node2;
		int counter = 0;
		while (counter < key) {
			node2.next = node1;
			node2 = node1;
			node1 = node1.next;
			node2.next = null;
			counter++;
		}
		return node1;
	}

	public Node addTwoList(Node node1, Node node2) {
		Node res = null;
		Node prev = null;
		Node temp = null;
		int sum, carry = 0;
		while (node1 != null || node2 != null) {
			sum = carry + (node1 != null ? node1.data : 0) + (node2 != null ? node2.data : 0);
			carry = (sum >= 10) ? sum / 10 : 0;
			sum = sum % 10;

			temp = new Node(sum);

			if (res == null)
				res = temp;
			else
				prev.next = temp;

			prev = temp;

			if (node1 != null) {
				node1 = node1.next;
			}
			if (node2 != null) {
				node2 = node2.next;
			}
		}
		if (carry > 0) {
			temp.next = new Node(carry);
		}
		return res;
	}

	public static void main(String[] args) {
		CircularLinkedList myList = new CircularLinkedList();
		myList.first = new Node(5);
		myList.first.next = new Node(4);
		myList.first.next.next = new Node(3);
		//myList.first.next.next.next = new Node(4);
		//myList.first.next.next.next.next = new Node(12);
		myList.displayList(first);
		myList.firstNode = new Node(6);
		myList.firstNode.next = new Node(8);
		myList.firstNode.next.next = new Node(2);
		myList.displayList(firstNode);
		Node result = myList.addTwoList(first, firstNode);
		// first=myList.rotateLinkedList(first, last, 4);
		myList.displayList(result);
	}

}
