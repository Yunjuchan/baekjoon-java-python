import java.beans.beancontext.BeanContextChildComponentProxy;
import java.io.*;
import java.util.*;

public class Main {

    static int N, S;
    static long result;
    static int[] willVisit, dist;
    static int[][] distStore;
    static boolean[] visited;
    static List<List<int[]>> adj;

    static class Shop implements Comparable<Shop> {
        int idx;
        int d;

        Shop (int idx, int d) {
            this.idx = idx;
            this.d = d;
        }

        @Override
        public int compareTo(Shop o) {
            return this.d - o.d;
        }
    }

    public static int dijkstra(int s, int e) {
        PriorityQueue<Shop> que = new PriorityQueue<>();

        dist = new int[N];
        for (int i=0; i<N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        que.offer(new Shop(s, 0));
        dist[s] = 0;

        while (!que.isEmpty()) {

            Shop now = que.poll();
            if (dist[now.idx] < now.d) {
                continue;
            }

            for (int[] next : adj.get(now.idx)) {
                if (dist[next[0]] > now.d + next[1]) {
                    dist[next[0]] = now.d + next[1];
                    que.add(new Shop(next[0], dist[next[0]]));
                }
            }
        }

        return dist[e];
    }

    public static void dfs(int level, int[] order) {
        if (level == S) {
            long tmp = 0;
//            for (int o : order) {
//                System.out.print(o + " ");
//            }
//            System.out.println();
            for (int i=0; i<S+1; i++) {
                tmp += distStore[order[i]][order[i+1]];
            }
            if (result > tmp) {
                result = tmp;
            }
            return;
        }

        for (int i=1; i<=S; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            order[level+1] = i;
            dfs(level+1, order);
            order[level+1] = 0;
            visited[i] = false;
        }
    }

    static public void computeDist(int[] willVisit) {
        distStore = new int[S+1][S+1];
        for (int i=0; i<=S; i++) {
            for (int j=i+1; j<=S; j++) {
                int tmp = dijkstra(willVisit[i], willVisit[j]);
                distStore[i][j] = tmp;
                distStore[j][i] = tmp;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t=0; t<T; t++) {

            result = Long.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            adj = new ArrayList<>();
            for (int i=0; i<N; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                adj.get(s).add(new int[]{e, d});
                adj.get(e).add(new int[]{s, d});
            }

            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            willVisit = new int[S+1];

            for (int i=0; i<S; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                willVisit[i+1] = s;
            }

            computeDist(willVisit);

            int[] order = new int[S+2];
            visited = new boolean[S+1];
            dfs(0, order);
            System.out.println(result);
        }
    }
}