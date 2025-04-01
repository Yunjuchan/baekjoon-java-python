import java.io.*;
import java.util.*;

public class Main {

    static final int MOD = 1_000_000_000;

//    public static int combination(int N, int K) {
//        K = Math.min(K, N - K);
//
//        double result = 1;
//
//        for (int i = 1; i <= K; i++) {
//            result *= (double) (N - K + i) / i;
//            result %= MOD;
//        }
//        return (int) result;
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[K + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            dp[1][i] = 1;
        }

        for (int k = 2; k <= K; k++) {
            for (int n = 0; n <= N; n++) {
                for (int x = 0; x <= n; x++) {
                    dp[k][n] = (dp[k][n] + dp[k - 1][n - x]) % MOD;
                }
            }
        }

        System.out.println(dp[K][N]);

//        System.out.println(combination(N + K - 1, K - 1));
    }
}
