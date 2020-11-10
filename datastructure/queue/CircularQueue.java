package datastructure.queue;

import java.util.NoSuchElementException;

public class CircularQueue {

	private Object[] cQueue;
	public int front;
	public int back;

	public CircularQueue(int size) {
		cQueue = new Object[size];
		front = 0;
		back = 0;
	}

	public void add(Object obj) {
		if (size() == cQueue.length - 1) {
			int numItem = size();
			Object[] newArray = new Object[2 * cQueue.length];
			System.arraycopy(cQueue, front, newArray, 0, cQueue.length - 1);
			System.arraycopy(cQueue, 0, newArray, cQueue.length - 1, back);
			cQueue = newArray;
			back = numItem;
		}
		cQueue[back] = obj;
		if (back < cQueue.length - 1) {
			back++;
		} else {
			back = 0;
		}
	}

	public Object pop() {
		if (size() == 0) {
			System.out.println("Queue is Empty");
			front = 0;
			back = 0;
			throw new NoSuchElementException();
		}

		Object obj = cQueue[front];
		front++;
		if (front == cQueue.length) {
			front = 0;
		}
		return obj;
	}

	public Object peek() {
		if (size() == 0) {
			System.out.println("Queue is Empty");
			front = 0;
			back = 0;
			throw new NoSuchElementException();
		}

		return cQueue[front];
	}

	public int size() {
		if (front <= back) {
			return back - front;
		} else {
			return back - front + cQueue.length;
		}
	}

	public void printQueue() {
		if (front <= back) {
			for (int i = front; i < back; i++) {
				System.out.println(cQueue[i]);
			}
		} else {
			for (int i = front; i < cQueue.length; i++)
				System.out.println(cQueue[i]);
			for (int i = 0; i < back; i++)
				System.out.println(cQueue[i]);
		}
		System.out.println("***************");
	}

}
