import java.io.*;
import java.util.*;

public class Main {

    public static class Node implements Comparable<Node> {
        int subway;
        int t;
        int tCnt;

        public Node(int subway, int t, int tCnt) {
            this.subway = subway;
            this.t = t;
            this.tCnt = tCnt;
        }

        @Override
        public int compareTo(Node other) {
            if (this.tCnt == other.tCnt) {
                return this.t - other.t;
            }
            return this.tCnt - other.tCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] corp = new int[N];
        for (int i = 0; i < N; i++) {
            corp[i] = Integer.parseInt(br.readLine());
        }

        int[][] adj = new int[N][N];
        int[][] routes = new int[N][2];

        for (int i = 0; i < N; i++) {
            Arrays.fill(routes[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Node> que = new PriorityQueue<>();

        que.offer(new Node(0, 0, 0));

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int subway = cur.subway;
            int t = cur.t;
            int tCnt = cur.tCnt;
            if (routes[subway][0] < tCnt || ((routes[subway][0] == tCnt) && (routes[subway][1] < t))) {
                continue;
            }

            for (int i = 0; i < N; i++) {
                if (adj[subway][i] == 0) {
                    continue;
                }
                if (corp[subway] != corp[i]) {
                    if ((routes[i][0] > tCnt + 1) || ((routes[i][0] == tCnt + 1) && routes[i][1] > t + adj[subway][i])) {
                        routes[i][0] = tCnt + 1;
                        routes[i][1] = t + adj[subway][i];
                        que.offer(new Node(i, routes[i][1], tCnt + 1));
                    }
                } else {
                    if ((routes[i][0] > tCnt) || ((routes[i][0] == tCnt) && routes[i][1] > t + adj[subway][i])) {
                        routes[i][0] = tCnt;
                        routes[i][1] = t + adj[subway][i];
                        que.offer(new Node(i, routes[i][1], tCnt));
                    }
                }
            }
        }

        System.out.println(routes[M][0] + " " + routes[M][1]);

    }
}