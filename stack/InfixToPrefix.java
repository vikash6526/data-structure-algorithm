package datastructure.stack;

import java.util.Stack;

public class InfixToPrefix {

	public int precedence(char ch) {

		switch (ch) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		}
		return -1;
	}

	public String infixToPrefixConversion(String exp) {
		String revStr = new StringReverse().reverse(exp);
		String result = new String("");
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < revStr.length(); i++) {
			Character c = revStr.charAt(i);

			if (Character.isLetterOrDigit(c)) {
				result += c;
			} else if (c == ')') {
				stack.push(c);
			} else if (c == '(') {
				while (!stack.isEmpty() && stack.peek() != ')') {
					result += stack.pop();
				}
				if (!stack.isEmpty() && stack.peek() != ')') {
					System.out.println("Invalid Expression");
				}
				stack.pop();
			} else {
				while (!stack.isEmpty() && precedence(c) < precedence(stack.peek())) {
					if (stack.peek() == ')')
						return "Invalid Expression";
					result += stack.pop();
				}
				stack.push(c);
			}
		}
		while (!stack.isEmpty()) {
			if (stack.peek() == '(')
				return "Invalid Expression";
			result += stack.pop();
		}
		return new StringReverse().reverse(result);
	}

	public static void main(String[] args) {
		InfixToPrefix ip = new InfixToPrefix();
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(ip.infixToPrefixConversion("((2+(3*1))-9)"));
	}

}
