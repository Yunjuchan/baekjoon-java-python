import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (order.equals("push")) {
                int x = Integer.parseInt(st.nextToken());
                stack.push(x);
            } else if (order.equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.pop());
                }
            } else if (order.equals("size")) {
                System.out.println(stack.size());
            } else if (order.equals("empty")) {
                if (stack.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.peek());
                }
            }

        }
    }
}