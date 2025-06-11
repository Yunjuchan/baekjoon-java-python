import java.io.*;
import java.util.*;

public class Main {

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
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj.get(a).add(new int[]{b, w});
        }

        int[] size = new int[N + 1];
        List<PriorityQueue<Long>> distList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            distList.add(new PriorityQueue<>());
        }

        size[1] = 1;
        distList.get(1).offer(0L);

        PriorityQueue<Node> que = new PriorityQueue<>();

        que.offer(new Node(1, 0));

        while (!que.isEmpty()) {
            Node cur = que.poll();
            if (distList.size() == K && cur.d > distList.get(cur.idx).peek()) {
                continue;
            }

            for (int[] next : adj.get(cur.idx)) {
                long nextD = cur.d + next[1];
                if (size[next[0]] < K) {
                    distList.get(next[0]).add(-nextD);
                    size[next[0]]++;
                } else {
                    if (distList.get(next[0]).peek() >= -nextD) {
                        continue;
                    }
                    distList.get(next[0]).poll();
                    distList.get(next[0]).offer(-nextD);
                }
                que.offer(new Node(next[0], nextD));
            }
        }
        long[][] distArr = new long[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(distArr[i], Long.MAX_VALUE);
            PriorityQueue<Long> dQueue = distList.get(i);
            for (int j = size[i]; j > 0; j--) {
                distArr[i][j] = -dQueue.poll();
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(distArr[i][K] != Long.MAX_VALUE ? distArr[i][K] : -1).append("\n");
        }
        System.out.println(sb);
    }
}