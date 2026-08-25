package week_7_assignment;

import java.util.Stack;

public class balanced_parenthesis {

    public static void main(String[] args) {
        String s = "[()";

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '(' || c == '{') {
                st.push(c);
            } else {
                if (st.empty()) {
                    System.out.println(false);
                }
                char c1 = st.peek();
                if (c == ']' && c1 != '[') System.out.println(false);
                if (c == ')' && c1 != '(') System.out.println(false);
                if (c == '}' && c1 != '{') System.out.println(false);
                st.pop();
            }
        }
        if (st.empty()) System.out.println(true);
        else System.out.println(false);
    }
}
