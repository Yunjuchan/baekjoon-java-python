import java.io.*;
import java.util.*;

public class Main {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(dp[i], dp[i - 1]);
            if (i + T - 1 > N) {
                continue;
            }
            dp[i + T - 1] = Math.max(dp[i + T - 1], dp[i - 1] + P);
        }

//        for (int i = 0; i <= N; i++) {
//            System.out.print(dp[i] + " ");
//        }
//        System.out.println();
        System.out.println(dp[N]);
    }
}