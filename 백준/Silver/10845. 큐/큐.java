import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> que = new LinkedList<>();
        int last = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String query = st.nextToken();

            if (query.equals("push")) {
                last = Integer.parseInt(st.nextToken());
                que.offer(last);
            } else if (query.equals("pop")) {
                if (que.isEmpty()) {
                    System.out.println( -1);
                } else {
                    System.out.println(que.poll());
                }
            } else if (query.equals("size")) {
                System.out.println(que.size());
            } else if (query.equals("empty")) {
                if (que.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (query.equals("front")) {
                if (que.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(que.peek());
                }
            } else {
                if (que.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(last);
                }
            }
        }
    }
}