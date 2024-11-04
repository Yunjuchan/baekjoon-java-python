import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] grapes = new int[N];
        int[][] dp = new int[N][3];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            grapes[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = 0;
        dp[0][1] = grapes[0];
        dp[0][2] = 0;

        for (int i=1; i<N; i++) {
            dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
            dp[i][1] = dp[i-1][0] + grapes[i];
            dp[i][2] = dp[i-1][1] + grapes[i];
        }

        int max = Math.max(dp[N-1][0], Math.max(dp[N-1][1], dp[N-1][2]));
        System.out.println(max);
    }
}