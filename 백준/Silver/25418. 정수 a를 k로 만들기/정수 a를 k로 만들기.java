import java.io.*;
import java.util.*;

public class Main {

    public static class Node {
        int n;
        int t;

        public Node(int n, int t) {
            this.n = n;
            this.t = t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[K + 1];

        Queue<Node> que = new LinkedList<>();

        que.offer(new Node(A, 0));
        visited[A] = true;

        while (!que.isEmpty()) {
            Node cur = que.poll();

            if (cur.n + 1 > K || visited[cur.n + 1]) {
            } else if (cur.n + 1 < K) {
                visited[cur.n + 1] = true;
                que.offer(new Node(cur.n + 1, cur.t + 1));
            } else if (cur.n + 1 == K) {
                System.out.println(cur.t + 1);
                return;
            }

            if (cur.n * 2 > K || visited[cur.n * 2]) {
            } if (cur.n * 2 < K) {
                visited[cur.n * 2] = true;
                que.offer(new Node(cur.n * 2, cur.t + 1));
            } else if (cur.n * 2 == K) {
                System.out.println(cur.t + 1);
                return;
            }
        }
    }
}