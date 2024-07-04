import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static int order;
    static long[] depth;
    static long[] t;

    static boolean[] visited;

    static List<List<Integer>> adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        depth = new long[N+1];
        t = new long[N+1];
        visited = new boolean[N+1];

        adj = new ArrayList<>();

        for (int i=0; i<=N; i++) {
            depth[i] = 0;
            t[i] = -1;
            adj.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // 내림차순 정렬
        for (int i=1; i<=N; i++) {
            adj.get(i).sort((a, b) -> b - a);
        }
        order = 1;
        dfs(R, 0);
        long result = 0;
        for (int i=1; i<=N; i++) {
            result += depth[i]*t[i];
        }
        System.out.println(result);
    }

    public static void dfs(int now, int d) {
        visited[now] = true;
        depth[now] = d;
        t[now] = order;
        order++;
        for (int next : adj.get(now)) {
            if (visited[next]) { continue; }
            dfs(next, d+1);
        }
    }
}