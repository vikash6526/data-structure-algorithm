package datastructure.stack;

public class TwoStacks {

	public static final int MAX = 1000;

	static int a[] = new int[MAX];
	int topOfStack1, topOfStack2;

	TwoStacks() {
		topOfStack1 = -1;
		topOfStack2 = MAX;
	}

	public void push2(int x) {
		if (topOfStack1 < topOfStack2 - 1) {
			a[--topOfStack2] = x;
		} else
			System.out.println("Stack Overflow");
	}

	public void push1(int x) {
		if (topOfStack1 < topOfStack2 - 1) {
			a[++topOfStack1] = x;
		} else
			System.out.println("Stack Overflow");
	}

	public int pop1() {
		if (topOfStack1 >= 0) {
			int x = a[topOfStack1];
			topOfStack1--;
			return x;
		} else {
			System.out.println("Stack Underflow");
		}
		return 0;
	}

	public int pop2() {
		if (topOfStack2 < MAX) {
			int x = a[topOfStack2];
			topOfStack2++;
			return x;
		} else {
			System.out.println("Stack Underflow");
		}
		return 0;
	}

	public static void main(String[] args) {
		TwoStacks ts = new TwoStacks();
		ts.push1(5);
		ts.push2(10);
		ts.push2(15);
		ts.push1(11);
		ts.push2(7);
		ts.push2(40);
		System.out.println("Popped element from" + 
                " stack1 is " + ts.pop1());
		System.out.println("Popped element from" + 
                " stack2 is " + ts.pop2());

	}

}
