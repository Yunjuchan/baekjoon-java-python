import java.io.*;
import java.util.*;

public class Main {

    public static class Node implements Comparable<Node> {
        int s;
        int e;

        public Node(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Node other) {
            if (this.s == other.s) {
                return Integer.compare(this.e, other.e);
            }
            return Integer.compare(this.s, other.s);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = 0;
        PriorityQueue<Node> que = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            que.offer(new Node(s, e));
        }
        PriorityQueue<Integer> ends = new PriorityQueue<>();

        while (!que.isEmpty()) {
            Node cur = que.poll();

            while (!ends.isEmpty() && ends.peek() <= cur.s) {
                ends.poll();
            }

            ends.offer(cur.e);

            answer = Math.max(answer, ends.size());
        }

        System.out.println(answer);
    }
}