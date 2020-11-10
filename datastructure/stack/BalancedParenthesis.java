package datastructure.stack;

import java.util.Stack;

public class BalancedParenthesis {

	public boolean isBalancesParenthesis(char exp[]) {
		Stack<Character> st = new Stack<>();

		for (int i = 0; i < exp.length; i++) {
			if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[')
				st.push(exp[i]);

			if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']') {
				if (st.isEmpty())
					return false;

				else if (!isMatchingPair(st.pop(), exp[i])) {
					return false;
				}
			}
		}
		if (st.isEmpty())
			return true;
		else
			return false;

	}

	public boolean isMatchingPair(char char1, char char2) {
		if (char1 == '(' && char2 == ')')
			return true;
		else if (char1 == '{' && char2 == '}')
			return true;
		else if (char1 == '[' && char2 == ']')
			return true;
		return false;

	}

	public static void main(String[] args) {
		BalancedParenthesis bp=new BalancedParenthesis();
		char exp[] = {'{','(',')','}','[',']'}; 
        if (bp.isBalancesParenthesis(exp)) 
          System.out.println("Balanced "); 
        else
          System.out.println("Not Balanced ");

	}

}
