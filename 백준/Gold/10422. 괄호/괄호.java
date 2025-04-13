import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long[] dp = new long[2501];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= 2500; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
                dp[i] %= MOD;
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int L = Integer.parseInt(br.readLine());
            if (L % 2 == 1) {
                System.out.println(0);
            } else {
                System.out.println(dp[L / 2]);
            }
        }

    }
}