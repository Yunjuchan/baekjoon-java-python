import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] dp;
    static List<List<Integer>> adj;

    public static void dfs(int x, int prev) {
        dp[x][1] = 1;

        for (int next : adj.get(x)) {
            if (next == prev) {
                continue;
            }

            dfs(next, x);
            dp[x][0] += dp[next][1];
            dp[x][1] += Math.min(dp[next][0], dp[next][1]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        adj = new ArrayList<>();
        dp = new int[N+1][2];

        for (int i=0; i<=N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dfs(1, -1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
}