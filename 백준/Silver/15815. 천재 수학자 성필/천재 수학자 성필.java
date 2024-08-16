import java.io.*;
import java.util.*;


public class Main {
    static int calc(char command, int x, int y) {
        if (command == '+') {
            return x + y;
        } else if (command == '-') {
            return x - y;
        } else if (command == '*') {
            return x * y;
        } else {
            return x / y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        String line = br.readLine();
        Stack<Integer> A = new Stack<>();
        for (char c : line.toCharArray()) {
            if (c >= 48 && c <= 57) {
                A.push(Integer.parseInt(String.valueOf(c)));
            } else {
                int y = A.pop();
                int x = A.pop();
                A.push(calc(c, x, y));
            }
        }
        System.out.println(A.pop());
    }
}