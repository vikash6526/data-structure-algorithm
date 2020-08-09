package datastructure;

public class LinkedListBasic {

	public Node first;

	public void insert(int data) {
		Node newNode = new Node(data);
		if (first == null) {
			newNode.next = first;
			first = newNode;
		} else {
			Node current = first;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
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

	public static void main(String[] args) {
		LinkedListBasic ls=new LinkedListBasic();
		ls.insert(10);
		ls.insert(20);
		ls.insert(30);
		ls.insert(40);
		
		ls.displayList();

	}

}
