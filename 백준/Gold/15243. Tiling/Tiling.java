import java.io.*;
import java.util.*;

public class Main {

    static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int W = Integer.parseInt(br.readLine());
        if (W % 2 == 1) {
            System.out.println(0);
            return;
        }
        long[] dp = new long[W + 1];
        dp[2] = 3;
        if (W >= 4) {
            dp[4] = 11;
        }

        for (int i = 6; i <= W; i+= 2) {
            dp[i] = (4 * dp[i - 2] - dp[i - 4] + MOD) % MOD;
        }

        System.out.println(dp[W]);
    }
}