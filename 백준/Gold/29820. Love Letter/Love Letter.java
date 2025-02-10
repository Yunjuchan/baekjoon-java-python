import java.io.*;
import java.util.*;

public class Main {

    public static class Dragon implements Comparable<Dragon> {
        int idx;
        int[] a;
        long t;

        public Dragon(int idx, int[] a, long t) {
            this.idx = idx;
            this.a = a;
            this.t = t;
        }

        @Override
        public int compareTo(Dragon other) {
            return Long.compare(this.t, other.t);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] A = new int[N + 1][2];
        int[] time = new int[N + 1];
        int[] indexing = new int[N + 1];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[1] = 0;

        List<Set<Integer>> close = new ArrayList<>();
        close.add(new HashSet<>());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = i;
            close.add(new HashSet<>());
        }

        Arrays.sort(A, new Comparator<>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int idx = 0;
        for (int i = 1; i <= N; i++) {
            indexing[A[i][1]] = i;
            if (A[i][1] == 1) {
                idx = i;
            }
        }


        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            u = indexing[u];
            v = indexing[v];
            close.get(u).add(v);
            close.get(v).add(u);
        }

        PriorityQueue<Dragon> que = new PriorityQueue<>();

        que.offer(new Dragon(idx, A[idx], 0));

        while (!que.isEmpty()) {
            Dragon dragon = que.poll();
            int u = dragon.idx;

            if (dragon.t > time[A[u][1]]) {
                continue;
            }

            for (int v : close.get(u)) {
                if (time[A[v][1]] > time[A[u][1]]) { // 이동 비용 1 가정
                    time[A[v][1]] = time[A[u][1]];
                    que.offer(new Dragon(v, A[v], time[A[v][1]]));
                }
            }

            if (u > 1) {
                int v = u - 1;
                if (time[A[v][1]] > time[A[u][1]] + Math.abs(A[u][0] - A[v][0])) {
                    time[A[v][1]] = time[A[u][1]] + Math.abs(A[u][0] - A[v][0]);
                    que.offer(new Dragon(v, A[v], time[A[v][1]]));
                }
            }
            if (u < N) {
                int v = u + 1;
                if (time[A[v][1]] > time[A[u][1]] + Math.abs(A[u][0] - A[v][0])) {
                    time[A[v][1]] = time[A[u][1]] + Math.abs(A[u][0] - A[v][0]);
                    que.offer(new Dragon(v, A[v], time[A[v][1]]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(time[i]).append(" ");
        }
        System.out.println(sb);
    }
}