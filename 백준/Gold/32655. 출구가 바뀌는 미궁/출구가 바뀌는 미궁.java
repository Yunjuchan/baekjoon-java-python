import java.io.*;
import java.util.*;

public class Main {

    public static class Edge {
        int next;
        int c;

        public Edge(int next, int c) {
            this.next = next;
            this.c = c;
        }
    }

    public static class Position implements Comparable<Position>{
        int now;
        long d;

        public Position(int now, long d) {
            this.now = now;
            this.d = d;
        }

        @Override
        public int compareTo(Position o) {
            return Long.compare(this.d, o.d);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long dist[] = new long[N+1];

        List<List<Edge>> adj = new ArrayList<>();

        for (int i=0; i<=N; i++) {
            dist[i] = Long.MAX_VALUE;
            adj.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj.get(a).add(new Edge(b, c));
            adj.get(b).add(new Edge(a, c));
        }

        Queue<Position> que = new PriorityQueue<>();
        que.offer(new Position(1, 0));
        dist[1] = 0;
        while (!que.isEmpty()) {
            Position p = que.poll();
            if (p.d > dist[p.now]) {
                continue;
            }

            for (Edge e : adj.get(p.now)) {
                if (dist[e.next] > p.d + e.c) {
                    dist[e.next] = p.d + e.c;
                    que.offer(new Position(e.next, dist[e.next]));
                }
            }
        }
        long result = Long.MAX_VALUE;
        int X = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<X; i++) {
            int e = Integer.parseInt(st.nextToken());
            long q = dist[e] / K;
            if (q % X == i) {
                result = Math.min(result, dist[e]);
            } else if (q % X > i) {
                result = Math.min(result, (q + X - q % X + i) * K);
            } else {
                result = Math.min(result, (q - q % X + i) * K);
            }
        }
        System.out.println(result);
    }
}