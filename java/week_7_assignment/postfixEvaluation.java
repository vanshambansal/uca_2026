package week_7_assignment;

import java.util.Stack;

public class postfixEvaluation {

    static int postfixCalculator(String s) {

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                st.push(c - '0');
            } else {
                int b = st.pop();
                int a = st.pop();
                if (c == '+') {
                    st.push(a + b);
                }
                if (c == '-') {
                    st.push(a - b);
                }
                if (c == '*') {
                    st.push(a * b);
                }
                if (c == '/') {
                    st.push(a / b);
                }
                if (c == '^') {
                    st.push((int)(Math.pow(a, b)));
                }
            }
        }

        return st.pop();

    }

    public static void main(String[] args) {

        String s = "31*2+9-";
        System.out.println(postfixCalculator(s));
    }

}
