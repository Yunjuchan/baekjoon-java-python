import java.io.*;
import java.util.*;

public class Main {

    static int N, cnt;
    static int[] times, prev;
    static boolean[][] used;
    static List<int[]> result;
    static List<List<int[]>> adj;

    public static class Line implements Comparable<Line> {
        int n;
        int t;

        public Line(int n, int t) {
            this.n = n;
            this.t = t;
        }

        @Override
        public int compareTo(Line other) {
            return this.t - other.t;
        }
    }

    public static void dijkstra(int s) {
        PriorityQueue<Line> que = new PriorityQueue<>();
        que.offer(new Line(s, 0));

        while (!que.isEmpty()) {
            Line cur = que.poll();
            for (int[] next : adj.get(cur.n)) {
                if (times[next[0]] >= cur.t + next[1]) {
                    times[next[0]] = cur.t + next[1];
                    prev[next[0]] = cur.n;
                    que.offer(new Line(next[0], cur.t + next[1]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        times = new int[N + 1];
        prev = new int[N + 1];


        Arrays.fill(times, Integer.MAX_VALUE);

        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            adj.get(A).add(new int[] {B, C});
            adj.get(B).add(new int[] {A, C});
        }

        dijkstra(1);

        System.out.println(N - 1);

        for (int i = 2; i <= N; i++) {
            System.out.println(prev[i] + " " + i);
        }

    }
}
