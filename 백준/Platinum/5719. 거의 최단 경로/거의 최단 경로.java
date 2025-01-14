import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<List<int[]>> adj, reverseAdj;
    static boolean[][] excepted;

    static class Vertex implements Comparable<Vertex> {
        int x;
        int d;

        Vertex(int x, int d) {
            this.x = x;
            this.d = d;
        }

        @Override
        public int compareTo(Vertex other) {
            return this.d - other.d;
        }
    }

    public static void bfs(int D, int[] dist) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[N];
        que.offer(D);
        visited[D] = true;

        while (!que.isEmpty()) {
            int v = que.poll();

            for (int[] next : reverseAdj.get(v)) {
                if (dist[next[0]] + next[1] == dist[v]) {
                    excepted[next[0]][v] = true;
                    if (visited[next[0]]) {
                        continue;
                    }
                    que.offer(next[0]);
                    visited[next[0]] = true;
                }
            }
        }
    }


    public static int[] dijk(int S) {
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        PriorityQueue<Vertex> que = new PriorityQueue<>();
        que.offer(new Vertex(S, 0));

        while (!que.isEmpty()) {
            Vertex v = que.poll();
            if (v.d > dist[v.x]) {
                continue;
            }

            for (int[] next : adj.get(v.x)) {
                if (excepted[v.x][next[0]]) {
                    continue;
                }
                if (dist[next[0]] > v.d + next[1]) {
                    dist[next[0]] = v.d + next[1];
                    que.offer(new Vertex(next[0], dist[next[0]]));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            }

            adj = new ArrayList<>();
            reverseAdj = new ArrayList<>();
            excepted = new boolean[N][N];

            for (int i=0; i<N; i++) {
                adj.add(new ArrayList<>());
                reverseAdj.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            for (int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int U = Integer.parseInt(st.nextToken());
                int V = Integer.parseInt(st.nextToken());
                int P = Integer.parseInt(st.nextToken());
                adj.get(U).add(new int[]{V, P});
                reverseAdj.get(V).add(new int[]{U, P});
            }

            int[] dist = dijk(S);

            bfs(D, dist);

            dist = dijk(S);

            if (dist[D] == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(dist[D]);
            }
        }
    }
}