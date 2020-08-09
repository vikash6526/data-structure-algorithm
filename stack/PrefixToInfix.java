package datastructure.stack;

public class PrefixToInfix {

	public String prefixToInfixConversion(String exp) {

		StackArray stack = new StackArray();
		for (int i = exp.length() - 1; i >= 0; i--) {
			String result = new String("");
			Character c = exp.charAt(i);
			if (Character.isLetterOrDigit(c)) {
				stack.push(c);
			} else {
				if (!stack.isEmpty()) {
					result = "(" + stack.pop() + c + stack.pop() + ")";
					stack.push(result);
				}
			}
		}
		return stack.peek().toString();
	}

	public static void main(String[] args) {
		PrefixToInfix ip = new PrefixToInfix();
		System.out.println(ip.prefixToInfixConversion("-+a*b^-^cde+f*ghi"));

	}

}
