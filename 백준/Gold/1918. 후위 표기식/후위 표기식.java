import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();

        Stack<String> stack = new Stack<>();
        Stack<String> operator = new Stack<>();
        for (char c : arr) {
            if (c == '*' || c == '/' || c == '+' || c == '-') {
                operator.push(String.valueOf(c));
            } else if (c == '(') {
                stack.push("");
                operator.push("");
            } else if (c == ')') {
                Stack<String> number = new Stack<>();
                Stack<String> op = new Stack<>();

                while (!stack.peek().isEmpty()) {
                     number.push(stack.pop());
                }
                stack.pop();

                while (!operator.peek().isEmpty()) {
                    op.push(operator.pop());
                }
                operator.pop();
                String next = number.pop();
                while (!number.isEmpty()) {
                    next += number.pop() + op.pop();
                }

                if (!operator.isEmpty() && (operator.peek().equals("*") || operator.peek().equals("/"))) {
                    stack.push(stack.pop() + next + operator.pop());
                } else {
                    stack.push(next);
                }
            } else {
                if (!operator.isEmpty() && (operator.peek().equals("*") || operator.peek().equals("/"))) {
                    stack.push(stack.pop() + String.valueOf(c) + operator.pop());
                } else {
                    stack.push(String.valueOf(c));
                }
            }
        }

        String result = stack.get(0);

        for (int i = 1; i < stack.size(); i++) {
            result += stack.get(i) + operator.get(i - 1);
        }

        System.out.println(result);
    }
}