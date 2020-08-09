package datastructure.stack;

public class StringReverse {
	
	public String reverse(String str) {
		StackArray<Character> st=new StackArray<>();
		String reverseString="";
		for(int i=0;i<str.length();i++) {
			st.push(str.charAt(i));
		}
		while(!st.isEmpty()) {
			reverseString+=st.pop();
		}
		return reverseString;
	}

	public static void main(String[] args) {
		StringReverse strrev=new StringReverse();
		System.out.println(strrev.reverse("abcde"));

	}

}
