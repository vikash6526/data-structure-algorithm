package datastructure.stack;

import java.util.Stack;

public class InfixToPostfix {

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

	public String infixToPostfixConversion(String exp) {

		String result = new String("");
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);

			if (Character.isLetterOrDigit(c)) {
				result += c;
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					result += stack.pop();
				}
				if (!stack.isEmpty() && stack.peek() != '(')
					return "Invalid Expression";
				else
					stack.pop();
			} else {
				while (!stack.isEmpty() && precedence(c) < precedence(stack.peek())) {
					if (stack.peek() == '(')
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
		return result;
	}

	public static void main(String[] args) {
		InfixToPostfix ip = new InfixToPostfix();
		String exp = "a+b*(c^d-e)^(f+g*h)-i";
		//String exp="a+b*c-d/e^f";
		System.out.println(ip.infixToPostfixConversion(exp));
	}

}
