import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            while (!stack.isEmpty()) {
                int prev = stack.peek();
                if (prev <= a) {
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(a);
        }

        System.out.println(stack.size());
    }
}