import java.io.*;
import java.util.*;

public class Main {
    static int V;
    static List<List<Route>> adj;
    public static class Route {
        int next;
        int t;

        public Route(int next, int t) {
            this.next = next;
            this.t = t;
        }
    }

    public static class Position implements Comparable<Position>{
        int now;
        int d;

        @Override
        public int compareTo(Position o) {
            return this.d - o.d;
        }

        public Position(int now, int d) {
            this.now = now;
            this.d = d;
        }
    }

    static int dijkstra(int s, int e) {
        int[] distance = new int[V+1];
        for (int i=0; i<V+1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[s] = 0;

        PriorityQueue<Position> que = new PriorityQueue<>();
        que.add(new Position(s, 0));

        while (!que.isEmpty()) {
            Position p = que.poll();
            if (p.d > distance[p.now]) {
                continue;
            }
            for (Route r : adj.get(p.now)) {
                if (distance[r.next] > p.d + r.t) {
                    distance[r.next] = p.d + r.t;
                    que.add(new Position(r.next, distance[r.next]));
                }
            }
        }
        return distance[e];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        adj = new ArrayList<>();
        for (int i=0; i<=V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            adj.get(s).add(new Route(e, t));
            adj.get(e).add(new Route(s, t));
        }

        int oneToHome = dijkstra(1, V);
        int oneToP = dijkstra(1, P);
        int pToHome = dijkstra(P, V);
        if (oneToHome == oneToP + pToHome) {
            System.out.println("SAVE HIM");
        } else {
            System.out.println("GOOD BYE");
        }

    }
}