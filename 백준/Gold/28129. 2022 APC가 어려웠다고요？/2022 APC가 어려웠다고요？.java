import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int MOD = 1_000_000_007;
        long[][] dp = new long[N][3001];
        int[][] arr = new int[N][2];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=arr[0][0]; i<=3000; i++) {
            dp[0][i] = dp[0][i-1] + (i <= arr[0][1] ? 1 : 0);

        }

        for (int i=1; i<N; i++) {
            for (int j=arr[i][0]; j<=3000; j++) {
                int min = Math.max(0, j-K-1);
                int max = Math.min(3000, j+K);

                dp[i][j] = dp[i][j-1] + (j <= arr[i][1] ? (dp[i-1][max] - dp[i-1][min] + MOD) % MOD : 0);
                dp[i][j] %= MOD;
            }
        }


        long result = dp[N-1][arr[N-1][1]] - dp[N-1][arr[N-1][0]-1];
        result %= MOD;
        System.out.println(result);
    }
}