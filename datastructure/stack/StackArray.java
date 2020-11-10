package datastructure.stack;

public class StackArray<E> {

	public static final int MAX = 1000;

	Object a[] = new Object[MAX];
	
	public int min = Integer.MAX_VALUE;

	public int topOfStack;

	StackArray() {
		topOfStack = -1;
	}

	public boolean isEmpty() {
		return (topOfStack < 0);
	}
	
	public boolean stackOverflow() {
		if (topOfStack >= (MAX - 1))
			return true;
		return false;
	}

	public E push(E x) {
		if (!stackOverflow()) {
			a[++topOfStack] = x;
			return x;
		}
		return null;	
	}

	public Object pop() {
		if (!isEmpty()) {
			return a[topOfStack--];
		}
		return 0;
	}

	public Object peek() {
		if (!isEmpty()) {
			return a[topOfStack];
		}
		return 0;
	}
	
	public int getMin() {
        int top = topOfStack;
        int min=Integer.MAX_VALUE;
        while(top>=0){
            min=Math.min(min,(int) a[top]);
            top--;
        } 
        return min;
    }

	public static void main(String[] args) {
		StackArray stack = new StackArray();
		stack.push(2147483646);
		System.out.println(stack.getMin());
		System.out.println(stack.pop());
		stack.push(2147483647);
		System.out.println(stack.getMin());
		
	}

}
