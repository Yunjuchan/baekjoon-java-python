import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> que = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            Deque<Character> front = new ArrayDeque<>();
            Deque<Character> back = new ArrayDeque<>();

            for (char c : br.readLine().toCharArray()) {
                if (c == '-') {
                    if (!front.isEmpty()) {
                        front.pollLast();
                    }
                } else if (c == '<') {
                    if (!front.isEmpty()) {
                        char cur = front.pollLast();
                        back.offerFirst(cur);
                    }
                } else if (c == '>') {
                    if (!back.isEmpty()) {
                        char cur = back.pollFirst();
                        front.offerLast(cur);
                    }
                } else {
                    front.offerLast(c);
                }
            }

            while (!front.isEmpty()) {
                sb.append(front.pollFirst());
            }

            while (!back.isEmpty()) {
                sb.append(back.pollFirst());
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }
}