package datastructure.queue;

public class ArrayQueue {

	private Object[] objQueue;
	public int front;
	public int back;

	ArrayQueue(int size) {
		objQueue = new Object[size];
		front = 0;
		back = 0;
	}

	public void add(Object obj) {
		if (size() == objQueue.length-1) {
			Object[] newArray = new Object[2 * objQueue.length];
			System.arraycopy(objQueue, 0, newArray, 0, objQueue.length);
			objQueue = newArray;
		}
		objQueue[back] = obj;
		back++;
	}

	public Object peek() {
		if (front == back) {
			System.out.println("Queue is Empty");
			front = 0;
			back = 0;
		} else {
			return objQueue[front];
		}
		return null;
	}

	public Object pop() {
		if (front == back) {
			System.out.println("Queue is Empty");
			front = 0;
			back = 0;
		} else {
			Object obj = objQueue[front];
			front++;
			return obj;
		}
		return null;
	}
	
	public int size() {
		return back-front;
	}

	public void printQueue() {
		for (int i = front; i < back; i++) {
			System.out.println(objQueue[i]);
		}
		System.out.println("***************");
	}
	
	public static void main(String[] args) {
		ArrayQueue queue=new ArrayQueue(10);
		queue.add(50);
		queue.add(40);
		queue.add(30);
		queue.add(20);
		queue.add(10);
		
		queue.printQueue();
		
		queue.pop();
		queue.pop();
		queue.printQueue();
		System.out.println(queue.peek());
		queue.printQueue();

	}

}
