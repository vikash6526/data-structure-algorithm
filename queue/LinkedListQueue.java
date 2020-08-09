package datastructure.queue;

import datastructure.Node;

public class LinkedListQueue {
	
	private Node front;
	private Node rear;
	
	LinkedListQueue(){
		this.front=this.rear=null;
	}
	
	public void add(int data) {
		Node newNode = new Node(data);
		if(rear==null) {
			rear=front=newNode;
		}
		rear.next=newNode;
		rear=newNode;
	}
	
	
	public int delete() {
		int data=0;
		if(front==null) {
			rear=null;
			System.out.println("Queue is empty");
		}
		else {
			data=front.data;
			front=front.next;
		}
		return data;
	}

	public static void main(String[] args) {
		LinkedListQueue lq=new LinkedListQueue();
		lq.add(100);
		lq.add(200);
		lq.add(300);
		System.out.println("deleted "+lq.delete());
		lq.add(400);
		lq.add(500);
		lq.add(600);
		System.out.println("deleted "+lq.delete());
		System.err.println("Front Key "+lq.front.data);
		System.err.println("Rear Key "+lq.rear.data);

	}

}
