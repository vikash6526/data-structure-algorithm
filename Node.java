package datastructure;

import java.util.Stack;

public class Node {

	public static Node first;
	public static Node result;
	public int data;
	public Node next;

	public Node() {

	}

	public Node(int data) {
		this.data = data;
		this.next = null;
	}

	public void displayNode() {
		System.out.print(data);
	}

	public static void addReverse(Node l1, Node l2) {
		int carry = 0;
		while(l1!=null || l2!=null) {
			int n1 = 0;
			int n2 = 0;
			int data=0;
			if(l1!=null) {
				n1=l1.data;
				l1=l1.next;
			}
			if(l2!=null) {
				n2=l2.data;
				l2=l2.next;
			}
			data=n1+n2+carry;
			carry = data / 10;
			if(result==null) {
				result=new Node(data % 10);
				result.next=first;
				first=result;
			}
			else {
			Node newNode = new Node(data % 10);
			result.next = newNode;
			result = result.next;
			}
		}
		while(carry>0){
            Node newNode = new Node(carry%10);
			result.next = newNode;
			result = result.next;
			carry=carry/10;
        }
	}
	public static void addreverse(Node l1, Node l2) {
		int n1Data = 0;
		int n2Data = 0;
		Stack<Integer> l1Stack = new Stack<Integer>();
		Stack<Integer> l2Stack = new Stack<Integer>();
		while (l1 != null || l2 != null) {
			if (l1 != null) {
				l1Stack.push(l1.data);
				l1 = l1.next;
			}
			if (l2 != null) {
				l2Stack.push(l2.data);
				l2 = l2.next;
			}
		}
		
		first = result;
		int carry = 0;
		while (!l1Stack.isEmpty() || !l2Stack.isEmpty()) {
			int data = 0;
			if (!l1Stack.isEmpty())
				n1Data = l1Stack.pop();
			if (!l2Stack.isEmpty())
				n2Data = l2Stack.pop();
			data = n1Data + n2Data + carry;
			carry = data / 10;
			if(result==null) {
				result=new Node(data % 10);
				result.next=first;
				first=result;
				System.out.println(result.data);
			}
			else {
			Node newNode = new Node(data % 10);
			result.next = newNode;
			System.out.println(result.data);
			result = result.next;
			}
		}
		while(carry>0){
            Node newNode = new Node(carry%10);
			result.next = newNode;
			result = result.next;
			carry=carry/10;
        }
	}

	public static void main(String[] args) {
		Node n1 = new Node(1);
		n1.next = new Node(8);
		//n1.next.next = new Node(3);

		Node n2 = new Node(0);
		//n2.next = new Node(6);
		//n2.next.next = new Node(4);

		addReverse(n1, n2);

	}

}
