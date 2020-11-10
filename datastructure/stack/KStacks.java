package datastructure.stack;

public class KStacks {

	int arr[];
	int top[];
	int next[];

	int n, k;
	int free;

	KStacks(int n, int k) {
		this.n = n;
		this.k = k;

		arr = new int[n];
		top = new int[k];
		next = new int[n];

		free = 0;

		for (int i = 0; i < k; i++)
			top[i] = -1;
		for (int i = 0; i < n - 1; i++)
			next[i] = i + 1;
		next[n - 1] = -1;
	}

	public boolean isEmpty(int sn) {
		if (top[sn] == -1)
			return true;
		return false;
	}

	public boolean isFull() {
		return (free==-1);
	}

	public void push(int key, int sn) {
		if (isFull()) {
			System.out.println("Stack Overflow");
			return;
		}
		int i = free;
		free = next[i];

		next[i] = top[sn];
		top[sn] = i;

		arr[i] = key;
	}

	public int pop(int sn) {
		if (isEmpty(sn)) {
			System.out.println("Stacks Empty");
			return Integer.MAX_VALUE;
		}

		int i = top[sn];

		top[sn] = next[i];
		next[i] = free;

		return arr[i];
	}

	public static void main(String[] args) {
		// Let us create 3 stacks in an array of size 10
		int k = 3, n = 10;

		KStacks ks = new KStacks(n, k);

		ks.push(15, 2);
		ks.push(45, 2);

		// Let us put some items in stack number 1
		ks.push(17, 1);
		ks.push(49, 1);
		ks.push(39, 1);

		// Let us put some items in stack number 0
		ks.push(11, 0);
		ks.push(9, 0);
		ks.push(7, 0);
		
		ks.push(8, 2);

		System.out.println("Popped element from stack 2 is " + ks.pop(2));
		System.out.println("Popped element from stack 2 is " + ks.pop(2));
		ks.push(50, 2);
		ks.push(51, 2);
		System.out.println("Popped element from stack 2 is " + ks.pop(2));
		System.out.println("Popped element from stack 2 is " + ks.pop(2));
		System.out.println("Popped element from stack 1 is " + ks.pop(1));
		System.out.println("Popped element from stack 0 is " + ks.pop(0));
	}

}
