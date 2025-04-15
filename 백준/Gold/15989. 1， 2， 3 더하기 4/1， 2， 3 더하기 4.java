import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] dp = new int[10001];
        dp[0] = 1;
        for (int weight : new int[]{1, 2, 3}) {
            for (int i = weight; i <= 10000; i++) {
                dp[i] = (dp[i] + dp[i - weight]);
            }
        }
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }
    }
}