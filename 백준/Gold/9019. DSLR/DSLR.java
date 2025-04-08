import java.io.*;
import java.util.*;

public class Main {

    public static class Node {
        String order;
        int n;

        public Node(String order, int n) {
            this.order = order;
            this.n = n;
        }
    }

    public static int D(int number) {
        return number * 2 % 10000;
    }

    public static int S(int number) {
        return (number + 9999) % 10000;
    }

    public static int L(int number) {
        return number / 1000 + number % 1000 * 10;
    }

    public static int R(int number) {
        return number % 10 * 1000 + number / 10;
    }

    public static String bfs(int s, int e) {
        boolean[] visited = new boolean[10001];
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node("", s));
        visited[s] = true;

        while (!que.isEmpty()) {
            Node cur = que.poll();

            if (cur.n == e) {
                return cur.order;
            }

            if (!visited[D(cur.n)]) {
                visited[D(cur.n)] = true;
                que.offer(new Node(cur.order + "D", D(cur.n)));
            }
            if (!visited[S(cur.n)]) {
                visited[S(cur.n)] = true;
                que.offer(new Node(cur.order + "S", S(cur.n)));
            }
            if (!visited[L(cur.n)]) {
                visited[L(cur.n)] = true;
                que.offer(new Node(cur.order + "L", L(cur.n)));
            }
            if (!visited[R(cur.n)]) {
                visited[R(cur.n)] = true;
                que.offer(new Node(cur.order + "R", R(cur.n)));
            }
        }
        return "";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t <T; t++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(bfs(s, e)).append("\n");
        }
        System.out.println(sb);
    }
}
