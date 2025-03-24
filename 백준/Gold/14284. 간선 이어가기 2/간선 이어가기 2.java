import java.io.*;
import java.util.*;

public class Main {

    public static class Node implements Comparable<Node> {
        int idx;
        int d;

        public Node(int idx, int d) {
            this.idx = idx;
            this.d = d;
        }

        @Override
        public int compareTo(Node other) {
            return this.d - other.d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj.get(a).add(new int[] {b, c});
            adj.get(b).add(new int[] {a, c});
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> que = new PriorityQueue<>();
        que.offer(new Node(s, 0));

        while (!que.isEmpty()) {
            Node now = que.poll();
            if (now.d > dist[now.idx]) {
                continue;
            }
            for (int[] next : adj.get(now.idx)) {
                if (dist[next[0]] <= now.d + next[1]) {
                    continue;
                }
                dist[next[0]] = now.d + next[1];
                que.offer(new Node(next[0], dist[next[0]]));
            }
        }

        System.out.println(dist[e]);


    }
}
