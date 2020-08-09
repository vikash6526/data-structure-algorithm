package datastructure.stack;

public class PrefixEvaluation {
	
	public int evaluatePrefix(String exp) {
		StackArray<Integer> stack=new StackArray<>();
		for(int i = exp.length() - 1; i >= 0; i--) {
			Character c=exp.charAt(i);
			if(Character.isDigit(c)) {
				stack.push(c-'0');
			}
			else {
				if(stack.topOfStack>0) {
					int c1=(int) stack.pop();
					int c2=(int) stack.pop();
					
					switch(c) {
					case '+':
						stack.push(c1+c2);
						break;
					case '-':
						stack.push(c1-c2);
						break;
					case '*':
						stack.push(c1*c2);
						break;
					case '/':
						stack.push(c1/c2);
						break;					
					}
				}
			}
		}
		return (int) stack.pop();
	}

	public static void main(String[] args) {
		PrefixEvaluation ip =new PrefixEvaluation();
		System.out.println(ip.evaluatePrefix("-+2*319"));
	}

}
