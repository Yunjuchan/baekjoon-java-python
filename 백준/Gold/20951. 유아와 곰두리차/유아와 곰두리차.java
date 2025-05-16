import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[8][N + 1];
        Arrays.fill(dp[0], 1);

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for (int i = 0; i < 7; i++) {
            for (int j = 1; j <= N; j++) {
                for (int next : adj.get(j)) {
                    dp[i + 1][next] += dp[i][j];
                    dp[i + 1][next] %= MOD;
                }
            }
        }
        int result = 0;
        for (int i = 1; i <= N; i++) {
            result += dp[7][i];
            result %= MOD;
        }
        System.out.println(result);
    }
}