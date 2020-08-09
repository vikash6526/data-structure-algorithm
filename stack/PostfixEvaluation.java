package datastructure.stack;

public class PostfixEvaluation {
	
	public int evaluatePostfix(String exp) {
		StackArray<Integer> stack=new StackArray<>();
		for(int i=0;i<exp.length();i++) {
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
						stack.push(c2+c1);
						break;
					case '-':
						stack.push(c2-c1);
						break;
					case '*':
						stack.push(c2*c1);
						break;
					case '/':
						stack.push(c2/c1);
						break;					
					}
				}
			}
		}
		return (int) stack.pop();
	}

	public static void main(String[] args) {
		PostfixEvaluation ip=new PostfixEvaluation();
		System.out.println(ip.evaluatePostfix("231*+9-"));

	}

}
