import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int mod = 1000000009;
        long[][] dp = new long[2][100001];
        dp[0][1] = 1;
        dp[0][2] = 1;
        dp[1][2] = 1;
        dp[0][3] = 2;
        dp[1][3] = 2;

        for (int i=4; i<=100000; i++) {
            dp[0][i] = (dp[1][i-1] + dp[1][i-2] + dp[1][i-3]) % mod;
            dp[1][i] = (dp[0][i-1] + dp[0][i-2] + dp[0][i-3]) % mod;
        }

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[0][n]).append(" ").append(dp[1][n]).append("\n");
        }

        System.out.print(sb.toString());
    }
}

