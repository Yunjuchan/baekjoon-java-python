import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<List<int[]>> adj;

    public static class Node implements Comparable<Node> {
        int idx;
        long d;

        public Node(int idx, long d) {
            this.idx = idx;
            this.d = d;
        }

        @Override
        public int compareTo(Node other) {
            return Long.compare(this.d, other.d);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj.get(a).add(new int[]{b, w});
            adj.get(b).add(new int[]{a, w});
        }

        PriorityQueue<Node> que = new PriorityQueue<>();
        int[] cnt = new int[N + 1];
        long[] distance = new long[2 * N + 1];
        Arrays.fill(distance, Long.MAX_VALUE);

        que.offer(new Node(1, 0));
        distance[1] = 0;
        cnt[1]++;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            if (cur.d > distance[cur.idx + N]) {
                continue;
            }

            for (int[] next : adj.get(cur.idx)) {
                long nextD = cur.d + next[1];
                if (cnt[next[0]] == 0) {
                    distance[next[0]] = nextD;
                    cnt[next[0]]++;
                } else if (cnt[next[0]] == 1) {
                    if (distance[next[0]] < nextD) {
                        distance[next[0] + N] = nextD;
                    } else {
                        distance[next[0] + N] = distance[next[0]];
                        distance[next[0]] = nextD;
                    }
                    cnt[next[0]]++;
                } else {
                    if (distance[next[0] + N] <= nextD) {
                        continue;
                    } else if (distance[next[0]] <= nextD) {
                        distance[next[0] + N] = nextD;
                    } else {
                        distance[next[0] + N] = distance[next[0]];
                        distance[next[0]] = nextD;
                    }
                }
                que.offer(new Node(next[0], nextD));
            }
        }
        System.out.println(distance[N * 2]);
    }
}