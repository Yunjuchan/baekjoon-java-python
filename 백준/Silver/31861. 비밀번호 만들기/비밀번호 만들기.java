import java.io.*;
import java.util.*;

public class Main {

    public static int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] dp = new int[M+1][26];
        for (int i=0; i<26; i++) {
            dp[1][i] = 1;
        }

        for (int i=1; i<M; i++) {
            for (int j=0; j<26; j++) {
                for (int k=0; k<26; k++) {
                    if (Math.abs(j - k) >= N) {
                        dp[i+1][k] += dp[i][j];
                        dp[i+1][k] %= MOD;
                    }
                }
            }
        }

        int result = 0;
        for (int i=0; i<26; i++) {
            result += dp[M][i];
            result %= MOD;
        }

        System.out.println(result);
    }
}