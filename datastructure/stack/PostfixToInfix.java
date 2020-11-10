package datastructure.stack;

public class PostfixToInfix {
	
	public String postfixToInfixConversion(String exp) {

		StackArray stack = new StackArray();
		for (int i = 0; i<exp.length(); i++) {
			String result = new String("");
			Character c = exp.charAt(i);
			if (Character.isLetterOrDigit(c)) {
				stack.push(c);
			} else {
				if (!stack.isEmpty()) {
					Object c1=stack.pop();
					Object c2=stack.pop();
					result = "(" + c2 + c + c1 + ")";
					stack.push(result);
				}
			}
		}
		return stack.peek().toString();
	}

	public static void main(String[] args) {
		PostfixToInfix ip=new PostfixToInfix();
		System.out.println(ip.postfixToInfixConversion("abcd^e-fgh*+^*i-+"));
	}

}
