package datastructure;

public class linkedlist {

	public static void main(String[] args) {
		Node nodeA=new Node(4);
		Node nodeB=new Node(3);
		Node nodeC=new Node(7);
		Node nodeD=new Node(8);
		
		nodeA.next=nodeB;
		nodeB.next=nodeC;
		nodeC.next=nodeD;
		
		System.out.println(listlength(nodeA));
		System.out.println(listlength(nodeB));
		System.out.println(listlength(nodeC));
		System.out.println(listlength(nodeD));
		
	}
	
	public static int listlength(Node node) {
		int length=0;
		
		Node currentNode=node;
		while(currentNode!=null) {
			length++;
			currentNode=currentNode.next;
		}
		
		return length;
	}

}
