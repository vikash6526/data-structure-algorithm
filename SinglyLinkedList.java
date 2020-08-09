package datastructure;

public class SinglyLinkedList {
	private static Node first;
	private Node last;

	public SinglyLinkedList() {

	}

	public boolean isEmpty() {
		return (first == null);
	}

	public void insertFirst(int data) {
		Node newNode = new Node(data);
		// newNode.data = data;
		newNode.next = first;
		first = newNode;

	}

	public Node deleteFirst() {
		Node temp = first;
		first = first.next;
		return temp;

	}

	public void displayList() {
		System.out.println("List ( First -- > Last)");
		Node curr = first;
		System.out.print("[");
		while (curr != null) {
			curr.displayNode();
			curr = curr.next;
			if (curr != null)
				System.out.print(",");
		}
		System.out.println("]");
		System.out.println("***********");
	}
	public void displayList(Node node) {
		System.out.println("List ( First -- > Last)");
		Node curr = node;
		System.out.print("[");
		while (curr != null) {
			curr.displayNode();
			curr = curr.next;
			if (curr != null)
				System.out.print(",");
		}
		System.out.println("]");
		System.out.println("***********");
	}

	public void insertLast(int data) {
		Node current = first;
		while (current.next != null) {
			current = current.next;
		}
		Node newNode = new Node(data);
		// newNode.data = data;
		current.next = newNode;
	}

	public void swapNode(int x, int y) {
		if (x == y) {
			return;
		}

		Node prevX = null;
		Node currX = first;
		while (currX != null && currX.data != x) {
			prevX = currX;
			currX = currX.next;
		}

		Node prevY = null;
		Node currY = first;
		while (currY != null && currY.data != y) {
			prevY = currY;
			currY = currY.next;
		}

		if (currX == null && currY == null) {
			return;
		}

		if (prevX != null)
			prevX.next = currY;
		else
			first = currY;

		if (prevY != null)
			prevY.next = currX;
		else
			first = currX;
		Node temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;

	}

	public void reverse() {
		Node prev = null;
		Node current = first;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		first = prev;
	}

	public Node reverseGroup(Node node, int k) {
		Node current = node;
		int length = 0;
		while (current != null) {
			current = current.next;
			length++;
		}
		Node prev = null;
		Node next = null;
		current = node;
		int count = 0;
		while (count < k && current != null && length >= k) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
        length=length-count;
		if (next != null && length >= k) {
			node.next = reverseGroup(next, k);
		}
		if(length<k)
			node.next=next;
		displayList(prev);
		return prev;
	}

	public int detectAndRemoveLoop(Node node) {
		Node slow = node, fast = node;
		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				removeLoop(slow, node);
				return 1;
			}
		}
		return 0;
	}

	public void removeLoop(Node loop, Node node) {
		Node ptr1 = null, ptr2 = null;
		ptr1 = node;
		int count = 0;
		while (1 == 1) {
			ptr2 = loop;
			while (ptr2.next != loop && ptr2.next != ptr1) {
				ptr2 = ptr2.next;
			}
			if (ptr2.next == ptr1) {
				break;
			}
			ptr1 = ptr1.next;
			count++;
		}
		ptr2.next = null;
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
		}
		return node1;
	}

	public static int getDigit() {
		int digit = 0;
		Node curr = first;
		while (curr != null) {
			digit = digit * 10 + curr.data;
			curr = curr.next;
		}
		Node currNode = new Node(digit % 10);
		first = currNode;
		digit = digit / 10;
		while (digit > 0) {
			Node listNode = new Node(digit % 10);
			digit = digit / 10;
			currNode = listNode;
			currNode = currNode.next;
		}
		return digit;
	}

	public static long reverseDigit(int data) {
		long digit = 0L;
		while (data > 0) {
			digit = digit * 10 + data % 10;
			data = data / 10;
		}
		return digit;
	}

	public static void main(String[] args) {
		SinglyLinkedList myList = new SinglyLinkedList();
		myList.first = new Node(1);
		myList.first.next = new Node(2);
		myList.first.next.next = new Node(3);
		myList.first.next.next.next = new Node(4);
		myList.first.next.next.next.next = new Node(5);
		// myList.first.next.next.next=myList.first.next;

		// myList.detectAndRemoveLoop(first);
		myList.reverseGroup(first, 3);

		// SinglyLinkedList myList1 = new SinglyLinkedList();

		/*
		 * myList.insertLast(400); myList.insertLast(500); myList.insertLast(600);
		 * myList.first = new Node(100); myList.first.next = new Node(200);
		 * myList.first.next.next = new Node(300); myList.first.next.next.next = new
		 * Node(400); myList.first.next.next.next.next = new Node(500);
		 * myList.first.next.next.next.next.next = new Node(600);
		 * myList.first.next.next.next.next.next.next = new Node(700);
		 * 
		 * myList.first.next.next.next.next.next.next.next = myList.first.next.next;
		 * 
		 * // myList.displayList(); // first = myList.reverseGroup(first, 3);
		 * myList.detectAndRemoveLoop(first);
		 */
		//myList.displayList();
		// System.out.println(10%10);
		// System.out.println(reverseDigit(1999999999));

	}

}
