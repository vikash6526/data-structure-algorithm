package datastructure.stack;


public class StackLinkedList {

	public StackNode head;

	public class StackNode {
		public int data;
		public StackNode next;

		StackNode(int data) {
			this.data = data;
		}

		public void displayNode() {
			System.out.println("{ " + data + " }");
		}
	}

	public boolean isEmpty() {
		if (head == null)
			return true;
		else
			return false;
	}

	public void push(int data) {
		StackNode newNode = new StackNode(data);
		if (isEmpty())
			head = newNode;
		else {
			newNode.next = head;
			head = newNode;
		}
	}
	
	public int pop() {
		if(!isEmpty()) {
			int data = head.data;
			head=head.next;
			return data;
		}
		return 0;
	}
	
	public int peek() {
		if(!isEmpty()) {
			return head.data;
		}
		return 0;
	}

	public void displayList() {
		System.out.println("List ( First -- > Last)");
		StackNode curr = head;
		while (curr != null) {
			curr.displayNode();
			curr = curr.next;
		}
		System.out.println("***********");
	}

	public static void main(String[] args) {
		StackLinkedList myList=new StackLinkedList();
		myList.push(30);
		myList.push(20);
		myList.push(10);
		myList.displayList();
		System.out.println("Poped Value "+ myList.pop());
		myList.displayList();
		System.out.println("Peek Value "+ myList.peek());
		myList.displayList();
		

	}

}
