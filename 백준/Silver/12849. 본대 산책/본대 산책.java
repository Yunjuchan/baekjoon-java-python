import java.io.*;
import java.util.*;
public class Main {

    static long MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int D = Integer.parseInt(br.readLine());
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);

        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(1).add(3);

        adj.get(2).add(0);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(2).add(4);

        adj.get(3).add(1);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(3).add(5);

        adj.get(4).add(2);
        adj.get(4).add(3);
        adj.get(4).add(5);
        adj.get(4).add(7);

        adj.get(5).add(3);
        adj.get(5).add(4);
        adj.get(5).add(6);

        adj.get(6).add(5);
        adj.get(6).add(7);

        adj.get(7).add(4);
        adj.get(7).add(6);

        long[][] dp = new long[8][D + 1];

        dp[0][0] = 1;

        for (int t = 0; t < D; t++) {
            for (int cur = 0; cur < 8; cur++) {
                for (int next : adj.get(cur)) {
                    dp[next][t + 1] = dp[next][t + 1] + dp[cur][t];
                    dp[next][t + 1] %= MOD;
                }
            }
        }

        System.out.println(dp[0][D]);
    }
}