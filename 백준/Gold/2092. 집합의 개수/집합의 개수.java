import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] arr = new int[T + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[x]++;
        }

        int[][] dp = new int[T+1][A+1];
        dp[0][0] = 1;

        for (int i = 1; i <= T; i++) {
            for (int j=1; j<=arr[i]; j++) {
                dp[i][j] += 1;
            }

            for (int j = 1; j <= B; j++) {
                dp[i][j] += dp[i - 1][j];
                for (int k = 1; k <= Math.min(j-1, arr[i]); k++) {
                    dp[i][j] += dp[i - 1][j - k];
                    dp[i][j] %= MOD;
                }
            }
        }

        int result = 0;
        for (int k = S; k <= B; k++) {
            result = (result + dp[T][k]) % MOD;
        }

        System.out.println(result);
    }
}